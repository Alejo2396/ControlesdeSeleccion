package com.tuapp.controldeseleccion;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Lista extends AppCompatActivity {

    RadioGroup rgProductos;
    RadioButton rbTelevisor, rbRadio;
    EditText edPrecio, edDescuento, edTotal;
    CheckBox cbDescuento;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        rgProductos = findViewById(R.id.rgProductos);
        rbTelevisor = findViewById(R.id.rbTelevisor);
        rbRadio = findViewById(R.id.rbRadio);

        edPrecio = findViewById(R.id.edPrecio);
        edDescuento = findViewById(R.id.edDescuento);
        edTotal = findViewById(R.id.edTotal);
        cbDescuento = findViewById(R.id.cbDescuento);
        btnCalcular = findViewById(R.id.btnCalcular);

        // EditText de descuento solo activo si el CheckBox está marcado
        cbDescuento.setOnCheckedChangeListener((buttonView, isChecked) -> edDescuento.setEnabled(isChecked));

        btnCalcular.setOnClickListener(v -> {
            String precioStr = edPrecio.getText().toString();
            if (TextUtils.isEmpty(precioStr)) {
                Toast.makeText(Lista.this, "Ingrese un precio válido", Toast.LENGTH_SHORT).show();
                return;
            }

            double precio = Double.parseDouble(precioStr);
            double descuento = 0;

            if (cbDescuento.isChecked()) {
                String descStr = edDescuento.getText().toString();
                descuento = TextUtils.isEmpty(descStr) ? 0 : Double.parseDouble(descStr);
            }

            double total = precio - descuento;
            if (total < 0) total = 0;

            edTotal.setText(String.valueOf(total));

            String producto = rbTelevisor.isChecked() ? "Televisor" :
                    rbRadio.isChecked() ? "Radio" : "No seleccionado";

            Toast.makeText(Lista.this, "Producto: " + producto + " - Total: " + total, Toast.LENGTH_LONG).show();
        });
    }
}
