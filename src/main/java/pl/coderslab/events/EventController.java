package pl.coderslab.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dogs.DogCompResService;
import pl.coderslab.dogs.DogCompetitionResult;
import pl.coderslab.judges.Judge;
import pl.coderslab.judges.JudgeService;

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

    @ModelAttribute("events")
    List<Event> getEvents() {
        return eventService.findAll();
    }

    @ModelAttribute("judges")
    List<Judge> getJudges() {
        return judgeService.findAll();
    }

    @GetMapping("/{id}")
    public String eventHome(Model model, @PathVariable Long id){
        Event event = eventService.find(id);
        DogCompetitionResult dogResult = new DogCompetitionResult();
        dogResult.setEvent(event);
        model.addAttribute("event", event);
        model.addAttribute("dogResult", dogResult);
        return "eventHome";
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
