package com.softvision.taipc.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.softvision.taipc.entities.Event;
import com.softvision.taipc.helper.Loggable;
import com.softvision.taipc.repository.EventRepository;

@Component
public class EventServiceImpl implements EventService {

	@Inject
	private EventRepository eventRepository;

	@Override
	@Loggable
	public Event getEvent(String id) {
		return eventRepository.findById(id).get();
	}

	@Override
	@Loggable
	public void addEvent(Event event) {

	System.out.println(	event.getCreationTime());
		
		if (event != null) {
			
			LocalDateTime joiningDate =LocalDateTime.now();
			event.setCreationTime(joiningDate);
			event.setModifiedTime(joiningDate);
		}

		eventRepository.insert(event);
	}

	@Override
	@Loggable
	public List<Event> getAll() {
		return eventRepository.findAll();
	}

	@Override
	@Loggable
	public void deleteEvent(String id) {
		System.out.println("Deleting id " + id);
		eventRepository.deleteById(id);
	}
}