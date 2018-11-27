package pl.coderslab.dogs;

import org.hibernate.validator.constraints.NotBlank;
import pl.coderslab.event.Event;
import pl.coderslab.users.User;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="DOGS")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    private String officialName;
    private String breed;
    @NotNull
    private double age;
    private String idNumber;
    @ManyToOne
    private User user;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    Event.ScentTests scentTestsPassed;
    public enum ScentTestsPassed {
        CYNAMON, POMARAŃCZA, GOŹDZIK
    }
    @NotNull
    @Min(-1)
    @Max(2)
    private int classNo;
    @OneToMany
    private List<DogCompetitionResult> results = new ArrayList<>();
    private int points;
    private String gender;

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

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event.ScentTests getScentTestsPassed() {
        return scentTestsPassed;
    }

    public void setScentTestsPassed(Event.ScentTests scentTestsPassed) {
        this.scentTestsPassed = scentTestsPassed;
    }

    public int getClassNo() {
        return classNo;
    }

    public void setClassNo(int classNo) {
        this.classNo = classNo;
    }

    public List<DogCompetitionResult> getResults() {
        return results;
    }

    public void setResults(List<DogCompetitionResult> results) {
        this.results = results;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
