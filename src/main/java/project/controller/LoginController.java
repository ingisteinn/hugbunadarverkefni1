package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.Exercise;
import project.persistence.entities.PostitNote;
import project.persistence.entities.User;
import project.service.ExerciseService;


@Controller
public class LoginController {

    // Instance Variables
    private ExerciseService exerciseService;

    // Dependency Injection
    @Autowired
    public LoginController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    // Request mapping is the path that you want to map this method to
    // In this case, the mapping is the root "/", so when the project
    // is running and you enter "localhost:8080" into a browser, this
    // method is called
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginViewGet(Model model){

        model.addAttribute("login", new User());

        // Return the view
        return "Login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginViewPost(Model model){

        model.addAttribute("login", new User());

        // Return the view
        return "Login";
    }
}
