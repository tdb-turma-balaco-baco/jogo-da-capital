package br.ufpr.tads.jogodacapital;

import java.util.HashMap;
import java.util.Map;

public final class Estados {
    private static final Map<String, String> capitais;

    static {
        String[][] estados = new String[][] {
                {"Acre", "Rio Branco"},
                {"Alagoas", "Maceio"},
                {"Amazonas", "Manaus"},
                {"Paraná", "Curitiba"},
                {"Santa Catarina", "Florianopolis"},
                {"São Paulo", "Sao Paulo"},
                {"Rio de Janeiro", "Rio de Janeiro"},
                {"Minas Gerais", "Belo Horizonte"},
                {"Rio Grande do Sul", "Porto Alegre"},
                {"Bahia", "Salvador"},
                {"Distrito Federal", "Brasilia"},
                {"Espírito Santo", "Vitoria"},
                {"Pernambuco", "Recife"},
                {"Rio Grande do Norte", "Natal"},
                {"Tocantins", "Palmas"}
        };

        capitais = new HashMap<>();

        for (String[] estado :
                estados) {
            capitais.put(estado[0], estado[1]);
        }
    }

    public static Map<String, String> getCapitais() {
        return capitais;
    }
}
