package pl.coderslab.events;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Long> {
    @Query("Select e from Event e where e.pastEvent =?1")
    List<Event> getEventsPresentOrPast(boolean isPastEvent);
}
