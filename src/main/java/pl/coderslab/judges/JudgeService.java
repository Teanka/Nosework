package pl.coderslab.judges;

import java.util.List;

public interface JudgeService {
    void save(Judge judge);

    void update(Judge judge);

    Judge find(Long id);

    void delete(Long id);

    List<Judge> findAll();
}
