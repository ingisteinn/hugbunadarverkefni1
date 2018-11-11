package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.Progress;
import project.persistence.entities.User;
import project.service.ExerciseService;
import project.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    private UserService userService;
    private ExerciseService exerciseService;

    @Autowired
    public UserController(UserService userService, ExerciseService exerciseService) {
        this.userService = userService;
        this.exerciseService = exerciseService;
    }

    @RequestMapping(value = "/progress", method = RequestMethod.GET)
    public String progressViewGet(HttpSession session, Model model) {
        // Get logged in user from session
        User loggedInUser = (User)session.getAttribute("login");
        if(loggedInUser != null) {
            // Get logged in users progress
            List<Progress> userProgress = userService.findByUserId(loggedInUser.getId());
            // Add logged in users progress to model
            model.addAttribute("progress", userProgress);
        }
        // Add all exercises to model
        model.addAttribute("exercises", exerciseService.findAll());
        // Add a empty instance of Progress to model
        model.addAttribute("newProgress", new Progress());
        return "Progress";
    }

    @RequestMapping(value = "/progress", method = RequestMethod.POST)
    public String progressViewPost(@ModelAttribute("newProgress") Progress progress, HttpSession session, Model model) {
        // Get logged in user from session
        User loggedInUser = (User)session.getAttribute("login");
        progress.setUserId(loggedInUser.getId());
        userService.saveProgress(progress);
        if(loggedInUser != null) {
            // Get logged in users progress
            List<Progress> userProgress = userService.findByUserId(loggedInUser.getId());
            // Add logged in users progress to model
            model.addAttribute("progress", userProgress);
        }
        // Add all exercises to model
        model.addAttribute("exercises", exerciseService.findAll());
        // Add a empty instance of Progress to model
        model.addAttribute("newProgress", new Progress());
        return "Progress";
    }
}
