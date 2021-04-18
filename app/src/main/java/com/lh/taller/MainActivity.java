package com.lh.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private Button btnRegistrar;
    private Button btnViejo;
    private Button btnJoven;
    private Button btnSalarios;
    private Button btnCargos;
    RegistrarPersona registrarPersona = new RegistrarPersona();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnViejo = findViewById(R.id.btnViejo);
        btnJoven = findViewById(R.id.btnJoven);
        btnSalarios = findViewById(R.id.btnSalarios);
        btnCargos = findViewById(R.id.btnCargos);

        btnRegistrar.setOnClickListener(this);
        btnViejo.setOnClickListener(this);
        btnJoven.setOnClickListener(this);
        btnSalarios.setOnClickListener(this);
        btnSalarios.setOnClickListener(this);
        btnCargos.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnRegistrar){
            Intent Myintent = new Intent(this, RegistrarPersona.class );
            startActivity(Myintent);
        }

        if (v.getId() == R.id.btnViejo  ){
            Intent Myintent = new Intent(this, ConsultaInformacion.class );
            Myintent.putExtra("name", "Persona más vieja");
             Myintent.putExtra("tipo", 2);
            startActivity(Myintent);
        }
        if ( v.getId() == R.id.btnJoven  ){

            Intent Myintent = new Intent(this, ConsultaInformacion.class );
            Myintent.putExtra("name", "Persona más joven");
            Myintent.putExtra("tipo", 1);
            startActivity(Myintent);

        }
        if (v.getId() == R.id.btnSalarios   ){
            Intent Myintent = new Intent(this, InformacionSalarios.class );
            startActivity(Myintent);
        }
        if (v.getId() == R.id.btnCargos   ){
            Intent Myintent = new Intent(this, MostrarCargos.class );
            startActivity(Myintent);
        }
    }


}