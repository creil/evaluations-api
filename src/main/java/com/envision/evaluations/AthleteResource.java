package com.envision.evaluations;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.List;

@Path("/athletes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AthleteResource {

    @Inject
    AthleteRepository athleteRepository;

    @PostConstruct
    @Transactional
    public void init() {
        this.athleteRepository.persist(new Athlete("Corey", "Reil", LocalDate.now()));
        this.athleteRepository.persist(new Athlete("Andrew", "Reil", LocalDate.now()));
        System.out.println("init this!!!");
    }

    @GET
    @Transactional
    public List<Athlete> findByLastName(@QueryParam("lastName") String aLastName) {
        System.out.println("findByLastName");
        return this.athleteRepository.findByLastName(aLastName);
    }
}