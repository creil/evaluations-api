package com.envision.evaluations;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class AthleteRepository implements PanacheRepository<Athlete> {

    public List<Athlete> findByLastName(String aLastName){
        return find("lastName", aLastName).list();
    }

}
