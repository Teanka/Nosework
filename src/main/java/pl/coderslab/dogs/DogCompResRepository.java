package pl.coderslab.dogs;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DogCompResRepository extends JpaRepository<DogCompetitionResult, Long> {
}
