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
    /*
    @Autowired
    private AdminService adminService;



  //  @RequestMapping(value = "/simple1")
 //    сообщаем, что данный контроллер будет обрабатывать запрос, URI которого "/simple1"

    @RequestMapping("/index")
    public String setupForm(Map<String, Object> map) {
        Admin admins = new Admin();
        map.put("admins", admins);
        map.put("adminsList", adminService.getAllAdmins());

//   - сообщаем Front-контроллеру,  что имя представления "admins"
   //     (по умолчанию, это файл /WEB-INF/views/admins.jsp).

        return "admins";
    }

    @RequestMapping(value = "/admins.do", method = RequestMethod.POST)

    public String doActions(@ModelAttribute Admin admins, BindingResult result, @RequestParam String action, Map<String, Object> map) {
        Admin adminsResult = new Admin();

        switch (action.toLowerCase()) {    //only in Java7 you can put String in switch
            case "add":
                adminService.addAdmins(admins);
                adminsResult = admins;
                break;
            case "edit":
                adminService.editAdmins(admins);
                adminsResult = admins;
                break;
            case "delete":
                adminService.delete(admins.getId());
                adminsResult = new Admin();
                break;
            case "search":
                Admin searchedAdmins = adminService.getAdmins(admins.getId());
                adminsResult = searchedAdmins != null ? searchedAdmins : new Admin();
                break;
        }
        map.put("admins", adminsResult);
        map.put("adminsList", adminService.getAllAdmins());

        //     - сообщаем Front-контроллеру,  что имя представления "admins"
      //  (по умолчанию, это файл /WEB-INF/views/admins.jsp).

        return "admins";
    }

    List<Admin> adminses =adminService.getAllAdmins();
*/
}
