package br.ufpr.tads.jogodacapital;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTests {

    @Test
    public void capitaisInicializam() {
        Map<String, String> capitais = Estados.getCapitais();
        assertEquals("Curitiba", capitais.get("Paraná"));
        assertEquals("Florianopolis", capitais.get("Santa Catarina"));
    }

    @Test
    public void quantidadeCorretaDeCapitais() {
        assertEquals(15, Estados.getLength());
    }

    @Test
    public void quantidadeCorretaDeEstados() {
        String[] estados = Estados.getEstados();
        assertEquals(15, estados.length);
    }

    @Test
    public void estadosExistem() {
        String[] estados = Estados.getEstados();
        assertEquals(true, Arrays.stream(estados).anyMatch(e -> e.equalsIgnoreCase("Paraná")));
        assertEquals(true, Arrays.stream(estados).anyMatch(e -> e.equalsIgnoreCase("São Paulo")));
    }

    @Test
    public void recuperaEstadosCorretamente() {
        String[] estados = Estados.getEstados();
        assertEquals("Paraná", estados[3]);
        assertEquals("Rio Grande do Norte", estados[13]);
    }
}