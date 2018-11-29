package pl.coderslab.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dogs.DogCompResService;
import pl.coderslab.dogs.DogService;
import pl.coderslab.events.Event;
import pl.coderslab.events.EventService;
import pl.coderslab.users.UserService;

import java.util.List;

@RequestMapping("/")
@Controller
public class HomeController {

    @Autowired
    private DogService dogService;

    @Autowired
    private UserService userService;

    @Autowired
    private EventService eventService;

    @Autowired
    private DogCompResService dogResService;

    @ModelAttribute("events")
    List<Event> getEvents() {
        return eventService.findAll();
    }

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

}
