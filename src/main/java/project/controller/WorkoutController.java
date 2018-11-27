package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.Exercise;
import project.persistence.entities.Workout;
import project.service.ExerciseService;
import project.service.UserService;
import project.service.WorkoutService;

import java.util.List;

@Controller
public class WorkoutController {
    private WorkoutService workoutService;
    private ExerciseService exerciseService;
    private UserService userService;

    @Autowired
    public WorkoutController(WorkoutService workoutService, ExerciseService exerciseService, UserService userService) {
        this.workoutService = workoutService;
        this.exerciseService = exerciseService;
        this.userService = userService;
    }

    /*
     * Not implemented yet!
     */

    @RequestMapping(value = "/workout", method = RequestMethod.GET)
    public String workoutViewGet(Model model) {
        model.addAttribute("workout", new Workout());
        model.addAttribute("exercise", new Exercise());
        model.addAttribute("exercises", exerciseService.findAll());
        return "Workout";
    }

    @RequestMapping(value = "/workout", method = RequestMethod.POST)
    public String workoutViewPost(Workout workout, Model model) {
        this.workoutService.save(workout);

        model.addAttribute("exercises", exerciseService.findAll());
        return "Workout";
    }

    @RequestMapping(value = "/addExerciseToWorkout", method = RequestMethod.POST)
    public String workoutViewPostExercise(@ModelAttribute("exercise") Exercise ex, @ModelAttribute("workout") Workout workout, Model model) {
        List<Exercise> listEx = workout.getExercises();
        listEx.add(ex);
        workout.setExercises(listEx);

        model.addAttribute("workout", workout);
        model.addAttribute("exercises", exerciseService.findAll());
        return "redirect:workout";
    }
}
