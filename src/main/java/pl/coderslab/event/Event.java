package pl.coderslab.event;

import pl.coderslab.competition.Competition;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EVENTS")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String address;
    private LocalDate competitionDate;

    //    private List<String> scentTests;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    ScentTests scentTests;
    public enum ScentTests {
        CYNAMON, POMARAŃCZA, GOŹDZIK
    }

    @OneToMany
    private List<Competition> competitionList = new ArrayList<>();
    private boolean passedEvent;
}
