package site.de.passagens.rest.api.repositorytest;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import site.de.passagens.restapi.entity.Airline;
import site.de.passagens.restapi.repository.AirlineRepository;

public class AirlineRepositoryTest {

    private AirlineRepository airlineRepository = Mockito.mock(AirlineRepository.class);

    // Teste para verificar se o método findByName funciona corretamente
    @Test
    public void testFindByName() {
        Airline airline = new Airline();
        airline.setName("Test Airline");
        Mockito.when(airlineRepository.findByName("Test Airline")).thenReturn(Optional.of(airline));

        Optional<Airline> foundAirline = airlineRepository.findByName("Test Airline");

        Assertions.assertTrue(foundAirline.isPresent());
        Assertions.assertEquals("Test Airline", foundAirline.get().getName());
    }
}
