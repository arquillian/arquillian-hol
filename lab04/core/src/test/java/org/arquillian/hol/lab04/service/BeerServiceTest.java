package org.arquillian.hol.lab04.service;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Collection;

import javax.inject.Inject;

import org.arquillian.hol.lab04.domain.Beer;
import org.arquillian.hol.lab04.repository.BeerRepository;
import org.arquillian.hol.lab04.service.BeerService;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@Ignore
@RunWith(Arquillian.class)
public class BeerServiceTest
{
   @Deployment
   public static Archive<?> createDeployment()
   {
      return ShrinkWrap.create(JavaArchive.class, "test.jar")
                       .addPackages(true, Beer.class.getPackage(), BeerRepository.class.getPackage())
                       .addClass(BeerService.class)
                       .addPackages(true, "org.fest")
                       .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                       .addAsManifestResource("test-persistence.xml", "persistence.xml");
   }

   @Inject
   BeerService beerService;

   @Test
   public void should_find_all_beers() throws Exception
   {
      // given
      int expectedAmountOfBeers = 7;

      // when
      Collection<Beer> beers = beerService.fetchAll();

      // then
      assertThat(beers).hasSize(expectedAmountOfBeers);
   }

}
