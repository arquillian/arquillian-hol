package org.arquillian.hol.lab04.service;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.arquillian.hol.lab04.domain.Beer;
import org.arquillian.hol.lab04.repository.BeerRepository;

@RequestScoped
public class BeerService {

    @Inject
    private BeerRepository beerRepository;

    public Beer getById(Long id) {
        return beerRepository.getById(id);
    }

    public Collection<Beer> fetchAll() {
        return beerRepository.fetchAll();
    }
}
