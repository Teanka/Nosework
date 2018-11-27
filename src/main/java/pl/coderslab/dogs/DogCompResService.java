package pl.coderslab.dogs;

import java.util.List;

public interface DogCompResService {
    void save(DogCompetitionResult dogCompetitionResult);

    void update(DogCompetitionResult dogCompetitionResult);

    DogCompetitionResult find(Long id);

    void delete(Long id);

    List<DogCompetitionResult> findAll();
}
