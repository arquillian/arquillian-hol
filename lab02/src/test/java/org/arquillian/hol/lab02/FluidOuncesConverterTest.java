package org.arquillian.hol.lab02;

import static org.fest.assertions.Assertions.assertThat;

import org.arquillian.hol.lab02.FluidOuncesConverter;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class FluidOuncesConverterTest {

    FluidOuncesConverter converter;

    @Test
    public void should_convert_fluid_ounces_to_milliliters() throws Exception {
        // given
        double ouncesToConvert = 8d;
        double expectedMilliliters = 236.5882368d;

        // when
        double ouncesInMl = converter.convertToMilliliters(ouncesToConvert);

        // then
        assertThat(ouncesInMl).isEqualTo(expectedMilliliters);
    }

}
