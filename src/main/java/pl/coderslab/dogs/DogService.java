package pl.coderslab.dogs;

import java.util.List;

public interface DogService {
        void save(Dog dog);

        void update(Dog dog);

        Dog find(Long id);

        void delete(Long id);

        List<Dog> findAll();
}
