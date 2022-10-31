package br.ufpr.tads.jogodacapital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    protected final Map<String, String> capitais = Estados.getCapitais();
    protected int pontuacao = 0;
    protected int qtdPerguntasRealizadas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void registrarAcerto() {
        this.pontuacao += 10;
    }

    private void realizarPergunta() {
        if (qtdPerguntasRealizadas < 5) {

            this.qtdPerguntasRealizadas += 1;
        }
    }
}