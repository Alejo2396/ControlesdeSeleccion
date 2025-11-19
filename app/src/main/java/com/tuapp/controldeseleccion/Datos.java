package com.tuapp.controldeseleccion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Datos extends AppCompatActivity {

    EditText edNombre, edApellido;
    Spinner spColegios;
    RadioGroup rgGenero;
    RadioButton rbFemenino, rbMasculino;
    CheckBox cbLeer, cbVerSeries, cbEscribir, cbPeliculas;
    Button btnRegistrar, btnLista, btnTeams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        edNombre = findViewById(R.id.edNombre);
        edApellido = findViewById(R.id.edApellido);

        spColegios = findViewById(R.id.spColegios);
        rgGenero = findViewById(R.id.rgGenero);
        rbFemenino = findViewById(R.id.rbFemenino);
        rbMasculino = findViewById(R.id.rbMasculino);

        cbLeer = findViewById(R.id.cbLeer);
        cbPeliculas = findViewById(R.id.cbPeliculas);
        cbEscribir = findViewById(R.id.cbEscribir);
        cbVerSeries = findViewById(R.id.cbVerSeries);

        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnLista = findViewById(R.id.btnLista);
        btnTeams = findViewById(R.id.btnTeams); // ← AGREGADO

        // Botón registrar
        btnRegistrar.setOnClickListener(v ->
                Toast.makeText(Datos.this, "Datos registrados", Toast.LENGTH_SHORT).show()
        );

        // Botón ir a Lista
        btnLista.setOnClickListener(v -> {
            Intent siguiente = new Intent(Datos.this, Lista.class);
            startActivity(siguiente);
        });

        // Botón ir a TeamsActivity ← AGREGADO
        btnTeams.setOnClickListener(v -> {
            Intent intent = new Intent(Datos.this, TeamsActivity.class);
            startActivity(intent);
        });

        // Spinner colegios
        spColegios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    Toast.makeText(Datos.this, "Seleccionó: " + spColegios.getSelectedItem(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        // RadioGroup Género
        rgGenero.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbFemenino) {
                Toast.makeText(Datos.this, "Usted es una Dama", Toast.LENGTH_SHORT).show();
            } else if (checkedId == R.id.rbMasculino) {
                Toast.makeText(Datos.this, "Usted es un Caballero", Toast.LENGTH_SHORT).show();
            }
        });

        // CheckBoxes
        cbEscribir.setOnCheckedChangeListener((buttonView, isChecked) ->
                Toast.makeText(Datos.this, isChecked ? "Modo Escritura Activada" : "Modo Escritura Desactivada", Toast.LENGTH_SHORT).show()
        );

        cbLeer.setOnCheckedChangeListener((buttonView, isChecked) ->
                Toast.makeText(Datos.this, isChecked ? "Modo Lectura Activada" : "Modo Lectura Desactivada", Toast.LENGTH_SHORT).show()
        );

        cbVerSeries.setOnCheckedChangeListener((buttonView, isChecked) ->
                Toast.makeText(Datos.this, isChecked ? "Estás viendo Doraemon" : "Dejaste de ver Doraemon", Toast.LENGTH_SHORT).show()
        );

        cbPeliculas.setOnCheckedChangeListener((buttonView, isChecked) ->
                Toast.makeText(Datos.this, isChecked ? "Estás viendo Crepúsculo" : "Dejaste de ver Crepúsculo", Toast.LENGTH_SHORT).show()
        );
    }
}
