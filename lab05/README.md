## Lab 05 - Going into the details

### Objectives

In this lab we will evolve the Beer Advisor application from the previous installment, so you can learn how to write acceptance tests in Behaviour Driven Development using Arquillian Drone.

After this lab you will be able to:
* Test your application from outside of the container (black box), using Arquillian to deploy the bundle and Drone to drive the browser.
* Write clean and concise Selenium/WebDriver UI tests using [Page Objects](http://code.google.com/p/selenium/wiki/PageObjects).
* Test your web application in different browsers and different application servers with minimal configuration thanks to Arquillian.

### Task

You will need to make another acceptance test passing
	
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
    
Here are the steps:
* Implement new Page Object `BeerDetailsPage` which will encapsulate web elements from the web site and expose Beer details as [simple POJO](https://github.com/arquillian/arquillian-hol/blob/master/lab05/web/src/test/java/org/arquillian/hol/lab05/ui/web/Beer.java)
* Extend [`BeerAdvisorPage`](https://github.com/arquillian/arquillian-hol/blob/master/lab05/web/src/test/java/org/arquillian/hol/lab05/ui/web/BeerAdvisorPage.java#L35) by implementing the `detailsOf` method which will allow to
	* click on the link with the name of the beer (taken as parameter) (_hint_ you can use an XPath expression to find the matching link)
	* instantiate the `BeerDetailsPage` which will fetch web elements from the opened page with details of the selected beer
	* extract this information and create a `Beer` POJO containing them

