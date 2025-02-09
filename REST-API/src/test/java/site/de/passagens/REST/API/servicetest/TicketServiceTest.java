package site.de.passagens.rest.api.servicetest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import site.de.passagens.restapi.entity.Ticket;
import site.de.passagens.restapi.repository.TicketRepository;
import site.de.passagens.restapi.service.TicketService;

import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TicketServiceTest {

    @InjectMocks
    private TicketService ticketService;

    @Mock
    private TicketRepository ticketRpository;

    @Test
    public void testGetAllTickets() {
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();
        when(ticketRpository.findAll()).thenReturn(Arrays.asList(ticket1, ticket2));

        List<Ticket> tickets = ticketService.getAllTickets();

        assertEquals(2, tickets.size());
        verify(ticketRpository, times(1)).findAll();
    }

    @Test
    public void testGetTicket() {
        Ticket ticket = new Ticket();
        when(ticketRpository.findById(1L)).thenReturn(Optional.of(ticket));

        Ticket foundTicket = ticketService.getTicket(1L);

        assertNotNull(foundTicket);
        verify(ticketRpository, times(1)).findById(1L);
    }

    // Adicione mais testes para os outros métodos...
}