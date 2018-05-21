package com.softvision.taipc.controller;

import com.softvision.taipc.entities.Candidate;
import com.softvision.taipc.helper.Loggable;
import com.softvision.taipc.service.CandidateService;
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
                                       @QueryParam("size") Integer size) {
        LOGGER.info("Number of elements request is {}", size );
        CompletableFuture<List<Candidate>> future = CompletableFuture.supplyAsync(() -> candidateService.getAll());
        List<Candidate> candidatesList = future.join();
        asyncResponse.resume(candidatesList.stream().sorted().limit(size)
                .collect(Collectors.toList()));
    }

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Loggable
    public void addCandidate(@Suspended AsyncResponse asyncResponse,
                             Candidate candidate) {

    	ValidationUtil.validate(candidate);
        candidateService.addCandidate(candidate);
        asyncResponse.resume("Candidate Added");
    }

    @DELETE
    @Path("/{id}")
    @Loggable
    public void deleteCandidate(@Suspended AsyncResponse asyncResponse,
                             @PathParam("id") String id) {

        candidateService.deleteCandidate(id);
        asyncResponse.resume("Candidate Deleted");
    }


}
