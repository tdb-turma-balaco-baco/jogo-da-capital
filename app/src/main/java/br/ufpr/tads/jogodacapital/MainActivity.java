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
    TextView textViewNomeEstado;
    EditText inputCapital;
    TextView pontuacaoAtual;
    Button pularBtn;
    Button responderBtn;

    private String estadoAtual;
    private String textoPontuacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initComponents();
        this.realizarPergunta();
    }

    private void initComponents() {
        ultimoResultado = findViewById(R.id.ultimoResultadoText);
        textViewNomeEstado = findViewById(R.id.estadoAtual);
        inputCapital = findViewById(R.id.inputCapital);
        pontuacaoAtual = findViewById(R.id.pontuacaoText);
        pularBtn = findViewById(R.id.pularBtn);
        responderBtn = findViewById(R.id.responderBtn);
        textoPontuacao = getResources().getText(R.string.pontuacao_atual).toString();

        pontuacaoAtual.setText(String.format("%s %s", textoPontuacao, pontuacao));
    }

    private void definirEstadoAleatorio() {
        int indexAleatorio = new Random().nextInt(QTD_ESTADOS);
        this.estadoAtual = estados[indexAleatorio];
        textViewNomeEstado.setText(estadoAtual);
    }

    public void handlePular(View pularBtn) {
        ultimoResultado.setText(R.string.pular_msg);
        ultimoResultado.setTextColor(Color.DKGRAY);
        this.realizarPergunta();
    }

    public void handleResposta(View responderBtn) {
        String respostaNormalizada = inputCapital.getText().toString().trim().toLowerCase(Locale.ROOT);

        if (capitais.get(estadoAtual).equalsIgnoreCase(respostaNormalizada)) {
            this.registrarAcerto();
        } else {
            this.registrarErro();
        }

        this.realizarPergunta();
    }

    private void registrarAcerto() {
        this.pontuacao += 10;
        pontuacaoAtual.setText(String.format("%s %s", textoPontuacao, pontuacao));
        ultimoResultado.setText(R.string.acertou);
        ultimoResultado.setTextColor(Color.GREEN);
    }

    private void registrarErro() {
        String mensagemErro = getResources().getText(R.string.errou).toString();
        ultimoResultado.setText(String.format("%s %s", mensagemErro, capitais.get(estadoAtual)));
        ultimoResultado.setTextColor(Color.RED);
    }

    private void realizarPergunta() {
        if (qtdPerguntasRealizadas >= MAX_PERGUNTAS) {
            pularBtn.setEnabled(false);
            responderBtn.setEnabled(false);

            Toast.makeText(this, R.string.fim_jogo, Toast.LENGTH_SHORT).show();
        } else {
            this.definirEstadoAleatorio();
            this.qtdPerguntasRealizadas += 1;
        }

        // Limpa o campo de input, para aparecer novamente a hint
        inputCapital.setText("");
    }
}