package pl.coderslab.dogs;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.app.Age;
import pl.coderslab.users.User;

import javax.persistence.*;
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
    @Age
    private double age;
    @NotBlank
    private String idNumber;
    @ManyToOne
    private User user;
    private boolean scentTestsPassed;
    @OneToMany
    private List<DogCompetitionResult> results = new ArrayList<>();
    private int points;
    @NotEmpty
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

    public boolean isScentTestsPassed() {
        return scentTestsPassed;
    }

    public void setScentTestsPassed(boolean scentTestsPassed) {
        this.scentTestsPassed = scentTestsPassed;
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
