
package org.arquillian.hol.lab05.ui;

import java.math.BigDecimal;
import java.net.URL;
import java.util.List;

import org.arquillian.hol.lab05.ui.utils.BeersAssert;
import org.arquillian.hol.lab05.ui.utils.Deployments;
import org.arquillian.hol.lab05.ui.web.Beer;
import org.arquillian.hol.lab05.ui.web.BeerAdvisorPage;
import org.arquillian.hol.lab05.ui.web.BeerDetailsPage;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * This example illustrates how Arquillian and Drone extension
 * can help you to skip the build process and deploys your
 * application for you.
 *
 * It also uses <a href="http://code.google.com/p/selenium/wiki/PageObjects">PageObject pattern</a>
 * to model parts of the web application with which tests are interacting. This makes it more readable
 * and easier to maintain when UI is changing.
 *
 * @see BeerAdvisorPage
 * @see BeerDetailsPage
 *
 */
@RunWith(Arquillian.class)
public class BeerAdvisorDroneTest
{
   /**
    * Deploys your web application and executes tests from the client side.
    * testable=false flag means that the deployment package does not contain
    * any tests to be run on the server side.
    *
    * @return WebArchive created by ShrinkWrap which is deployed in the target container
    */
   @Deployment(testable = false)
   public static WebArchive createDeployment()
   {
      return Deployments.create();
   }

   @ArquillianResource
   URL deploymentUrl;

   @Drone
   WebDriver driver;

   @Test
   public void should_find_all_beers()
   {
      // given
      BeerAdvisorPage beerAdvisor = new BeerAdvisorPage(driver, deploymentUrl.toString());

      // when
      List<Beer> beers = beerAdvisor.fetchFromTable();

      // then
      BeersAssert.assertThat(beers).hasSize(7);
   }

   @Test
   public void should_find_details_of_a_beer()
   {
       // given
       BeerAdvisorPage beerAdvisor = new BeerAdvisorPage(driver, deploymentUrl.toString());

       // when
       Beer endOfHistory = beerAdvisor.detailsOf("End of history");

       // then
       Assert.assertEquals("End of history", endOfHistory.getName());
       Assert.assertEquals(765, endOfHistory.getPrice().intValue());
       Assert.assertEquals("Brew Dog", endOfHistory.getBrewery());
       Assert.assertEquals(55, endOfHistory.getAlcohol().intValue());
   }
}