package TeamProjectJava.LinksBox.controller;

import TeamProjectJava.LinksBox.entity.Person;
import TeamProjectJava.LinksBox.repos.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    @Autowired
    private PersonRepo personRepo;

    @GetMapping("/main/{personId}")
    private String main(Model model, @PathVariable Long personId){
        //TODO спорный момент - будет падать при левом id
        Person person = personRepo.findById(personId).get();
        model.addAttribute("catalogList", person.getCatalogs());
        return "main";
    }
}
