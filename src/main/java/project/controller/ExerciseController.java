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

import java.util.List;

@Controller
public class ExerciseController {

    // Instance Variables
    private ExerciseService exerciseService;

    // Dependency Injection
    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    // Request mapping is the path that you want to map this method to
    // In this case, the mapping is the root "/", so when the project
    // is running and you enter "localhost:8080" into a browser, this
    // method is called
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexViewGet(Model model){
        model.addAttribute("chest", exerciseService.findByCategory("chest"));
        model.addAttribute("back", exerciseService.findByCategory("back"));
        model.addAttribute("legs", exerciseService.findByCategory("legs"));
        model.addAttribute("core", exerciseService.findByCategory("core"));
        model.addAttribute("arms", exerciseService.findByCategory("arms"));
        model.addAttribute("shoulders", exerciseService.findByCategory("shoulders"));
        return "Index";
    }

    // Method that returns the correct view for the URL /postit/{name}
    // The {name} part is a Path Variable, and we can reference that in our method
    // parameters as a @PathVariable. This enables us to create dynamic URLs that are
    // based on the data that we have.
    // This method finds all Postit Notes posted by someone with the requested {name}
    // and returns a list with all those Postit Notes.
    @RequestMapping(value = "/category/{cat}", method = RequestMethod.GET)
    public String getExerciseByName(@PathVariable String cat, Model model){

        // Get all Postit Notes with this name and add them to the model
        model.addAttribute("exercises", exerciseService.findByCategory(cat));

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
        this.exerciseService.save(exercise);
        model.addAttribute("success", "Exercise was added");
        model.addAttribute("exercise", new Exercise());
        model.addAttribute("exercises", exerciseService.findAll());
        return "Exercise";
    }
}