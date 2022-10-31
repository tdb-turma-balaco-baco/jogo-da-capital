package br.ufpr.tads.jogodacapital;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Estados {
    private static final Map<String, String> capitais = Stream.of(new String[][] {
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
    }).collect(Collectors.toMap(k -> (String) k[0], v -> (String) v[1]));

    public static Map<String, String> getCapitais() {
        return capitais;
    }
}
