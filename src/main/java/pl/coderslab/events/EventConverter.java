package pl.coderslab.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class EventConverter implements Converter<String, Event> {

    @Autowired
    private EventService eventService;

    @Override
    public Event convert(String s) {
        return eventService.find(Long.parseLong(s));
    }
}
