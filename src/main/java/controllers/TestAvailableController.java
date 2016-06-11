package controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import services.TestAvailabilityService;

@Controller
@RequestMapping(value = "/...")
public class TestAvailableController {


    @Autowired
    @Qualifier("testAvailabilityService")
    private TestAvailabilityService testAvailabilityService;

    public TestAvailableController() {
    }
}
