package com.example.tutorialapp.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tutorialapp.R;

public class IntentImplicito extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent_implicito);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Recuperar datos
        Bundle extras = getIntent().getExtras();
        String textoPrueba = extras.getString("Prueba");
        String textoComida = extras.getString("Comida");
        String textoBebida = extras.getString("Bebida");

        //Recuperar el TextView
        TextView tvComida = findViewById(R.id.textComidaa);
        TextView tvBebida = findViewById(R.id.textBebidaa);

        //Settear el texto
        tvComida.setText(textoComida);
        tvBebida.setText(textoBebida);
        //Probar si funciona
        Log.d("PRUEBA", textoBebida);

        //Recuperar el imageButton
        ImageButton imageButton = findViewById(R.id.imageBerenjena);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent actionView y le pasamos la url
                // String url="https://www.marca.com//";
                // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                //startActivity(intent);

                //Intent para la alarma

                Intent intentAlarma = new Intent(AlarmClock.ACTION_SET_ALARM)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, "Alarma clase")
                        .putExtra(AlarmClock.EXTRA_HOUR, 7)
                        .putExtra(AlarmClock.EXTRA_MINUTES, 10);
                startActivity(intentAlarma);


            }

        });
    }
}