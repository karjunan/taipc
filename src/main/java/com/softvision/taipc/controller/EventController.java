package com.softvision.taipc.controller;

import com.softvision.taipc.entities.Event;
import com.softvision.taipc.helper.Loggable;
import com.softvision.taipc.service.EventService;
import com.softvision.taipc.validation.ValidationUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Path("event")
public class EventController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

	@Inject
	EventService eventService;

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Loggable
	public void getEventDetails(@Suspended AsyncResponse asyncResponse, @PathParam("id") String id) {

		CompletableFuture<Event> future = CompletableFuture.supplyAsync(() -> eventService.getEvent((id)));
		asyncResponse.resume(future.join());
	}

	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	@Loggable
	public void getAllEventDetails(@Suspended AsyncResponse asyncResponse) {

		CompletableFuture<List<Event>> future = CompletableFuture.supplyAsync(() -> eventService.getAll());
		asyncResponse.resume(future.join());
	}

	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Loggable
	public void addEvent(@Suspended AsyncResponse asyncResponse, Event event) {

		ValidationUtil.validate(event);
		eventService.addEvent(event);
		asyncResponse.resume("Event Added");
	}

	@DELETE
	@Path("/{id}")
	@Loggable
	public void deleteEvent(@Suspended AsyncResponse asyncResponse, @PathParam("id") String id) {

		eventService.deleteEvent(id);
		asyncResponse.resume("Event Deleted");
	}

}
