package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.User;
import project.service.UserService;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    // Instance Variables
    private UserService userService;

    // Dependency Injection
    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
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
    public String loginViewPost(@ModelAttribute("login") User login, HttpSession session, Model model){
        User loggedInUser = this.userService.findOne(login.getUsername());
        if(loggedInUser != null) {
            session.setAttribute("login", loggedInUser);
        }

        return "Login";
    }
}
