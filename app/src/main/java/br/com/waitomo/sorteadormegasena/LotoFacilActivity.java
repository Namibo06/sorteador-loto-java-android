package br.com.waitomo.sorteadormegasena;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LotoFacilActivity extends AppCompatActivity {
    private ImageView backPage;
    private TextView numeroUm,numeroDois,numeroTres,numeroQuatro,numeroCinco,numeroSeis,numeroSete,numeroOito,numeroNove,numeroDez,numeroOnze,numeroDoze,numeroTreze,numeroQuatorze,numeroQuinze,resultado;
    private Button btnGerarNumeros;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lotofacil);

        backPage = findViewById(R.id.backPage);
        numeroUm = findViewById(R.id.numeroUm);
        numeroDois = findViewById(R.id.numeroDois);
        numeroTres = findViewById(R.id.numeroTres);
        numeroQuatro = findViewById(R.id.numeroQuatro);
        numeroCinco = findViewById(R.id.numeroCinco);
        numeroSeis = findViewById(R.id.numeroSeis);
        numeroSete = findViewById(R.id.numeroSete);
        numeroOito = findViewById(R.id.numeroOito);
        numeroNove = findViewById(R.id.numeroNove);
        numeroDez = findViewById(R.id.numeroDez);
        numeroOnze = findViewById(R.id.numeroOnze);
        numeroDoze = findViewById(R.id.numeroDoze);
        numeroTreze = findViewById(R.id.numeroTreze);
        numeroQuatorze = findViewById(R.id.numeroQuatorze);
        numeroQuinze = findViewById(R.id.numeroQuinze);
        resultado = findViewById(R.id.resultado);
        btnGerarNumeros = findViewById(R.id.btnGerarNumeros);

        backPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LotoFacilActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnGerarNumeros.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Set<Integer> numerosSorteados = new HashSet<>();
                Random random = new Random();

                while(numerosSorteados.size() < 15){
                    numerosSorteados.add(random.nextInt(25) + 1);
                }

                Integer[] numerosArray = numerosSorteados.toArray(new Integer[0]);
                numeroUm.setText("1º: "+formatarNumero(numerosArray[0]));
                numeroDois.setText("2º: "+formatarNumero(numerosArray[1]));
                numeroTres.setText("3º: "+formatarNumero(numerosArray[2]));
                numeroQuatro.setText("4º: "+formatarNumero(numerosArray[3]));
                numeroCinco.setText("5º: "+formatarNumero(numerosArray[4]));
                numeroSeis.setText("6º: "+formatarNumero(numerosArray[5]));
                numeroSete.setText("7º: "+formatarNumero(numerosArray[6]));
                numeroOito.setText("8º: "+formatarNumero(numerosArray[7]));
                numeroNove.setText("9º: "+formatarNumero(numerosArray[8]));
                numeroDez.setText("10º: "+formatarNumero(numerosArray[9]));
                numeroOnze.setText("11º: "+formatarNumero(numerosArray[10]));
                numeroDoze.setText("12º: "+formatarNumero(numerosArray[11]));
                numeroTreze.setText("13º: "+formatarNumero(numerosArray[12]));
                numeroQuatorze.setText("14º: "+formatarNumero(numerosArray[13]));
                numeroQuinze.setText("15º: "+formatarNumero(numerosArray[14]));

                resultado.setText(setarResultado(numerosArray));

            }

            private String formatarNumero(int numero){
                return (numero < 10) ? "0" + numero : String.valueOf(numero);
            }

            private String setarResultado(Integer[] numero){
                return "Resultado: " + formatarNumero(numero[0]) + " - " + formatarNumero(numero[1]) + " - " + formatarNumero(numero[2]) + " - " + formatarNumero(numero[3]) + " - " + formatarNumero(numero[4]) + " - " + formatarNumero(numero[5]) + " - " + formatarNumero(numero[6]) + " - " + formatarNumero(numero[7]) + " - " + formatarNumero(numero[8]) + " - " + formatarNumero(numero[9]) + " - " + formatarNumero(numero[10]) + " - " + formatarNumero(numero[11]) + " - " + formatarNumero(numero[12]) + " - " + formatarNumero(numero[13]) + " - " + formatarNumero(numero[14]);
            }
        });
    }
}
