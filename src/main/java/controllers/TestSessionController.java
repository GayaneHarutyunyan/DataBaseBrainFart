package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import services.TestSessionService;

@Controller
@RequestMapping(value = "/...")
public class TestSessionController {


    @Autowired
    @Qualifier("testSessionService")
    private TestSessionService testSessionService;

    public TestSessionController() {
    }
}
