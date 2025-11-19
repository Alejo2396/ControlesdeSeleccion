package com.tuapp.controldeseleccion;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class TeamsActivity extends AppCompatActivity {

    Spinner spEquipos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

        spEquipos = findViewById(R.id.spEquipos);

        // Lista con el primer item como prompt
        String[] equipos = {
                "Selecciona un equipo",
                "Real Madrid",
                "Barcelona",
                "Manchester United",
                "Bayern Munich",
                "Liverpool",
                "Juventus",
                "PSG",
                "Chelsea",
                "Manchester City",
                "Milan"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                equipos
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spEquipos.setAdapter(adapter);
        spEquipos.setSelection(0); // Seleccionar el primer ítem por defecto
    }
}
