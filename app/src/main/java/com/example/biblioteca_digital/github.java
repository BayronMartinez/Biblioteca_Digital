package com.example.biblioteca_digital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class github extends AppCompatActivity {

    private Spinner  libros;
    private TextView costo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github);

        libros=(Spinner)findViewById(R.id.spinner);
        costo=(TextView)findViewById(R.id.txt_valor);

        ArrayList<String> listaLisbros = (ArrayList<String>) getIntent().getSerializableExtra("listaLibros");

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaLisbros);

        libros.setAdapter(adapt);
    }

    public void mostrar(View v)
    {
        String elegido = libros.getSelectedItem().toString();
        if (elegido.equals("Farenheith")){
            costo.setText("El valor de " + elegido + " es: 5000");
        }
        else if (elegido.equals("Revival")){
            costo.setText("El valor de " + elegido + " es: 12000");
        }
        else if (elegido.equals("El Alquimista")){
            costo.setText("El valor de " + elegido + " es: 45000");
        }
    }
}