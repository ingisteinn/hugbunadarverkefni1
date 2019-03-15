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

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginViewGet(Model model){
        // Add a empty instance of User to model
        model.addAttribute("login", new User());

        return "Login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginViewPost(@ModelAttribute("login") User login, HttpSession session, Model model){
//        User loggedInUser = this.userService.findOne(login.getUsername());
//        // Check if username exists and password matches
//        if(loggedInUser != null && loggedInUser.getPassword().equals(login.getPassword())) {
//            // Add logged in user to session
//            session.setAttribute("login", loggedInUser);
//            //Redirect to frontpage
//            return "redirect:";
//        } else {
//            // Error handling
//            model.addAttribute("error", "Wrong username and/or password");
//        }
        return "Login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session){
        //Remove login info from session
        session.removeAttribute("login");
        //Redirect to homepage
        return "redirect:";
    }
}
