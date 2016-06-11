package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Самый главный контроллер
 * Created by gaya on 11.06.2016.
 */
@Controller
public class HomeController {

    public HomeController() {

    }

    //какой то индексный метод который возвращает
    //который будет приходить по индексу
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();

        //какие то данный

        //создадим отоброжение
        modelAndView.setViewName("home.jsp");
        return modelAndView;
    }
}
