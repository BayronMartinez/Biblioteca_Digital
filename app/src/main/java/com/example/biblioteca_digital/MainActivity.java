package com.example.biblioteca_digital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ProgressBar carga;
    private EditText user, contra;
    private Button entrar;
    private ImageButton Github;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carga = (ProgressBar)findViewById(R.id.progressBar);
        user = (EditText)findViewById(R.id.ed_user);
        contra = (EditText)findViewById(R.id.ed_contra);
        entrar = (Button)findViewById(R.id.btn_login);
        Github = (ImageButton)findViewById(R.id.img_btn);

        Github.setVisibility(View.INVISIBLE);
        carga.setVisibility(View.INVISIBLE);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Task().execute();
            }
        });
    }

    public void boton(View v)
    {
        ArrayList<String> libros = new ArrayList<String>();
        libros.add("Farenheith");
        libros.add("Revival");
        libros.add("El Alquimista");

        Intent i = new Intent(getBaseContext(), github.class);
        i.putExtra("listaLibros",libros);

        startActivity(i);
        Github.setVisibility(View.INVISIBLE);
    }

    class Task extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute()
        {
            carga.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings)
        {
            for (int i = 1; i <= 5; i++)
            {
                try
                {
                    Thread.sleep(500);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            carga.setVisibility(View.INVISIBLE);

            if(user.getText().toString().trim().equals("Android"))
            {
                if(contra.getText().toString().trim().equals("123"))
                {
                    Github.setVisibility(View.VISIBLE);
                }
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Usuario incorrecto", Toast.LENGTH_SHORT).show();
            }
            if(contra.getText().toString().trim().equals("123"))
            {
                if(user.getText().toString().trim().equals("Android"))
                {
                    Github.setVisibility(View.VISIBLE);
                }
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
            }
        }
    }
}