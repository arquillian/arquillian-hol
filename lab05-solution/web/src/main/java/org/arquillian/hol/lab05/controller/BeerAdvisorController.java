package org.arquillian.hol.lab05.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.arquillian.hol.lab05.domain.Beer;
import org.arquillian.hol.lab05.service.BeerService;

@Named
@RequestScoped
public class BeerAdvisorController {

    private List<Beer> beers = Collections.emptyList();

    @Inject
    private BeerService beerService;

    @PostConstruct
    public void loadBeers() {
        beers = new ArrayList<Beer>(beerService.fetchAll());
    }

    public List<Beer> getBeers() {
        return beers;
    }

}
