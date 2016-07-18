package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import services.SubjectService;

@Controller
@RequestMapping(value = "/...")
public class SubjectController {

    @Autowired
    @Qualifier("subjectService")
    private SubjectService subjectService;

    public SubjectController() {
    }
}
