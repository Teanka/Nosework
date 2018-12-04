package pl.coderslab.dogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DogCompResServiceImpl implements DogCompResService {

    @Autowired
    private DogCompResRepository dogCompResRepository;

    @Override
    public void save(DogCompetitionResult dogCompetitionResult) {
        dogCompResRepository.save(dogCompetitionResult);
    }

    @Override
    public void update(DogCompetitionResult dogCompetitionResult) {
        dogCompResRepository.save(dogCompetitionResult);
    }

    @Override
    public DogCompetitionResult find(Long id) {
//        return dogCompResRepository.getOne(id);
        return dogCompResRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        dogCompResRepository.deleteById(id);
    }

    @Override
    public List<DogCompetitionResult> findAll() {
        return dogCompResRepository.findAll();
    }

    @Override
    public List<DogCompetitionResult> findByCompetitionTypeAndEventId(String competitionType, Long eventId) {
        return dogCompResRepository.findByCompetitionTypeAndEventId(competitionType,eventId);
    }
}
