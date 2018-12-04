package pl.coderslab.app;

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
        if (event.isContainers() || event.isExterior() || event.isInterior() || event.isVehicle()) {
            event.setExams(true);
        }
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
        return "redirect:../";
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
        return "redirect:../";
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

    @GetMapping("/{id}")
    public String eventResults(Model model, @PathVariable Long id) {
        Event event = eventService.findWithResults(id);
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
        return "adminEventResultList";
    }

    @GetMapping("{eId}/delete/{id}")
    public String deleteResult(@PathVariable Long eId, @PathVariable Long id){
        dogResultService.delete(id);
        return "redirect:/";
    }

    @GetMapping("{eId}/edit/{id}")
    public String editResult(Model model, @PathVariable Long id){
        DogCompetitionResult dogResult = dogResultService.find(id);
        model.addAttribute("dogResult", dogResult);
        return "editDogRes1";
    }

    @PostMapping("{eId}/edit/{id}")
    public String editResultPost(@PathVariable Long id, @ModelAttribute @Valid DogCompetitionResult dogResult, BindingResult result){
//        if(result.hasErrors()){
//            return "editDogRes1";
//        }
        if(dogResult.getId()==null){
            dogResult.setId(id);
        }
        Dog dog = dogResult.getDog();
        List<DogCompetitionResult> dogsResults= dog.getResults();
        dogsResults.add(dogResult);
        dog.setResults(dogsResults);
        if(dogResult.getCompetitionType().equals("scentTests")&dogResult.getPoints()==1){
            dog.setScentTestsPassed(true);
        }
        if(dogResult.getPoints()>0){
            int points = dog.getPoints();
            points+=dogResult.getPoints();
            dog.setPoints(points);
        }
        dogService.update(dog);
        dogResultService.update(dogResult);
        return "redirect:../";
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
