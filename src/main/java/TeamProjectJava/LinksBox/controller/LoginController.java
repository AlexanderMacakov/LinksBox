package TeamProjectJava.LinksBox.controller;

import TeamProjectJava.LinksBox.entity.Person;
import TeamProjectJava.LinksBox.repos.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private PersonRepo personRepo;

    @GetMapping("/login")
    private String login(){
        return "login";
    }

    @PostMapping("/login")
    private String loginUser(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model
    ){
        Person person = personRepo.findByEmail(email);
        if (person == null){
            model.addAttribute("errorEmail", "Invalid email entered.");
            return "login";
        }
        if (!person.getPassword().equals(password)){
            model.addAttribute("errorPassword", "Invalid password.");
            return "login";
        }
        model.addAttribute("message", "Welcome to program!");
        return "main";
    }
}
