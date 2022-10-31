package br.ufpr.tads.jogodacapital;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class Estados {
    private static final Map<String, String> capitais;
    private static String[] estados;

    static {
        String[][] dados = new String[][] {
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
        estados = new String[15];

        int i = 0;
        for (String[] estado :
                dados) {
            capitais.put(estado[0], estado[1]);
            estados[i] = estado[0];
            i++;
        }
    }

    public static Map<String, String> getCapitais() {
        return capitais;
    }

    public static String[] getEstados() { return estados; }
}
