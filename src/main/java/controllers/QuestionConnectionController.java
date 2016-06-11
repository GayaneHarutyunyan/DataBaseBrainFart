package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import services.QuestionConnectionService;

@Controller
@RequestMapping(value = "/...")
public class QuestionConnectionController {

    @Autowired
    @Qualifier("questionConnectionService")
    private QuestionConnectionService questionConnectionService;

    public QuestionConnectionController() {
    }
}
