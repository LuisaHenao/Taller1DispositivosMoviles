package com.lh.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InformacionCargos extends AppCompatActivity {
    private TextView textView7;
    RegistrarPersona registrarPersona = new RegistrarPersona();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView7 = findViewById(R.id.tvMostar);

        mostrarDatoslista(listaCargos(registrarPersona.empleados));
        textView7.setText("Luisa" );
    }

    public List<Cargos> listaCargos(List<Empleado> empleados){
        List<Cargos> cargos = new ArrayList<>();
        List<Cargos> cargos2 = new ArrayList<>();
        for (int i=0; i<empleados.size(); i++) {
            Cargos cargo = new Cargos(registrarPersona.empleados.get(i).getCargo(), registrarPersona.empleados.get(i).getSalario());
            cargos.add(cargo);
        }

        double suma = 0;
        int cant = 0;
        double promedio  ;
        for (int i=0; i<empleados.size(); i++){
            suma = 0;
            cant = 0;
            promedio = 0;
            Cargos cargo2 = new Cargos(cargos.get(i).getCargo());
            cargos2.add(cargo2);
            for (int j=0; j<empleados.size(); j++){
                if(cargos2.get(i).getCargo() == cargos.get(j).getCargo()){
                    suma += cargos.get(j).getSalario();
                    cant += 1;
                }
                promedio = suma / cant;
                Cargos cargo3 = new Cargos(cargos.get(i).getCargo(), suma, cant, promedio);
                cargos2.set(i, cargo3);
            }
        }
        cargos = cargos2.stream().distinct().collect(Collectors.toList());
        return  cargos;
    }

    public String mostrarDatoslista(List<Cargos> cargos){
        String datos = " ";
        for (int i=0; i<cargos.size(); i++){
            datos += "El cargo "+cargos.get(i).getCargo()+"La cantidad de personas: "+cargos.get(i).getCantSalario();
        }
        return datos;
    }
}