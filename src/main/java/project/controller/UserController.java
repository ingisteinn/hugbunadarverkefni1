package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.Exercise;
import project.persistence.entities.Progress;
import project.persistence.entities.User;
import project.persistence.entities.Workout;
import project.service.ExerciseService;
import project.service.UserService;
import project.service.WorkoutService;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class UserController {
    private UserService userService;
    private ExerciseService exerciseService;
    private WorkoutService workoutService;

    @Autowired
    public UserController(UserService userService, ExerciseService exerciseService) {
        this.userService = userService;
        this.exerciseService = exerciseService;
    }

    @RequestMapping(value = "/progress", method = RequestMethod.GET)
    public String progressViewGet(HttpSession session, Model model) {
        // Get logged in user from session
        User loggedInUser = (User)session.getAttribute("login");
        if(loggedInUser != null) {
            // Get logged in users progress
            List<Progress> userProgress = userService.findByUserId(loggedInUser.getId());
            // Add logged in users progress to model
            model.addAttribute("progress", userProgress);
        }
        // Add all exercises to model
        model.addAttribute("exercises", exerciseService.findAll());
        // Add a empty instance of Progress to model
        model.addAttribute("newProgress", new Progress());
        return "Progress";
    }

    @RequestMapping(value = "/progress", method = RequestMethod.POST)
    public String progressViewPost(@ModelAttribute("newProgress") Progress progress, HttpSession session, Model model) {
        // Get logged in user from session
        User loggedInUser = (User)session.getAttribute("login");
        progress.setUserId(loggedInUser.getId());
        userService.saveProgress(progress);
        if(loggedInUser != null) {
            // Get logged in users progress
            List<Progress> userProgress = userService.findByUserId(loggedInUser.getId());
            // Add logged in users progress to model
            model.addAttribute("progress", userProgress);
        }
        // Add all exercises to model
        model.addAttribute("exercises", exerciseService.findAll());
        // Add a empty instance of Progress to model
        model.addAttribute("newProgress", new Progress());
        return "Progress";
    }

    @RequestMapping(value = "/chart", method = RequestMethod.GET)
    public String progressViewPost( HttpSession session, ModelMap modelMap, Model model) {
        User loggedInUser = (User)session.getAttribute("login");
        if(loggedInUser != null) {
            List<List<Map<Object, Object>>> chartData = userService.getChartData(loggedInUser.getId());
            //List<Progress> chartData = userService.findByUserId(loggedInUser.getId());
            modelMap.addAttribute("dataPointsList", chartData);
            //Get logged in user's progress
            List<Progress> userProg = userService.findByUserId(loggedInUser.getId());
            List<Exercise> userExercises = new ArrayList<Exercise>();
            for (Progress p: userProg) {
                //Add each exercise in user progress to exercise list if it is not already in the list
                Exercise e = exerciseService.findOne(p.getExerciseId());
                if(!userExercises.contains(e)) {
                    userExercises.add(e);
                }
            }
            model.addAttribute("exercises", userExercises);
            model.addAttribute("newProgress", new Progress());
        }
        return "Chart";
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public String scheduleViewGet(HttpSession session, Model model) {
        // Get logged in user from session
        User loggedInUser = (User)session.getAttribute("login");
        if(loggedInUser != null) {
            // Get logged in users progress
            List<Workout> userWorkouts = workoutService.findAll();
            // Add logged in users progress to model
            model.addAttribute("workout", userWorkouts);
        }
        return "Schedule";
    }

    /*
    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public String scheduleViewGet(Model model) {
        return "Schedule";
    }
    */
}
