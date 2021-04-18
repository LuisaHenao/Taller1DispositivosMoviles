package com.lh.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InformacionSalarios extends AppCompatActivity {
    private TextView tvSalarioAlto;
    private TextView tvSalarioBajo;
    private TextView tvSalarioProm;
    RegistrarPersona registrarPersona = new RegistrarPersona();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_salarios);
        tvSalarioAlto = findViewById(R.id.tvSalarioAlto);
        tvSalarioBajo = findViewById(R.id.tvSalarioBajo);
        tvSalarioProm = findViewById(R.id.tvSalarioProm);

        tvSalarioAlto.setText(String.valueOf(obtenerSalarioMayor(registrarPersona.empleados)));
        tvSalarioBajo.setText(String.valueOf(obtenerSalarioMenor(registrarPersona.empleados)));
        tvSalarioProm.setText(String.valueOf(obtenerSalarioPromedio(registrarPersona.empleados)));
    }
    public double obtenerSalarioMayor(List<Empleado> empleados){
        double SalarioMayor=0;
        for (int i=0; i<empleados.size(); i++) {
            if (empleados.get(i).getSalario() > SalarioMayor){
                SalarioMayor = empleados.get(i).getSalario();
            }
        }
        return SalarioMayor;
    }

    public double obtenerSalarioMenor(List<Empleado> empleados){
        double SalarioMenor = 999999;
        for (int i=0; i<empleados.size(); i++) {
            if (empleados.get(i).getSalario() < SalarioMenor){
                SalarioMenor = empleados.get(i).getSalario();
            }
        }
        return SalarioMenor;
    }

    public double obtenerSalarioPromedio(List<Empleado> empleados){
        double SumaSalarios = 0;
        int CantEmpleados = 0;
        double PromedioSalarios = 0;
        for (int i=0; i<empleados.size(); i++) {
            SumaSalarios += empleados.get(i).getSalario();
            CantEmpleados +=1;
        }
        PromedioSalarios = SumaSalarios/CantEmpleados;
        PromedioSalarios=Math.round(PromedioSalarios*100.0)/100.0;
        return PromedioSalarios;
    }



}