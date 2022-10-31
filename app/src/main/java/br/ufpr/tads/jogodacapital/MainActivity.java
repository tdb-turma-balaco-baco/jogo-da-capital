package br.ufpr.tads.jogodacapital;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private final Map<String, String> capitais = Estados.getCapitais();
    private final String[] estados = Estados.getEstados();
    private int pontuacao = 0;
    private int qtdPerguntasRealizadas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView pontuacaoAtual = findViewById(R.id.pontuacaoText);
        pontuacaoAtual.setText("Sua pontuação atual: " + pontuacao);

        realizarPergunta();
    }

    private String recuperarEstadoAleatorio() {
        int indexAleatorio = new Random().nextInt(capitais.size());
        return estados[indexAleatorio];
    }

    public void handlePular(View pularBtn) {
        TextView ultimoResultado = findViewById(R.id.ultimoResultadoText);
        ultimoResultado.setText("Você pulou o último estado");
        ultimoResultado.setTextColor(Color.DKGRAY);

        realizarPergunta();
    }

    public void handleResposta(View responderBtn) {
        TextView ultimoResultado = findViewById(R.id.ultimoResultadoText);
        TextView estadoAtual = findViewById(R.id.estadoAtual);
        String nomeEstado = estadoAtual.getText().toString();

        EditText inputCapital = findViewById(R.id.inputCapital);
        String resposta = inputCapital.getText().toString().toLowerCase(Locale.ROOT);

        if (capitais.get(nomeEstado).equalsIgnoreCase(resposta)) {
            registrarAcerto();
            ultimoResultado.setText("Acertou!");
            ultimoResultado.setTextColor(Color.GREEN);
        } else {
            ultimoResultado.setText("Errou...");
            ultimoResultado.setTextColor(Color.RED);
        }

        realizarPergunta();
    }

    private void registrarAcerto() {
        TextView pontuacaoAtual = findViewById(R.id.pontuacaoText);
        this.pontuacao += 10;
        pontuacaoAtual.setText("Sua pontuação atual: " + pontuacao);
    }

    private void realizarPergunta() {
        if (qtdPerguntasRealizadas >= 5) {
            Button pularBtn = findViewById(R.id.pularBtn);
            Button responderBtn = findViewById(R.id.responderBtn);
            pularBtn.setEnabled(false);
            responderBtn.setEnabled(false);

            Toast gameOver = Toast.makeText(this,"Fim do jogo!", Toast.LENGTH_SHORT);
            gameOver.show();
        } else {
            TextView estadoAtual = findViewById(R.id.estadoAtual);
            estadoAtual.setText(recuperarEstadoAleatorio());

            this.qtdPerguntasRealizadas += 1;
        }

        EditText inputCapital = findViewById(R.id.inputCapital);
        inputCapital.setText("");
    }
}