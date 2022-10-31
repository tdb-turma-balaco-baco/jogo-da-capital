package br.ufpr.tads.jogodacapital;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Map;

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
        Map<String, String> capitais = Estados.getCapitais();
        assertEquals(15, capitais.size());
    }
}