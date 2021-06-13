package com.eventMgmt.service;

import com.eventMgmt.dao.EventRepository;
import com.eventMgmt.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements  EventService{

    @Autowired
   private EventRepository eventRepository;

    @Override
    @Transactional
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    @Transactional
    public Event findById(int theId) {
        Optional<Event> result = eventRepository.findById(theId);
        Event theEvent = null;
        if(result.isPresent()) {
            theEvent= result.get();
        }
        else {
            throw new RuntimeException("Event id not found : "+theId);
        }
        return theEvent;
    }

    @Override
    @Transactional
    public void save(Event theEvent) {
         eventRepository.save(theEvent);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {

        eventRepository.deleteById(theId);

    }
}
