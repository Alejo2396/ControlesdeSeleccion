package com.tuapp.controldeseleccion;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnTeams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTeams = findViewById(R.id.btnTeams);

        btnTeams.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, TeamsActivity.class))
        );
    }
}
