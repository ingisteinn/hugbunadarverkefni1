package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;
import project.service.UserService;
import project.persistence.entities.User;

@Controller
public class RegisterController {
    private UserService userService;


    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerViewGet(Model model) {
        // Add a empty instance of User to model
        model.addAttribute("register", new User());

        return "Register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerViewPost(@ModelAttribute("register") User user, Model model){
        //Check if username is taken
        User registeredUser = this.userService.findOne(user.getUsername());
        if(registeredUser != null) {
            model.addAttribute("error", "Username taken");
            return "Register";
        }

        //Save new user to db
        this.userService.save(user);
        // Return the view
        return "redirect:login";
    }

}

