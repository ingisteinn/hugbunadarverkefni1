package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.Exercise;
import project.persistence.entities.Progress;
import project.persistence.entities.User;
import project.persistence.entities.Workout;
import project.service.ExerciseService;
import project.service.UserService;
import project.service.WorkoutService;
import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
public class UserController {
    private UserService userService;
    private ExerciseService exerciseService;
    private WorkoutService workoutService;

    @Autowired
    public UserController(UserService userService, ExerciseService exerciseService, WorkoutService workoutService) {
        this.userService = userService;
        this.exerciseService = exerciseService;
        this.workoutService = workoutService;
    }

    @GetMapping("/user")
    public List<User> getUser(@RequestParam(value="username") String username) {
        if(username.length()>0){
            return userService.findOne(username);
        }
        return userService.findAll();

    }

    @GetMapping("/progress")
    public List<Progress> progressGet(@RequestParam(value="uid") Long uid) {
        // Get logged in user from session
//        User loggedInUser = (User)session.getAttribute("login");
//        if(loggedInUser != null) {
//            // Get logged in users progress
//            List<Progress> userProgress = userService.findByUserId(loggedInUser.getId());
//            // Add logged in users progress to model
//            return userService.findByUserId(loggedInUser.getId());
//        }

        return userService.findByUserId(uid);
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

    //Controller for Analysis page
    @RequestMapping(value = "/chart", method = RequestMethod.GET)
    public String progressViewPost( HttpSession session, ModelMap modelMap, Model model) {
        // Get logged in user from session
        User loggedInUser = (User)session.getAttribute("login");
        if(loggedInUser != null) {
            List<List<Map<Object, Object>>> chartData = userService.getChartData(loggedInUser.getId());
            // Add the data for the chart to the modelMap
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
        }
        return "Chart";
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public String scheduleViewGet(HttpSession session, Model model) {
//        // Get logged in user from session
//        User loggedInUser = (User)session.getAttribute("login");
//        if(loggedInUser != null) {
//            // Get logged in users progress
//            User user = userService.findOne(loggedInUser.getUsername());
//            List<Workout> userWorkouts = workoutService.findByUserId(user.getId());
//            // Add logged in users progress to model
//            model.addAttribute("workout", userWorkouts);
//        }
//        model.addAttribute("newWorkout", new Workout());
        return "Schedule";
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.POST)
    public String scheduleViewPost(@ModelAttribute("newWorkout") Workout workout, Model model, HttpSession session) {
//        //Get workout from database
//        Workout w = workoutService.findOne(workout.getId());
//        //Delete workout from database
//        workoutService.delete(w);
//        //Set the new id of the workout
//        w.setDate(workout.getDate());
//        //Save the workout to database with new id
//        workoutService.save(w);
//        // Get logged in user from session
//        User loggedInUser = (User)session.getAttribute("login");
//        if(loggedInUser != null) {
//            // Get logged in users progress
//            User user = userService.findOne(loggedInUser.getUsername());
//            List<Workout> userWorkouts = workoutService.findByUserId(user.getId());
//            // Add logged in users progress to model
//            model.addAttribute("workout", userWorkouts);
//        }
//        model.addAttribute("newWorkout", new Workout());
        return "Schedule";
    }
}
