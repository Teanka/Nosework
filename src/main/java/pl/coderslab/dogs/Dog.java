package pl.coderslab.dogs;

import org.hibernate.validator.constraints.NotBlank;
import pl.coderslab.event.Event;
import pl.coderslab.users.User;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
    @ManyToOne
    private List<DogCompetitionResult> results;
    private int points;

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


}
