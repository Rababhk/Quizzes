package com.rabab.quizzes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        int c = 1;

        TextView resultado;
        Button volver;

        volver = findViewById(R.id.button);

        resultado = findViewById(R.id.textView3);
        //1- Buscamos informacion procedente del main activity
        Bundle extras = getIntent().getExtras();
        //2- Enlazamos cada campo con el dato correspondiente
        resultado.setText(extras.getString("mensaje") );
        volver.setText(extras.getString("textoBoton"));


        if (volver.getText().equals("Volver") ) {
            volver.setOnClickListener(view -> {
                finish();
            });
        }else{
            volver.setOnClickListener(view -> {
                Intent irCosa1 = new Intent(this, MainActivity.class);
                //2- añadir toda la informacion que queremos pasar a la otra pantalla
                irCosa1.putExtra("contador", "0");
                //3- Nos vamos al detail activity
                startActivity(irCosa1);
            });
        }


    }
}