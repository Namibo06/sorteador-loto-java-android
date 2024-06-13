package br.com.waitomo.sorteadormegasena;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnMegaSena,btnDuplaSena,btnQuina,btnLotofacil;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMegaSena = findViewById(R.id.btnMegaSena);
        btnQuina = findViewById(R.id.btnQuina);
        btnLotofacil = findViewById(R.id.btnLotofacil);
        btnDuplaSena = findViewById(R.id.btnDuplaSena);

        btnMegaSena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MegaSenaActivity.class);
                startActivity(intent);
            }
        });

        btnLotofacil.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LotoFacilActivity.class);
                startActivity(intent);
            }
        });

        btnQuina.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuinaActivity.class);
                startActivity(intent);
            }
        });

        btnDuplaSena.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DuplaSenaActivity.class);
                startActivity(intent);
            }
        });
    }
}