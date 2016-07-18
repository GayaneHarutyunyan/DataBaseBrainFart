package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import services.AdminService;

@Controller
@RequestMapping(value = "/...")
public class AdminController {


    @Autowired
    @Qualifier("adminService")
    private AdminService adminService;

    public AdminController() {

    }
}
