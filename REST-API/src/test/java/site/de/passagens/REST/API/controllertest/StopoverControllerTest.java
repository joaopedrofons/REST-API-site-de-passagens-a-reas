package site.de.passagens.rest.api.controllertest;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import site.de.passagens.restapi.RestApiApplication;
import site.de.passagens.restapi.controller.StopoverController;
import site.de.passagens.restapi.entity.Flight;
import site.de.passagens.restapi.entity.Stopover;
import site.de.passagens.restapi.service.FlightService;
import site.de.passagens.restapi.service.StopoverService;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = RestApiApplication.class)
public class StopoverControllerTest {

    @InjectMocks
    StopoverController stopoverController;

    @Mock
    StopoverService stopoverService;

    @Mock
    FlightService flightService;

    @Test
    public void testCreateStopover() {
        // Cria um mock de Flight
        Flight flight = new Flight();
        flight.setId(1L);

        // Cria um mock de Stopover
        Stopover stopover = new Stopover(flight, "Airport Test", Duration.ofHours(2));

        // Configura os mocks para retornar os objetos esperados
        when(flightService.findById(flight.getId())).thenReturn(flight);
        when(stopoverService.createStopover(flight, stopover.getAirport(), stopover.getDuration())).thenReturn(stopover);

        // Chama o método que está sendo testado
        Stopover result = stopoverController.createStopover(stopover);

        // Verifica se o resultado é o esperado
        assertEquals(stopover.getAirport(), result.getAirport());
        assertEquals(stopover.getDuration(), result.getDuration());
    }
}