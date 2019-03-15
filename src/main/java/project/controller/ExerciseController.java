package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.Exercise;
import project.persistence.entities.User;
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
    public List<Exercise> getExerciseByName(@PathVariable String cat){
        return exerciseService.findByCategory(cat);
    }

    @GetMapping("/exercise")
    public List<Exercise> exerciseViewGet(){
        return exerciseService.findAll();
    }

    @PostMapping("/exercise")
    public List<Exercise> exerciseViewPost(@RequestBody Exercise exercise){
        //Save exercise to database
        this.exerciseService.save(exercise);

        return exerciseService.findAll();
    }


}