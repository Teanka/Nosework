package pl.coderslab.competition;

import pl.coderslab.dogs.Dog;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COMPETITION")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(length = 13)
    CompetitionType competitionType;
    public enum CompetitionType {
        TEREN, POMIESZCZENIA, PRZEDMIOTY, POJAZDY
    }
    private LocalTime hour;
    @OneToMany
    private List<Dog> dogs = new ArrayList<>();
    private LocalDate competitionDate;
    private boolean pastCompetition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompetitionType getCompetitionType() {
        return competitionType;
    }

    public void setCompetitionType(CompetitionType competitionType) {
        this.competitionType = competitionType;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }


    public boolean isPastCompetition() {
        return pastCompetition;
    }

    public void setPastCompetition(boolean pastCompetition) {
        this.pastCompetition = pastCompetition;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    public LocalDate getCompetitionDate() {
        return competitionDate;
    }

    public void setCompetitionDate(LocalDate competitionDate) {
        this.competitionDate = competitionDate;
    }

}
