package site.de.passagens.rest.api.servicetest;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import site.de.passagens.restapi.entity.Airline;
import site.de.passagens.restapi.entity.Flight;
import site.de.passagens.restapi.entity.Stopover;
import site.de.passagens.restapi.repository.StopoverRepository;
import site.de.passagens.restapi.service.StopoverService;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = TestConfig.class)
public class StopoverServiceTest {

    @InjectMocks
    private StopoverService stopoverService;

    @Mock
    private StopoverRepository stopoverRepository;

    @Test
    public void testCreateStopover() {
        Airline airline = new Airline("Test Airline");  // Criando um objeto Airline
        String airplaneModel = "Boeing 747";
        String origin = "Test Origin";
        String destination = "Test Destination";
        String departureTime = "10:00";
        String arrivalTime = "14:00";

        Flight flight = new Flight(airline, airplaneModel, origin, destination, departureTime, arrivalTime);

        String airport = "Test Airport";
        Duration duration = Duration.ofHours(2);

        Stopover stopover = new Stopover(flight, airport, duration);
        when(stopoverRepository.save(any(Stopover.class))).thenReturn(stopover);

        Stopover createdStopover = stopoverService.createStopover(flight, airport, duration);

        assertEquals(stopover, createdStopover);
        assertEquals(flight, createdStopover.getFlight());
        assertEquals(airport, createdStopover.getAirport());
        assertEquals(duration, createdStopover.getDuration());
    }
}