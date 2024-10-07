package com.example.tutorialapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tutorialapp.intents.IntentExplicito;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Obtener elemento(botón) de la vista
        Button btnIntent = findViewById(R.id.buttonIntent);

        //Añadir un OnClickListener al elemento
        btnIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear intent explicito. Nombramos el componente al cual queremos hacer la actividad
                Intent intentExplicito = new Intent(MainActivity.this, IntentExplicito.class);

                //En un intentExplicito se nombra el componente sobre el que realizamos la acción
                //Iniciar actividad
                startActivity(intentExplicito);

            }
        });
    }
}