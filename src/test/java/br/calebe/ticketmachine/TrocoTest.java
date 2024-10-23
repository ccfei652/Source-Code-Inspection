package br.calebe.ticketmachine;
import br.calebe.ticketmachine.core.PapelMoeda;
import br.calebe.ticketmachine.core.Troco;

import org.junit.Test;
import java.util.Iterator;
import static org.junit.Assert.*;

public class TrocoTest {

    @Test
    public void testTrocoComValorExatoParaUmaNota() {
        Troco troco = new Troco(100);
        Iterator<PapelMoeda> iterator = troco.getIterator();

        assertTrue(iterator.hasNext());
        PapelMoeda papelMoeda = iterator.next();
        assertEquals(100, papelMoeda.getValor());
        assertEquals(1, papelMoeda.getQuantidade());

        assertFalse(iterator.hasNext());
    }

    @Test
    public void testTrocoComNotasDiferentes() {
        Troco troco = new Troco(150);
        Iterator<PapelMoeda> iterator = troco.getIterator();

        // 1x50
        assertTrue(iterator.hasNext());
        PapelMoeda papelMoeda = iterator.next();
        assertEquals(50, papelMoeda.getValor());
        assertEquals(1, papelMoeda.getQuantidade());

        // 1x100
        assertTrue(iterator.hasNext());
        papelMoeda = iterator.next();
        assertEquals(100, papelMoeda.getValor());
        assertEquals(1, papelMoeda.getQuantidade());

        assertFalse(iterator.hasNext());
    }

    @Test
    public void testTrocoComMultiplasNotas() {
        Troco troco = new Troco(200);
        Iterator<PapelMoeda> iterator = troco.getIterator();

        assertTrue(iterator.hasNext());
        PapelMoeda papelMoeda = iterator.next();
        assertEquals(100, papelMoeda.getValor());
        assertEquals(2, papelMoeda.getQuantidade());

        assertFalse(iterator.hasNext());
    }

    @Test
    public void testTrocoComValorQueNaoDivideExatamente() {
        Troco troco = new Troco(180);
        Iterator<PapelMoeda> iterator = troco.getIterator();

        // 1x10
        assertTrue(iterator.hasNext());
        PapelMoeda papelMoeda = iterator.next();
        assertEquals(10, papelMoeda.getValor());
        assertEquals(1, papelMoeda.getQuantidade());

        // 1x20
        assertTrue(iterator.hasNext());
        papelMoeda = iterator.next();
        assertEquals(20, papelMoeda.getValor());
        assertEquals(1, papelMoeda.getQuantidade());

        // 1x50
        assertTrue(iterator.hasNext());
        papelMoeda = iterator.next();
        assertEquals(50, papelMoeda.getValor());
        assertEquals(1, papelMoeda.getQuantidade());

        // 1x100
        assertTrue(iterator.hasNext());
        papelMoeda = iterator.next();
        assertEquals(100, papelMoeda.getValor());
        assertEquals(1, papelMoeda.getQuantidade());

        assertFalse(iterator.hasNext());
    }

    @Test
    public void testTrocoComMenoresNotas() {
        Troco troco = new Troco(12);
        Iterator<PapelMoeda> iterator = troco.getIterator();

        // 1x2
        assertTrue(iterator.hasNext());
        PapelMoeda papelMoeda = iterator.next();
        assertEquals(2, papelMoeda.getValor());
        assertEquals(1, papelMoeda.getQuantidade());

        // 1x10
        assertTrue(iterator.hasNext());
        papelMoeda = iterator.next();
        assertEquals(10, papelMoeda.getValor());
        assertEquals(1, papelMoeda.getQuantidade());

        assertFalse(iterator.hasNext());
    }

    @Test
    public void testTrocoSemMoedas() {
        Troco troco = new Troco(0);
        Iterator<PapelMoeda> iterator = troco.getIterator();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testTrocoValorInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Troco(-10));
    }
}
