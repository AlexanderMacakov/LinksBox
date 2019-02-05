package TeamProjectJava.LinksBox.controller;

import TeamProjectJava.LinksBox.entity.Person;
import TeamProjectJava.LinksBox.repos.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RegistrationController {

    @Autowired
    private PersonRepo personRepo;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model){
        //TODO add logic to verify user
        personRepo.save(new Person(firstname, lastname, email, password));
        model.addAttribute("message", "User has been successfully added! Now you can login.");
        return "login";
    }
}
