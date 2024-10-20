package br.calebe.ticketmachine;

import br.calebe.ticketmachine.core.PapelMoeda;
import org.junit.Test;
import static org.junit.Assert.*;

public class PapelMoedaTeste {


    @Test
    public void getValorTest(){
        PapelMoeda papelMoeda = new PapelMoeda(5,10);
        assertEquals(5, papelMoeda.getValor());
    }

    @Test
    public void getQuantidadeTeste(){
        PapelMoeda papelMoeda = new PapelMoeda(7,20);
        assertEquals(20,papelMoeda.getQuantidade());
    }
}
