package site.de.passagens.rest.api.entitytest;

import java.time.Duration;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import site.de.passagens.restapi.entity.Flight;
import site.de.passagens.restapi.entity.Stopover;

public class StopoverTest {

    // Teste para verificar se o método getDuration funciona corretamente
    @Test
    public void testGetDuration() {
        Stopover stopover = createStopover(new Flight(), "GRU", Duration.ofHours(2));
        Assertions.assertThat(stopover.getDuration()).isEqualTo(Duration.ofHours(2));
    }

    // Teste para verificar se o método getAirport funciona corretamente
    @Test
    public void testGetAirport() {
        Stopover stopover = createStopover(new Flight(), "GRU", Duration.ofHours(2));
        Assertions.assertThat(stopover.getAirport()).isEqualTo("GRU");
    }

    // Método para criar um Stopover
    private Stopover createStopover(Flight flight, String airport, Duration duration) {
        if (flight == null) {
            throw new IllegalArgumentException("Flight cannot be null");
        }
        return new Stopover(flight, airport, duration);
    }
}
