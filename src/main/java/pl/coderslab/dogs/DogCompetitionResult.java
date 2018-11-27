package pl.coderslab.dogs;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="DOGRESULTS")
public class DogCompetitionResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Dog dog;
    private String place;//bo może być DIS lub NB również
    private int points;
    @NotBlank
    private LocalDate eventDate;


}
