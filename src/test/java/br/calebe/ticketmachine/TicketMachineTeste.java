package br.calebe.ticketmachine;

import br.calebe.ticketmachine.core.PapelMoeda;
import br.calebe.ticketmachine.core.TicketMachine;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class TicketMachineTeste {

    @Test
    public void inserirTeste() throws PapelMoedaInvalidaException {
        TicketMachine ticketMachine = new TicketMachine(50);
        ticketMachine.inserir(10);
    }

    @Test(expected = PapelMoedaInvalidaException.class)
    public void inserirPapelMoedaInvalidoTeste() throws PapelMoedaInvalidaException{
        TicketMachine ticketMachine = new TicketMachine(100);
        ticketMachine.inserir(13);
    }

    @Test
    public void imprimirTeste() throws PapelMoedaInvalidaException, SaldoInsuficienteException {
        TicketMachine ticketMachine = new TicketMachine(20);
        ticketMachine.inserir(20);
       assertEquals("*****************\n*** R$ 20,00 ****\n*****************\n", ticketMachine.imprimir());
    }

    @Test(expected = SaldoInsuficienteException.class)
    public void imprimirSaldoInsuficienteTeste() throws PapelMoedaInvalidaException, SaldoInsuficienteException {
        TicketMachine ticketMachine = new TicketMachine(100);
        ticketMachine.inserir(20);
        ticketMachine.imprimir();
    }

    @Test
    public void getTrocoTeste() throws PapelMoedaInvalidaException {
        TicketMachine ticketMachine = new TicketMachine(50);
        ticketMachine.inserir(100);
        Iterator<PapelMoeda> trocoIterator = ticketMachine.getTroco();
        PapelMoeda papelMoeda = trocoIterator.next();
        assertEquals(50,papelMoeda.getValor());
        assertEquals(1, papelMoeda.getQuantidade());
    }

}
