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
import pl.coderslab.email.MailSender;
import pl.coderslab.judges.Judge;
import pl.coderslab.judges.JudgeService;
import pl.coderslab.users.UserService;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/events")
@Controller
public class EventController {

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

//    @ModelAttribute("event")
//    Event getEvent(Long id) {
//        return eventService.find(id);
//    }

    @GetMapping("/{id}")
    public String eventHome(Model model, @PathVariable Long id) {
        Event event = eventService.find(id);
        DogCompetitionResult dogResult = new DogCompetitionResult();
        dogResult.setEvent(event);
//        model.addAttribute("event", event);
        model.addAttribute("dogResult", dogResult);
        return "eventHome";
    }

    @PostMapping("/{id}")
    public String eventHomePost(@ModelAttribute @Valid DogCompetitionResult dogResult, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return "failure";
        }
        Dog verifiedDog = null;
        List<Dog> dogs = dogService.findByName(dogResult.getDog().getName());
        Event event = eventService.find(id);
        if(dogs!=null&&!dogs.isEmpty()) {
            for (Dog dog : dogs) {
                if (dog.getUser().getEmail().equals(dogResult.getDog().getUser().getEmail())) {
                    verifiedDog = dog;
                }
            }
        } else {
            return "failure";
        }
        if ((dogResult.getDog().isScentTestsPassed()) || (dogResult.getCompetitionType().equals("scentTests"))) ;
        DogCompetitionResult dogFinalRes = new DogCompetitionResult(verifiedDog, event, dogResult.getCompetitionType());
        dogResultService.save(dogFinalRes);
        String from = "atrol@poczta.onet.pl";
        String to = dogFinalRes.getDog().getUser().getEmail();
        String subject = dogFinalRes.getEvent().getName();
        String msg = "Gratuluję pomyślnego zapisania się na "+dogFinalRes.getEvent().getName()+" w konkurencji " +
                dogFinalRes.getCompetitionType() +". \n Wpłatę w wysokości 40 zł prosimy wysłać na konto: \n" +
                "6786567436768789088988 YYY xxxx PKO Bank Polski. \n Życzymy udanego staru w zawodach! \n Zespół Liga Nosework.";

        mailSender.sendMail(from, to, subject, msg);
        return "success";
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

    @GetMapping("/{id}/result")
    public String eventResults(Model model, @PathVariable Long id) {
        Event event = eventService.findWithResults(id);
        if (!event.isPastEvent()) {
            return "notYet";
        }
        List<DogCompetitionResult> tests = dogResultService.findByCompetitionTypeAndEventId("scentTests", id);
        if (tests != null && !tests.isEmpty()) {
            model.addAttribute("tests", tests);
        }
        List<DogCompetitionResult> interior = dogResultService.findByCompetitionTypeAndEventId("interior", id);
        if (interior != null && !interior.isEmpty()) {
            model.addAttribute("interior", interior);
        }
        List<DogCompetitionResult> exterior = dogResultService.findByCompetitionTypeAndEventId("exterior", id);
        if(exterior!=null&&!exterior.isEmpty()) {
            model.addAttribute("exterior", exterior);
        }
        List<DogCompetitionResult> containers = dogResultService.findByCompetitionTypeAndEventId("containers", id);
        if(containers!=null&&!containers.isEmpty()) {
            model.addAttribute("containers", containers);
        }
        List<DogCompetitionResult> vehicle = dogResultService.findByCompetitionTypeAndEventId("vehicle", id);
        if(vehicle!=null&&!vehicle.isEmpty()) {
            model.addAttribute("vehicle", vehicle);
        }
        return "eventResult";
    }

    @GetMapping("/lastResult")
    public String getLastResult(Model model){
        Event event = eventService.getLastPastEvent();
        List<DogCompetitionResult> tests = dogResultService.findByCompetitionTypeAndEventId("scentTests", event.getId());
        if (tests != null && !tests.isEmpty()) {
            model.addAttribute("tests", tests);
        }
        List<DogCompetitionResult> interior = dogResultService.findByCompetitionTypeAndEventId("interior", event.getId());
        if (interior != null && !interior.isEmpty()) {
            model.addAttribute("interior", interior);
        }
        List<DogCompetitionResult> exterior = dogResultService.findByCompetitionTypeAndEventId("exterior", event.getId());
        if(exterior!=null&&!exterior.isEmpty()) {
            model.addAttribute("exterior", exterior);
        }
        List<DogCompetitionResult> containers = dogResultService.findByCompetitionTypeAndEventId("containers", event.getId());
        if(containers!=null&&!containers.isEmpty()) {
            model.addAttribute("containers", containers);
        }
        List<DogCompetitionResult> vehicle = dogResultService.findByCompetitionTypeAndEventId("vehicle", event.getId());
        if(vehicle!=null&&!vehicle.isEmpty()) {
            model.addAttribute("vehicle", vehicle);
        }
        return "eventResult";
    }


    @GetMapping("/add")
    public String events(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("judges", getJudges());
        return "addEvent";
    }

    @PostMapping("/add")
    public String eventsPost(@ModelAttribute @Valid Event event, BindingResult result) {
        if (result.hasErrors()) {
            return "addEvent";
        }
        if (event.isContainers() || event.isExterior() || event.isInterior() || event.isVehicle())
            event.setExams(true);
        eventService.save(event);
        return "redirect:../";
    }

}
