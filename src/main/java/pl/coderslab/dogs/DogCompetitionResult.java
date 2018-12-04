package pl.coderslab.dogs;

import pl.coderslab.events.Event;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="DOGRESULTS")
public class DogCompetitionResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Dog dog;
    private String place;//bo może być DIS lub NB również
    private int points;
    @ManyToOne(fetch=FetchType.EAGER)
    private Event event;
    private boolean paid;
    @NotNull
    private String competitionType;

//    public DogCompetitionResult() {
//    }

//    public DogCompetitionResult(Dog dog, Event event, String competitionType) {
//        this.dog = dog;
//        this.event = event;
//        this.competitionType = competitionType;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getCompetitionType() {
        return competitionType;
    }

    public void setCompetitionType(String competitionType) {
        this.competitionType = competitionType;
    }
}
