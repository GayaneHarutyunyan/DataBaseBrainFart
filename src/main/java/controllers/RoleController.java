package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import services.RoleService;

@Controller
@RequestMapping(value = "/...")
public class RoleController {

    @Autowired
    @Qualifier("roleService")
    private RoleService roleService;

    public RoleController() {
    }
}
