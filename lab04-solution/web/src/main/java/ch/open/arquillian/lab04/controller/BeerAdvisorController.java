package ch.open.arquillian.lab04.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ch.open.arquillian.lab04.domain.Beer;
import ch.open.arquillian.lab04.service.BeerService;

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
