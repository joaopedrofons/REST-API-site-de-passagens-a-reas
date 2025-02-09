package site.de.passagens.rest.api.controllertest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import site.de.passagens.restapi.controller.TicketController;
import site.de.passagens.restapi.entity.Ticket;
import site.de.passagens.restapi.service.TicketService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class TicketControllerTest {

    @InjectMocks
    TicketController ticketController;

    @Mock
    TicketService ticketService;

    @Test
    public void testGetAllTickets() {
        Ticket ticket1 = new Ticket();
        ticket1.setId(1L);

        Ticket ticket2 = new Ticket();
        ticket2.setId(2L);

        List<Ticket> tickets = Arrays.asList(ticket1, ticket2);

        when(ticketService.getAllTickets()).thenReturn(tickets);

        List<Ticket> result = ticketController.getAllTickets();

        assertEquals(tickets.size(), result.size());
    }

    // ... restante dos testes ...
}
