package site.de.passagens.rest.api.entitytest;

import org.junit.jupiter.api.Test;

import site.de.passagens.restapi.entity.Ticket;

import org.junit.jupiter.api.Assertions;

public class TicketTest {

    // Teste para verificar se o método isCpfValid funciona corretamente
    @Test
    public void testIsCpfValid() {
        Ticket ticket = new Ticket();
        Assertions.assertTrue(ticket.isCpfValid("12345678909")); // CPF válido
        Assertions.assertFalse(ticket.isCpfValid("1234567890")); // CPF inválido
    }

    // Teste para verificar se o método isRgValid funciona corretamente
    @Test
    public void testIsRgValid() {
        Ticket ticket = new Ticket();
        Assertions.assertTrue(ticket.isRgValid("123456789")); // RG válido
        Assertions.assertFalse(ticket.isRgValid("1234")); // RG inválido
    }
}
