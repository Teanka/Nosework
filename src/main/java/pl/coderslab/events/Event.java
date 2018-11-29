package pl.coderslab.events;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.dogs.DogCompetitionResult;
import pl.coderslab.judges.Judge;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EVENTS")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @NotBlank
    private String city;
    @NotBlank
    private String address;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate competitionDate;
    @Size(max=2000)
    private String description;
    @ManyToOne
    private Judge judge;
    @OneToMany
    private List<DogCompetitionResult> results = new ArrayList<>();

    private boolean scentTests;
    private boolean exams;
    private boolean exterior;
    private boolean interior;
    private boolean containers;
    private boolean vehicle;
    private boolean pastEvent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getCompetitionDate() {
        return competitionDate;
    }

    public void setCompetitionDate(LocalDate competitionDate) {
        this.competitionDate = competitionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPastEvent() {
        return pastEvent;
    }

    public void setPastEvent(boolean pastEvent) {
        this.pastEvent = pastEvent;
    }

    public boolean isScentTests() {
        return scentTests;
    }

    public boolean isExams() {
        return exams;
    }

    public void setExams(boolean exams) {
        this.exams = exams;
    }

    public void setScentTests(boolean scentTests) {
        this.scentTests = scentTests;
    }

    public boolean isExterior() {
        return exterior;
    }

    public void setExterior(boolean exterior) {
        this.exterior = exterior;
    }

    public boolean isInterior() {
        return interior;
    }

    public void setInterior(boolean interior) {
        this.interior = interior;
    }

    public boolean isContainers() {
        return containers;
    }

    public void setContainers(boolean containers) {
        this.containers = containers;
    }

    public boolean isVehicle() {
        return vehicle;
    }

    public void setVehicle(boolean vehicle) {
        this.vehicle = vehicle;
    }

    public Judge getJudge() {
        return judge;
    }

    public void setJudge(Judge judge) {
        this.judge = judge;
    }

    public List<DogCompetitionResult> getResults() {
        return results;
    }

    public void setResults(List<DogCompetitionResult> results) {
        this.results = results;
    }
}
