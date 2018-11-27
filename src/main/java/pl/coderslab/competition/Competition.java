package pl.coderslab.competition;

import pl.coderslab.dogs.Dog;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "DOGS")
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

    //    private String type;
    private LocalTime hour;
    @ManyToOne
    private List<Dog> competitors;
    //    private Loca
    private boolean passedCompetition;
}
