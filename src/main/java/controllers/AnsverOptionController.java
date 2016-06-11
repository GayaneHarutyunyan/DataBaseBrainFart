package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import services.AnswerOptionService;

@Controller
@RequestMapping(value = "/...")
public class AnsverOptionController {

    @Autowired
    @Qualifier("answerOptionService")
    private AnswerOptionService answerOptionService;

    public AnsverOptionController() {
    }
}
