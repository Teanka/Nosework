package pl.coderslab.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dogs.Dog;
import pl.coderslab.dogs.DogCompResService;
import pl.coderslab.dogs.DogCompetitionResult;
import pl.coderslab.dogs.DogService;
import pl.coderslab.judges.Judge;
import pl.coderslab.judges.JudgeService;
import pl.coderslab.users.UserService;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/events")
@Controller
public class EventController {

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

//    @ModelAttribute("event")
//    Event getEvent(Long id) {
//        return eventService.find(id);
//    }

    @GetMapping("/{id}")
    public String eventHome(Model model, @PathVariable Long id){
        Event event = eventService.find(id);
        DogCompetitionResult dogResult = new DogCompetitionResult();
        dogResult.setEvent(event);
//        model.addAttribute("event", event);
        model.addAttribute("dogResult", dogResult);
        return "eventHome";
    }

    @PostMapping("/{id}")
    public String eventHomePost(@ModelAttribute @Valid DogCompetitionResult dogResult, BindingResult result, @PathVariable Long id){
        if(result.hasErrors()) {
            return "failure";
        }
        Dog verifiedDog = null;
        List<Dog> dogs = dogService.findByName(dogResult.getDog().getName());
        Event event = eventService.find(id);
        for(Dog dog:dogs){
            if(dog.getUser().getEmail().equals(dogResult.getDog().getUser().getEmail())){
                verifiedDog = dog;
            }
        }
        if((dogResult.getDog().isScentTestsPassed())||(dogResult.getCompetitionType().equals("scentTests")));
        DogCompetitionResult dogFinalRes = new DogCompetitionResult(verifiedDog, event, dogResult.getCompetitionType());
        dogResultService.save(dogFinalRes);
        return "success";
    }

    @GetMapping("/add")
    public String events(Model model){
        model.addAttribute("event", new Event());
        model.addAttribute("judges", getJudges());
        return "addEvent";
    }

    @PostMapping("/add")
    public String eventsPost(@ModelAttribute @Valid Event event, BindingResult result){
        if(result.hasErrors()) {
           return "addEvent";
        }
        if(event.isContainers()||event.isExterior()||event.isInterior()||event.isVehicle())
            event.setExams(true);
        eventService.save(event);
        return "redirect:../";
    }

}
