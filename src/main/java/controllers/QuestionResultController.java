package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import services.QuestionResultService;

@Controller
@RequestMapping(value = "/...")
public class QuestionResultController {

    @Autowired
    @Qualifier("questionResultService")
    private QuestionResultService questionResultService;

    public QuestionResultController() {
    }
}
