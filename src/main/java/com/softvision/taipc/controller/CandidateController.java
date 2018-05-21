package com.softvision.taipc.controller;

import com.softvision.taipc.entities.Candidate;
import com.softvision.taipc.helper.Loggable;
import com.softvision.taipc.service.CandidateService;
import com.softvision.taipc.validation.ValidationUtil;

import com.sun.xml.internal.ws.util.CompletedFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Path("candidate")
public class CandidateController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CandidateController.class);

    @Inject
    CandidateService candidateService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    public void getCandidateDetails(@Suspended AsyncResponse asyncResponse,
                                    @PathParam("id") String id) {
        LOGGER.info("Candidate ID is : {} ", id);
        CompletableFuture<Candidate> future = CompletableFuture.supplyAsync(() -> candidateService.getCandidate(id));
        asyncResponse.resume(future.join());
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    public void getAllCandidateDetails(@Suspended AsyncResponse asyncResponse,
                                       @QueryParam("size") Integer size,
                                       @QueryParam("sort") String sortOrder) {

        LOGGER.info("Number of elements request is {} and sort order is {} ", size,sortOrder );
        CompletableFuture<List<Candidate>> future = CompletableFuture.supplyAsync(() -> candidateService.getAll());
        List<Candidate> candidatesList = future.join();
        if(sortOrder.equals("desc")) {
            asyncResponse.resume(candidatesList.stream()
                    .sorted(Comparator.reverseOrder())
                    .limit(size)
                    .collect(Collectors.toList()));
        } else {
            asyncResponse.resume(candidatesList.stream()
                    .sorted(Comparator.naturalOrder())
                    .limit(size)
                    .collect(Collectors.toList()));
        }

    }

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    public void addCandidate(@Suspended AsyncResponse asyncResponse,
                             Candidate candidate) {

    	ValidationUtil.validate(candidate);
        CompletableFuture.supplyAsync( () -> candidateService.addCandidate(candidate))
                .thenApply(candidate1 -> asyncResponse.resume(candidate));
    }

    @DELETE
    @Path("/{id}")
    @Loggable
    public void deleteCandidate(@Suspended AsyncResponse asyncResponse,
                             @PathParam("id") String id) {

        LOGGER.info("Deleting candidate {} ", id);
        CompletableFuture future  = CompletableFuture.runAsync(() -> candidateService.deleteCandidate(id));
        asyncResponse.resume(future.join());
    }

    @DELETE
    @Path("/all")
    @Loggable
    public void deleteAllCandidate(@Suspended AsyncResponse asyncResponse) {
        LOGGER.info(" Deleting All candidates " );
        CompletableFuture future  = CompletableFuture.runAsync(() -> candidateService.deleteAllCandidates());
        asyncResponse.resume(future.join());
    }


}
