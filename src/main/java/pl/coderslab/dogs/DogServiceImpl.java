package pl.coderslab.dogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DogServiceImpl implements DogService{

    @Autowired
    DogRepository dogRepository;

    @Override
    public void save(Dog dog) {
        dogRepository.save(dog);
    }

    @Override
    public void update(Dog dog) {
        dogRepository.save(dog);
    }

    @Override
    public Dog find(Long id) {
        return dogRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        dogRepository.deleteById(id);
    }

    @Override
    public List<Dog> findAll() {
        return dogRepository.findAll();
    }

    @Override
    public List<Dog> findByName(String name) {
        return dogRepository.findByName(name);
    }
}
