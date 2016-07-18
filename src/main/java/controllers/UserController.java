package controllers;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import services.UserService;

import java.util.List;

@Controller
@RequestMapping(value = "/...")
public class UserController {


    @Autowired
    @Qualifier("userService")
    private UserService userService;

    public UserController() {
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();

        List<User> users = userService.getAll();
        modelAndView.addObject("users", users);

        modelAndView.setViewName("users");
        return modelAndView;
    }
}
