package com.lh.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ConsultaInformacion extends AppCompatActivity {
    private TextView tvPersona;
    private TextView tvNombreCon;
    private TextView tvApellidosCon;
    private TextView tvEdadCon;
    private TextView tvCorreoCon;
    private TextView tvCargoCon;
    private TextView tvSalarioCon;
    private int tipo;

    RegistrarPersona registrarPersona = new RegistrarPersona();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_informacion);
        Intent intent = getIntent();
        String titulo = intent.getStringExtra("name");
        tipo = intent.getIntExtra("tipo", 1);
        tvPersona = findViewById(R.id.tvPersona);
        tvNombreCon = findViewById(R.id.tvNombreCon);
        tvApellidosCon = findViewById(R.id.tvApellidosCon);
        tvEdadCon = findViewById(R.id.tvEdadCon);
        tvCorreoCon = findViewById(R.id.tvCorreoCon);
        tvCargoCon = findViewById(R.id.tvCargoCon);
        tvSalarioCon = findViewById(R.id.tvSalarioCon);
        tvPersona.setText(titulo);

        mostrarDatos();


    }

    public int obtenerPersonaJoven(List<Empleado> empleados){
        int menor= 999999;
        int idEmpleado =0;
        for (int i=0; i<empleados.size(); i++) {
            if (empleados.get(i).getEdad() < menor) {
                menor = empleados.get(i).getEdad();
                idEmpleado = i;
            }
        }
        return idEmpleado;
    }

    public int obtenerPersonaVieja(List<Empleado> empleados){
        int mayor= 0;
        int idEmpleado =0;
        for (int i=0; i<empleados.size(); i++) {
            if (empleados.get(i).getEdad() > mayor) {
                mayor = empleados.get(i).getEdad();
                idEmpleado = i;
            }
        }
        return idEmpleado;
    }


    public void mostrarDatos(){
        int id = obtenerPersonaJoven(registrarPersona.empleados);
        if (tipo == 1){
            id = obtenerPersonaJoven(registrarPersona.empleados);
        }

        if (tipo == 2){
            id = obtenerPersonaVieja(registrarPersona.empleados);
        }


        tvNombreCon.setText(registrarPersona.empleados.get(id).getNombre());
        tvApellidosCon.setText(registrarPersona.empleados.get(id).getApellidos());
        tvEdadCon.setText(String.valueOf(registrarPersona.empleados.get(id).getEdad()));
        tvCorreoCon.setText(registrarPersona.empleados.get(id).getCorreo());
        tvCargoCon.setText(registrarPersona.empleados.get(id).getCargo());
        tvSalarioCon.setText( String.valueOf(registrarPersona.empleados.get(id).getSalario()));
    }


}