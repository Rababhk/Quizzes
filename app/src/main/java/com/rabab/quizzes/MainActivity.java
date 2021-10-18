package com.rabab.quizzes;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.os.IResultReceiver;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Preguntas> lstPreguntas = new ArrayList<>();
    RadioButton opcion1, opcion2;
    TextView numero, pregunta;
    int a = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        opcion1 = findViewById(R.id.radioButton);
        opcion2 = findViewById(R.id.radioButton2);

        numero = findViewById(R.id.textView2);
        pregunta = findViewById(R.id.textView);

        lstPreguntas.add(new Preguntas("¿Hasta dónde se lavan la cara los calvos?", "Hasta la frente", "No tienen limite", "Hasta la frente"));
        lstPreguntas.add(new Preguntas("¿Existe la palabra \"abuhado\"? ", "Si existe", "No, es inventada", "Si existe"));
        lstPreguntas.add(new Preguntas("¿Son consideradas las matrículas retroreflectantes como catadióptricos?", "Obvio", "Claro que no", "Claro que no"));

        PreguntasAdjudicadas(a);
    }

    private void PreguntasAdjudicadas(int count) {
        Preguntas preguntas = lstPreguntas.get(count);
        numero.setText((count + 1) + "/3");
        pregunta.setText(preguntas.pregunta);
        opcion1.setText(preguntas.opcion1);
        opcion2.setText(preguntas.opcion2);
        a = count;
    }

    public void opcionSeleccionada(View view) {
        opcion1.setChecked(false);
        opcion2.setChecked(false);
        Preguntas preguntas = lstPreguntas.get(a);
        opcion1 = findViewById(R.id.radioButton);
        opcion2 = findViewById(R.id.radioButton2);
        Boolean FinQuizzes = false;

        Intent irCosa = new Intent(this, MainActivity2.class);

        switch (view.getId()) {

            case R.id.radioButton:
                if (opcion1.getText() == preguntas.resultado) {

                    if (a < lstPreguntas.size()) {

                        //2- añadir toda la informacion que queremos pasar a la otra pantalla
                        irCosa.putExtra("mensaje", "¡Correcto!\uD83E\uDD73");
                        irCosa.putExtra("textoBoton", "Volver");
                        //3- Nos vamos al detail activity
                        startActivity(irCosa);
                        a++;
                        PreguntasAdjudicadas(a);

                    } else {


                        //2- añadir toda la informacion que queremos pasar a la otra pantalla
                        irCosa.putExtra("mensaje", "Acabaste el test cerebrito \uD83E\uDD13 ");
                        irCosa.putExtra("textoBoton", "Volver a jugar");
                        //3- Nos vamos al detail activity
                        startActivity(irCosa);

                        a++;
                        FinQuizzes = true;
                    }

                    if (FinQuizzes && a == 4) {
                        //1- Buscamos informacion procedente del main activity
                        Bundle extras1 = getIntent().getExtras();
                        //2- Enlazamos cada campo con el dato correspondiente
                        a = Integer.parseInt(extras1.getString("contador"));
                        PreguntasAdjudicadas(a);
                    }


                } else {
                    //2- añadir toda la informacion que queremos pasar a la otra pantalla
                    irCosa.putExtra("mensaje", "¡Incorrecto!\uD83D\uDE29");
                    irCosa.putExtra("textoBoton", "Volver");
                    //3- Nos vamos al detail activity
                    startActivity(irCosa);

                }


                break;

            case R.id.radioButton2:
                if (opcion2.getText() == preguntas.resultado) {

                    if (a < lstPreguntas.size() - 1) {
                        //2- añadir toda la informacion que queremos pasar a la otra pantalla
                        irCosa.putExtra("mensaje", "¡Correcto!\uD83E\uDD73");
                        irCosa.putExtra("textoBoton", "Volver");
                        //3- Nos vamos al detail activity
                        startActivity(irCosa);
                        a++;
                        PreguntasAdjudicadas(a);


                    } else {

                        //2- añadir toda la informacion que queremos pasar a la otra pantalla
                        irCosa.putExtra("mensaje", "Acabaste el test cerebrito \uD83E\uDD13 ");
                        irCosa.putExtra("textoBoton", "Volver a jugar");
                        //3- Nos vamos al detail activity
                        startActivity(irCosa);
                        a++;
                        FinQuizzes = true;
                    }
                    if (FinQuizzes && a == 4) {
                        //1- Buscamos informacion procedente del main activity
                        Bundle extras1 = getIntent().getExtras();
                        //2- Enlazamos cada campo con el dato correspondiente
                        a = Integer.parseInt(extras1.getString("contador"));
                        PreguntasAdjudicadas(a);
                    }

                } else {

                    //2- añadir toda la informacion que queremos pasar a la otra pantalla
                    irCosa.putExtra("mensaje", "¡Incorrecto!\uD83D\uDE29");
                    irCosa.putExtra("textoBoton", "Volver");
                    //3- Nos vamos al detail activity
                    startActivity(irCosa);

                }
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }

    }


}