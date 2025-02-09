package site.de.passagens.rest.api.entitytest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import site.de.passagens.restapi.entity.FlightClass;

public class FlightClassTest {

    // Teste para verificar se o valor do enum FlightClass.ECONOMY é "ECONOMY"
    @Test
    public void testEconomy() {
        assertThat(FlightClass.valueOf("ECONOMY")).isEqualTo(FlightClass.ECONOMY);
    }

    // Teste para verificar se o valor do enum FlightClass.BUSINESS é "BUSINESS"
    @Test
    public void testBusiness() {
        assertThat(FlightClass.valueOf("BUSINESS")).isEqualTo(FlightClass.BUSINESS);
    }

    // Teste para verificar se o valor do enum FlightClass.FIRST_CLASS é "FIRST_CLASS"
    @Test
    public void testFirstClass() {
        assertThat(FlightClass.valueOf("FIRST_CLASS")).isEqualTo(FlightClass.FIRST_CLASS);
    }
}
