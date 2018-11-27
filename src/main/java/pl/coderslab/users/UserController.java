package pl.coderslab.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "user";
    }

    @PostMapping("/add")
    public String addPost(@ModelAttribute @Valid User user, BindingResult result){
        if(result.hasErrors()){
            return "user";
        }
        userService.save(user);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        List<User> users = userService.findAll();//powinno być find all którzy są na te zawody (albo i nie, to może być DogStatus czy coś
        model.addAttribute("users", users);
        return "userList";
    }
}
