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
    private static final int MAX_PERGUNTAS = 5;
    private static final int QTD_ESTADOS = Estados.getEstados().length;

    private final Map<String, String> capitais = Estados.getCapitais();
    private final String[] estados = Estados.getEstados();

    private int pontuacao = 0;
    private int qtdPerguntasRealizadas = 0;

    TextView ultimoResultado;
    TextView estadoAtual;
    EditText inputCapital;
    TextView pontuacaoAtual;
    Button pularBtn;
    Button responderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initComponents();
        this.realizarPergunta();
    }

    private void initComponents() {
        ultimoResultado = findViewById(R.id.ultimoResultadoText);
        estadoAtual = findViewById(R.id.estadoAtual);
        inputCapital = findViewById(R.id.inputCapital);
        pontuacaoAtual = findViewById(R.id.pontuacaoText);
        pularBtn = findViewById(R.id.pularBtn);
        responderBtn = findViewById(R.id.responderBtn);

        pontuacaoAtual.setText("Sua pontuação atual: " + pontuacao);
    }

    private String recuperarEstadoAleatorio() {
        int indexAleatorio = new Random().nextInt(QTD_ESTADOS);
        return estados[indexAleatorio];
    }

    public void handlePular(View pularBtn) {
        ultimoResultado.setText("Você pulou o último estado");
        ultimoResultado.setTextColor(Color.DKGRAY);

        realizarPergunta();
    }

    public void handleResposta(View responderBtn) {
        String nomeEstado = estadoAtual.getText().toString();

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
        this.pontuacao += 10;
        pontuacaoAtual.setText("Sua pontuação atual: " + pontuacao);
    }

    private void realizarPergunta() {
        if (qtdPerguntasRealizadas >= MAX_PERGUNTAS) {
            pularBtn.setEnabled(false);
            responderBtn.setEnabled(false);

            Toast gameOver = Toast.makeText(this,"Fim do jogo!", Toast.LENGTH_SHORT);
            gameOver.show();
        } else {
            estadoAtual.setText(recuperarEstadoAleatorio());

            this.qtdPerguntasRealizadas += 1;
        }

        EditText inputCapital = findViewById(R.id.inputCapital);
        inputCapital.setText("");
    }
}