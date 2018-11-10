package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.service.ExerciseService;
import project.service.UserService;

@Controller
public class UserController {
    private UserService userService;
    private ExerciseService exerciseService;

    @Autowired
    public UserController(UserService userService, ExerciseService exerciseService) {
        this.userService = userService;
        this.exerciseService = exerciseService;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String progressViewGet(Model model) {
        return "Workout";
    }
}
