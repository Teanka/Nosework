package pl.coderslab.dogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.users.User;
import pl.coderslab.users.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/dogs")
public class DogController {

    @Autowired
    private DogService dogService;

    @Autowired
    private UserService userService;


    @GetMapping("/add")
    public String addNewTeam(Model model){
        model.addAttribute("dog", new Dog());
        return "addTeam";
    }

    @PostMapping("/add")
    public String addNewTeamPost(@ModelAttribute @Valid Dog dog, BindingResult result){
        if(result.hasErrors()){
            return "addTeam";
        }
        User user = dog.getUser();
        userService.save(user);
        dogService.save(dog);
        return "success";
    }
}
