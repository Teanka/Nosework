package pl.coderslab.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.events.Event;
import pl.coderslab.events.EventService;

import java.util.List;

@RequestMapping("/")
@Controller
public class HomeController {



    @Autowired
    private EventService eventService;


    @ModelAttribute("events")
    List<Event> getEvents() {
        return eventService.findAll();
    }

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

}
