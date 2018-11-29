package pl.coderslab.users;

import java.util.List;

public interface UserService {
    void save(User user);

    void update(User user);

    User find(Long id);

    void delete(Long id);

    List<User> findAll();

    User findByEmail(String email);
}
