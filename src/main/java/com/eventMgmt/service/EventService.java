package com.eventMgmt.service;

import com.eventMgmt.entity.Event;

import java.util.List;

public interface EventService {
    public List<Event> findAll();

    public Event findById(int theId);

    public void save(Event theEvent);

    public void deleteById(int theId);
}
