package br.com.waitomo.sorteadormegasena;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class DuplaSenaActivity extends AppCompatActivity {
    private AppCompatButton btnSortear;
    private ImageView backPage;
    private TextView numeroUm,numeroDois,numeroTres,numeroQuatro,numeroCinco,numeroSeis,resultado;

    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_duplasena);

        numeroUm = findViewById(R.id.numeroUm);
        numeroDois = findViewById(R.id.numeroDois);
        numeroTres = findViewById(R.id.numeroTres);
        numeroQuatro = findViewById(R.id.numeroQuatro);
        numeroCinco = findViewById(R.id.numeroCinco);
        numeroSeis = findViewById(R.id.numeroSeis);
        resultado = findViewById(R.id.resultado);
        backPage = findViewById(R.id.backPage);
        btnSortear = findViewById(R.id.btnSortear);

        btnSortear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Set<Integer> numerosSorteados = new HashSet<>();
                Random random = new Random();

                while(numerosSorteados.size() < 6){
                    numerosSorteados.add(random.nextInt(50) + 1);
                }

                Integer[] numerosArray = numerosSorteados.toArray(new Integer[0]);
                numeroUm.setText(formatarNumeros(numerosArray[0]));
                numeroDois.setText(formatarNumeros(numerosArray[1]));
                numeroTres.setText(formatarNumeros(numerosArray[2]));
                numeroQuatro.setText(formatarNumeros(numerosArray[3]));
                numeroCinco.setText(formatarNumeros(numerosArray[4]));
                numeroSeis.setText(formatarNumeros(numerosArray[5]));

                resultado.setText(retonarTodosNumeros(numerosArray));
            }

            private String formatarNumeros(int numero){
                return (numero < 10) ? "0" + numero : String.valueOf(numero);
            }

            private String retonarTodosNumeros(Integer[] numero){
                return "Resultado: " + formatarNumeros(numero[0]) + " - " + formatarNumeros(numero[1]) + " - " + formatarNumeros(numero[2]) + " - " + formatarNumeros(numero[3]) + " - " + formatarNumeros(numero[4]) + " - " + formatarNumeros(numero[5]);
            }
        });

        backPage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DuplaSenaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
