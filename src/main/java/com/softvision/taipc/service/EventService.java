package com.softvision.taipc.service;

import java.util.List;

import com.softvision.taipc.entities.Event;

public interface EventService {

    List<Event> getAll();

    Event getEvent(String id);

    void addEvent(Event candidate);

    void deleteEvent(String id);
}
