package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.Exercise;
import project.service.ExerciseService;


@Controller
public class ExerciseController {

    // Instance Variables
    private ExerciseService exerciseService;

    // Dependency Injection
    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexViewGet(Model model){

        return "Index";
    }

    @RequestMapping(value = "/category/{cat}", method = RequestMethod.GET)
    public String getExerciseByName(@PathVariable String cat, Model model){

        // Get all exercises in category and add them to the model
        model.addAttribute("exercises", exerciseService.findByCategory(cat));
        // Add the name of the category to the model
        model.addAttribute("category", cat);

        // Return the view
        return "Category";
    }

    // To call this method, enter "localhost:8080/user" into a browser
    @RequestMapping(value = "/exercise", method = RequestMethod.GET)
    public String exerciseViewGet(Model model){
        model.addAttribute("exercise", new Exercise());
        model.addAttribute("exercises", exerciseService.findAll());

        return "Exercise";
    }

    @RequestMapping(value = "/exercise", method = RequestMethod.POST)
    public String exerciseViewPost(@ModelAttribute("exercise") Exercise exercise, Model model){
        //Save exercise to database
        this.exerciseService.save(exercise);
        model.addAttribute("success", "Exercise was added");
        model.addAttribute("exercise", new Exercise());
        //Add all exercises to model
        model.addAttribute("exercises", exerciseService.findAll());
        return "Exercise";
    }
}