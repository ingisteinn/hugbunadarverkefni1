package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.Exercise;
import project.persistence.entities.User;
import project.persistence.entities.Workout;
import project.persistence.entities.WorkoutExercise;
import project.service.ExerciseService;
import project.service.UserService;
import project.service.WorkoutExerciseService;
import project.service.WorkoutService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WorkoutController {
    private WorkoutService workoutService;
    private ExerciseService exerciseService;
    private UserService userService;
    private WorkoutExerciseService workoutExerciseService;

    @Autowired
    public WorkoutController(WorkoutService workoutService, ExerciseService exerciseService, UserService userService, WorkoutExerciseService workoutExerciseService) {
        this.workoutService = workoutService;
        this.exerciseService = exerciseService;
        this.userService = userService;
        this.workoutExerciseService = workoutExerciseService;
    }

    /*
     * Not implemented yet!
     */

    @RequestMapping(value = "/workout", method = RequestMethod.GET)
    public String workoutViewGet(@ModelAttribute("workout") Workout workout, Model model, HttpSession session) {
        if(session.getAttribute("workout") != null) {
            model.addAttribute("workout", session.getAttribute("workout"));
            Workout w = (Workout)session.getAttribute("workout");

        } else {
            session.setAttribute("workout", new Workout());
            model.addAttribute("workout", new Workout());
        }

        model.addAttribute("exercise", new WorkoutExercise());
        model.addAttribute("exercises", exerciseService.findAll());
        User loggedInUser = (User)session.getAttribute("login");
        if(loggedInUser != null) {
            List<Workout> userWorkouts = workoutService.findByUserId(loggedInUser.getId());
            model.addAttribute("userWorkouts", userWorkouts);
        }
        return "Workout";
    }

    @RequestMapping(value = "/workout", method = RequestMethod.POST)
    public String workoutViewPost(Workout workout, Model model, HttpSession session) {
        User loggedInUser = (User)session.getAttribute("login");
        Workout w = (Workout)session.getAttribute("workout");
        w.setName(workout.getName());
        w.setCategory(workout.getCategory());
        w.setUserId(loggedInUser.getId());


        List<Workout> userWorkouts = new ArrayList<>();
        if(loggedInUser != null) {
            userWorkouts = workoutService.findByUserId(loggedInUser.getId());
        }

        Workout work = this.workoutService.save(w);
        userWorkouts.add(work);

        model.addAttribute("userWorkouts", userWorkouts);
        model.addAttribute("exercise", new WorkoutExercise());
        session.setAttribute("workout", new Workout());
        model.addAttribute("exercises", exerciseService.findAll());
        return "Workout";
    }

    @RequestMapping(value = "/addExerciseToWorkout", method = RequestMethod.POST)
    public String workoutViewPostExercise(@ModelAttribute("exercise") WorkoutExercise ex, Model model, HttpSession session) {
        List<WorkoutExercise> listEx = new ArrayList<>();
        Workout workout = (Workout)session.getAttribute("workout");
        if(workout.getExercises() != null) {
            listEx = workout.getExercises();
        }
        String exName = exerciseService.findOne(ex.getId()).getName();
        ex.setName(exName);
        ex.setId(null);
        WorkoutExercise saveWork = workoutExerciseService.save(ex);
        listEx.add(saveWork);
        workout.setExercises(listEx);
        
        session.setAttribute("workout", workout);
        return "redirect:workout";
    }
}
