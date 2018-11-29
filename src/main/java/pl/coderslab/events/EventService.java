package pl.coderslab.events;

import java.util.List;

public interface EventService {
    void save(Event event);

    void update(Event event);

    Event find(Long id);

    void delete(Long id);

    List<Event> findAll();
}
