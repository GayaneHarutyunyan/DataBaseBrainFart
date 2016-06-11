package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import services.QuestionService;

@Controller
@RequestMapping(value = "/...")
public class QuestionController {


    @Autowired
    @Qualifier("questionService")
    private QuestionService questionService;

    public QuestionController() {
    }
}
