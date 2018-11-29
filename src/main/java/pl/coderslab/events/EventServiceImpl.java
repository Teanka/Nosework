package pl.coderslab.events;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public void save(Event event) {
        eventRepository.save(event);
    }

    @Override
    public void update(Event event) {
        eventRepository.save(event);
    }

    @Override
    public Event find(Long id) {
//        return eventRepository.getOne(id);
         Event event = eventRepository.findById(id).orElse(null);
         return event;
    }

    @Override
    public Event findWithResults(Long id) {
        Event event = find(id);
        Hibernate.initialize(event.getResults());
        return event;
    }

    @Override
    public void delete(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event getLastPastEvent() {
        return eventRepository.getLastPastEvent();
    }
}
