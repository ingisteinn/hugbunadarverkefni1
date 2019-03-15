package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.Exercise;
import project.service.ExerciseService;

import java.util.List;


@RestController
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

    @GetMapping("/category/{cat}")
    public List<Exercise> getExerciseByName(@PathVariable String cat, Model model){
        return exerciseService.findByCategory(cat);
    }
    
    @GetMapping("/exercise")
    public List<Exercise> exerciseViewGet(){
        return exerciseService.findAll();
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