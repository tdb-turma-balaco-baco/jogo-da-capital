package br.ufpr.tads.jogodacapital;

import java.util.LinkedHashMap;
import java.util.Map;

public class Estados {
    private static Map<String, String> capitais;

    static {
        capitais = new LinkedHashMap<>();
        capitais.put("Acre", "Rio Branco");
        capitais.put("Alagoas", "Maceio");
        capitais.put("Amazonas", "Manaus");
        capitais.put("Paraná", "Curitiba");
        capitais.put("Santa Catarina", "Florianopolis");
        capitais.put("São Paulo", "Sao Paulo");
        capitais.put("Rio de Janeiro", "Rio de Janeiro");
        capitais.put("Minas Gerais", "Belo Horizonte");
        capitais.put("Rio Grande do Sul", "Porto Alegre");
        capitais.put("Bahia", "Salvador");
        capitais.put("Distrito Federal", "Brasilia");
        capitais.put("Espírito Santo", "Vitoria");
        capitais.put("Pernambuco", "Recife");
        capitais.put("Rio Grande do Norte", "Natal");
        capitais.put("Tocantins", "Palmas");
    }

    public static Map<String, String> getCapitais() {
        return capitais;
    }

    public static int getLength(){
        return capitais.size();
    }

    public static String[] getEstados() { return capitais.keySet().toArray(new String[0]); }
}
