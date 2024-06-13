package br.com.waitomo.sorteadormegasena;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MegaSenaActivity extends AppCompatActivity {
    private Button btnSortear ;
    private ImageView backPage;
    private TextView numeroUm,numeroDois,numeroTres,numeroQuatro,numeroCinco,numeroSeis,todosNumeros;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mega_sena);

        numeroUm = findViewById(R.id.numeroUm);
        numeroDois = findViewById(R.id.numeroDois);
        numeroTres = findViewById(R.id.numeroTres);
        numeroQuatro = findViewById(R.id.numeroQuatro);
        numeroCinco = findViewById(R.id.numeroCinco);
        numeroSeis = findViewById(R.id.numeroSeis);
        todosNumeros = findViewById(R.id.todosNumeros);
        btnSortear = findViewById(R.id.btnSortear);
        backPage = findViewById(R.id.backPage);

        btnSortear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Set<Integer> numerosSorteados = new HashSet<>();
                Random random = new Random();

                while(numerosSorteados.size() < 6){
                    numerosSorteados.add(random.nextInt(60) + 1);
                }

                Integer[] numerosArray = numerosSorteados.toArray(new Integer[0]);

                numeroUm.setText(formatarNumeroMenorQueDez(numerosArray[0]));
                numeroDois.setText(formatarNumeroMenorQueDez(numerosArray[1]));
                numeroTres.setText(formatarNumeroMenorQueDez(numerosArray[2]));
                numeroQuatro.setText(formatarNumeroMenorQueDez(numerosArray[3]));
                numeroCinco.setText(formatarNumeroMenorQueDez(numerosArray[4]));
                numeroSeis.setText(formatarNumeroMenorQueDez(numerosArray[5]));

                todosNumeros.setText(regastarTodosNumeros(numerosArray));
            }

            private String formatarNumeroMenorQueDez(int numero){
                return (numero < 10) ? "0" + numero : String.valueOf(numero);
            }

            private String regastarTodosNumeros(Integer[] numeros){
                return "Resultado:   " + formatarNumeroMenorQueDez(numeros[0]) + " - " + formatarNumeroMenorQueDez(numeros[1]) + " - " + formatarNumeroMenorQueDez(numeros[2]) + " - " + formatarNumeroMenorQueDez(numeros[3]) + " - " + formatarNumeroMenorQueDez(numeros[4]) + " - " + formatarNumeroMenorQueDez(numeros[5]);
            }
        });

        backPage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(MegaSenaActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
