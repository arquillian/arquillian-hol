package org.arquillian.hol.lab05.repository;

import java.util.Set;

import org.arquillian.hol.lab05.domain.Beer;

public interface BeerRepository {

    Beer getById(Long id);

    Set<Beer> fetchAll();

}