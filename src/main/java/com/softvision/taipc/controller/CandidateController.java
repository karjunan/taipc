package com.softvision.taipc.controller;

import com.softvision.taipc.entities.Candidate;
import com.softvision.taipc.helper.Loggable;
import com.softvision.taipc.service.CandidateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.CompletableFuture;

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

        CompletableFuture<Candidate> future = CompletableFuture.supplyAsync(() -> candidateService.getCandidate(id));
        asyncResponse.resume(future.join());
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable
    public void getAllCandidateDetails(@Suspended AsyncResponse asyncResponse) {

        CompletableFuture<List<Candidate>> future = CompletableFuture.supplyAsync(() -> candidateService.getAll());
        asyncResponse.resume(future.join());
    }

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Loggable
    public void addCandidate(@Suspended AsyncResponse asyncResponse,
                             Candidate candidate) {

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
