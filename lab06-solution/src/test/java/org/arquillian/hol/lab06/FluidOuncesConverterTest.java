package org.arquillian.hol.lab06;

import static org.fest.assertions.Assertions.assertThat;

import java.util.logging.Logger;

import javax.ejb.EJB;

import org.arquillian.hol.lab06.container.Prompt;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class FluidOuncesConverterTest {

    private final static Logger logger = Logger.getLogger(FluidOuncesConverterTest.class.getName());

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
                          .addClasses(FluidOuncesConverter.class, FluidOuncesConverterBean.class)
                          .addPackages(true, "org.fest");
    }

    @EJB
    FluidOuncesConverter converter;

    @Test
    @Prompt(before = "before test", after = "after test")
    public void should_convert_fluid_ounces_to_milliliters() throws Exception {
        logger.info("Executing test");

        // given
        double ouncesToConvert = 8d;
        double expectedMilliliters = 236.5882368d;

        // when
        double ouncesInMl = converter.convertToMilliliters(ouncesToConvert);

        // then
        assertThat(ouncesInMl).isEqualTo(expectedMilliliters);
    }

}
