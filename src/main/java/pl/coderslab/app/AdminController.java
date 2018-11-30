package pl.coderslab.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dogs.Dog;
import pl.coderslab.dogs.DogCompResService;
import pl.coderslab.dogs.DogService;
import pl.coderslab.email.MailSender;
import pl.coderslab.events.Event;
import pl.coderslab.events.EventService;
import pl.coderslab.judges.Judge;
import pl.coderslab.judges.JudgeService;
import pl.coderslab.users.User;
import pl.coderslab.users.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MailSender mailSender;

    @Autowired
    private EventService eventService;

    @Autowired
    private JudgeService judgeService;

    @Autowired
    private DogCompResService dogResultService;

    @Autowired
    private DogService dogService;

    @Autowired
    private UserService userService;

    @ModelAttribute("events")
    List<Event> getEvents() {
        return eventService.findAll();
    }

    @ModelAttribute("judges")
    List<Judge> getJudges() {
        return judgeService.findAll();
    }

    @GetMapping("/")
    public String mainAdmin() {
        return "menu";
    }

    @GetMapping("/addEvent")
    public String addEvents(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("judges", getJudges());
        return "addEvent";
    }

    @PostMapping("/addEvent")
    public String addEventsPost(@ModelAttribute @Valid Event event, BindingResult result) {
        if (result.hasErrors()) {
            return "addEvent";
        }
        if (event.isContainers() || event.isExterior() || event.isInterior() || event.isVehicle())
            event.setExams(true);
        eventService.save(event);
        return "redirect:../admin/";
    }

    @GetMapping("/addJudge")
    public String addJudge(Model model) {
        model.addAttribute("judge", new Judge());
        return "addJudge";
    }

    @PostMapping("/addJudge")
    public String addJudgePost(@ModelAttribute @Valid Judge judge, BindingResult result) {
        if (result.hasErrors()) {
            return "addJudge";
        }
        judgeService.save(judge);
        return "redirect:../admin/";
    }

    @GetMapping("/addUser")
    public String addNewUser(Model model){
        model.addAttribute("dog", new Dog());
        return "addTeam";
    }

    @PostMapping("/addUser")
    public String addNewUserPost(@ModelAttribute @Valid Dog dog, BindingResult result){
        if(result.hasErrors()){
            return "addTeam";
        }
        User user = dog.getUser();
        userService.save(user);
        dogService.save(dog);
        return "redirect:../admin/";
    }

    @GetMapping("/events")
    public String adminEventsList() {
        return "adminEventList";
    }
    @GetMapping("events/delete/{id}")
    public String deleteEvent(@PathVariable Long id){
        eventService.delete(id);
        return "redirect:../events";
    }

    @GetMapping("events/edit/{id}")
    public String editEvent(Model model, @PathVariable Long id){
        Event event = eventService.find(id);
        model.addAttribute(event);
        return "addEvent";
    }

    @PostMapping("events/edit/{id}")
    public String editEventPost(@PathVariable Long id, @ModelAttribute @Valid Event event, BindingResult result){
        if(result.hasErrors()){
            return "addEvent";
        }
        if(event.getId()==null){
            event.setId(id);
        }
        eventService.update(event);
        return "redirect:../../events";
    }


//    @GetMapping("/{id}/addResult")
//    public String eventAddResults(Model model, @PathVariable Long id) {
//        Event event = eventService.findWithResults(id);
//            model.addAttribute("event", event);
//        return "eventAddResult";
//    }
//    @GetMapping("/{id}/addResult")
//    public String eventAddResultsPost(@ModelAttribute Event event) {
//        List<DogCompetitionResult> results = event.getResults();
//        for(DogCompetitionResult result: results){
//            dogResultService.save(result);
//        }
//        return "success";
//    }
}
