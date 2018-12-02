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

    /* WorkoutController has three methods.  One to get saved workouts and exercise and create initial empty instances
       In order to add a workout(that's not empty) to the database we first need to create a list of exercises which
       gets added to the workout.  When the workout has a defined list of exercises we can then send that workout to
       the database.  */

    @RequestMapping(value = "/workout", method = RequestMethod.GET)
    public String workoutViewGet(@ModelAttribute("workout") Workout workout, Model model, HttpSession session) {
        // If there's a defined session, get attribute from model Else create an empty workout instance to the model
        if(session.getAttribute("workout") != null) {
            model.addAttribute("workout", session.getAttribute("workout"));
            Workout w = (Workout)session.getAttribute("workout");

        // Else add an empty workout instance to the model
        } else {
            session.setAttribute("workout", new Workout());
            model.addAttribute("workout", new Workout());
        }

        // Create model for exercises added to workout
        model.addAttribute("exercise", new WorkoutExercise());

        // Retrieve all exercises from model in order to display the list of exercises
        model.addAttribute("exercises", exerciseService.findAll());


        // Retrieve the workouts for the logged in user
        User loggedInUser = (User)session.getAttribute("login");
        if(loggedInUser != null) {
            List<Workout> userWorkouts = workoutService.findByUserId(loggedInUser.getId());
            model.addAttribute("userWorkouts", userWorkouts);
        }
        return "Workout";
    }

    @RequestMapping(value = "/workout", method = RequestMethod.POST)
    public String workoutViewPost(Workout workout, Model model, HttpSession session) {
        // post method to add a new workout to database
        User loggedInUser = (User)session.getAttribute("login");
        Workout w = (Workout)session.getAttribute("workout");
        w.setName(workout.getName());
        w.setCategory(workout.getCategory());
        w.setUserId(loggedInUser.getId());

        // Create an arraylist to store userworkouts
        List<Workout> userWorkouts = new ArrayList<>();
        if(loggedInUser != null) {
            // retrieve all workouts created by the user
            userWorkouts = workoutService.findByUserId(loggedInUser.getId());
        }

        // add the new workout to the arraylist of workouts created by the user
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
        // Method to add exercises to a list which goes into a workout

        List<WorkoutExercise> listEx = new ArrayList<>();
        Workout workout = (Workout)session.getAttribute("workout");

        // Get exercises previously added to the workout (if there are any)
        if(workout.getExercises() != null) {
            listEx = workout.getExercises();
        }

        // Add list to model
        String exName = exerciseService.findOne(ex.getId()).getName();
        ex.setName(exName);
        ex.setId(null);
        WorkoutExercise saveWork = workoutExerciseService.save(ex);
        listEx.add(saveWork);
        workout.setExercises(listEx);

        // Add workout to session
        session.setAttribute("workout", workout);

        // Redirect to workout
        return "redirect:workout";
    }
}
