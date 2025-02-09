package site.de.passagens.rest.api.controllertest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import site.de.passagens.restapi.controller.AirplaneController;
import site.de.passagens.restapi.entity.Airplane;
import site.de.passagens.restapi.service.AirplaneService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AirplaneControllerTest {

    @Mock
    private AirplaneService airplaneService;

    @InjectMocks
    private AirplaneController airplaneController;

    @Test
    public void testGetAirplane() {
        // Crie um avião fictício
        Airplane airplane = new Airplane();
        airplane.setId(1L);
        airplane.setName("Boeing 747");

        // Defina o comportamento do serviço fictício
        when(airplaneService.getAirplaneById(1L)).thenReturn(Optional.ofNullable(airplane));

        // Chame o método que você quer testar
        Optional<Airplane> result = airplaneController.getAirplane(1L);

        // Verifique se o resultado é o esperado
        assertEquals(Optional.ofNullable(airplane), result);

        // Verifique se o método do serviço fictício foi chamado exatamente uma vez
        verify(airplaneService, times(1)).getAirplaneById(1L);
    }
}
