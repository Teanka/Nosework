package pl.coderslab.judges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class JudgeServiceImpl implements JudgeService{

    @Autowired
    private JudgeRepository judgeRepository;

    @Override
    public void save(Judge judge) {
        judgeRepository.save(judge);

    }

    @Override
    public void update(Judge judge) {
        judgeRepository.save(judge);
    }

    @Override
    public Judge find(Long id) {
        return judgeRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        judgeRepository.deleteById(id);
    }

    @Override
    public List<Judge> findAll() {
        return judgeRepository.findAll();
    }
}
