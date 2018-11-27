package pl.coderslab.dogs;

import org.hibernate.validator.constraints.NotBlank;
import pl.coderslab.competition.Competition;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="DOGRESULTS")
public class DogCompetitionResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Dog dog;
    private String place;//bo może być DIS lub NB również
    private int points;
    @OneToOne
    private Competition competition;
    @NotBlank
    private LocalDate eventDate;

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

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }
}
