package org.arquillian.hol.lab04.repository;

import java.util.Collection;

import org.arquillian.hol.lab04.domain.Beer;

public interface BeerRepository {

    Beer getById(Long id);

    Collection<Beer> fetchAll();

}