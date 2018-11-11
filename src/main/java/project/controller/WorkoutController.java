package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.Workout;
import project.service.ExerciseService;
import project.service.UserService;
import project.service.WorkoutService;

@Controller
public class WorkoutController {
    private WorkoutService workoutService;
    private ExerciseService exerciseService;
    private UserService userService;

    @Autowired
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    /*
     * Not implemented yet!
     */

    @RequestMapping(value = "/workout", method = RequestMethod.GET)
    public String workoutViewGet(Model model) {
        return "Workout";
    }

    @RequestMapping(value = "/workout", method = RequestMethod.POST)
    public String workoutViewGet(Workout workout, Model model) {
        return "Workout";
    }
}
