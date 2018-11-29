package pl.coderslab.dogs;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DogCompResRepository extends JpaRepository<DogCompetitionResult, Long> {
    List<DogCompetitionResult> findByCompetitionTypeAndEventId(String competitionType, Long eventId);
}

