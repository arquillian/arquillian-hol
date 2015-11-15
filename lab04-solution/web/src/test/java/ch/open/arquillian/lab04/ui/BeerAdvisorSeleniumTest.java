package ch.open.arquillian.lab04.ui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BeerAdvisorSeleniumTest {

    private final String BASE_URL = "http://beeradvisor.bartoszmajsak.com";
    private WebDriver selenium;
    
    @Before
    public void setUp() throws Exception {
        selenium = new FirefoxDriver();
    }

    @Test
    public void should_find_all_beers() throws Exception {
        selenium.get(BASE_URL + "/search.xhtml");
        selenium.findElement(By.id("advisor:beerSearch")).sendKeys("all", Keys.RETURN);
        
        for (int second = 0;; second++) {
            if (second >= 60)
                fail("timeout");
            try {
                if (selenium.findElement(By.xpath("//table[@id='beer-results-table']/tbody/tr"))!= null)
                    break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        assertEquals(7, selenium.findElements(By.xpath("//table[@id='beer-results-table']/tbody/tr")).size());
    }

    @After
    public void tearDown() throws Exception {
        selenium.close();
    }
}