package com.lh.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MostrarCargos extends AppCompatActivity {
    RegistrarPersona registrarPersona = new RegistrarPersona();
    private TextView tvluisa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_cargos);
        tvluisa  = findViewById(R.id.tvluisa);


        // tvluisa.setText(mostrarDatoslista(listaCargos(registrarPersona.empleados)));
       // tvluisa.setText(mostrarDatoslista2(lista(registrarPersona.empleados)));
        tvluisa.setText(mostrarDatoslista2(listaCargosDatos(registrarPersona.empleados, lista(registrarPersona.empleados))));
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
        for (int i=0; i<cargos.size(); i++){
            suma = 0;
            cant = 0;
            promedio = 0;
            Cargos cargo2 = new Cargos(cargos.get(i).getCargo());
            cargos2.add(cargo2);
            for (int j=0; j<cargos.size(); j++){
                if(cargos2.get(i).getCargo() == cargos.get(j).getCargo()){
                    suma += cargos.get(j).getSalario();
                    cant += 3;
                }

            }
            promedio = suma / cant;
            Cargos cargo3 = new Cargos(cargos2.get(i).getCargo(), suma, cant, promedio);
            cargos2.set(i, cargo3);
        }
        cargos = cargos2.stream().distinct().collect(Collectors.toList());
        return  cargos2;
    }


    public List<String> lista (List<Empleado> empleados){
        List<String> cargos = new ArrayList<>();
        for (int i=0; i<empleados.size(); i++) {
            cargos.add(registrarPersona.empleados.get(i).getCargo());
        }
        cargos = cargos.stream().distinct().collect(Collectors.toList());
        return cargos;
    }

    public List<Cargos> listaCargosDatos(List<Empleado> empleados, List<String> listcargos){

        double salario = 0;
        double promedio = 0;
        int cantidad = 0;
        List<Cargos> cargos = new ArrayList<>();

        for(int i=0; i< listcargos.size();i++){
            salario =0;
            cantidad =0;
            for(int j=0; j<empleados.size(); i ++){
                if(listcargos.get(i) == empleados.get(j).getCargo()){
                    salario += empleados.get(j).getSalario();
                    cantidad += 1;
                }
            }
            promedio = salario / cantidad;
            Cargos cargo = new Cargos(listcargos.get(i), salario, cantidad, promedio);
            cargos.add(cargo);

        }
        return cargos;
    }



    public String mostrarDatoslista(List<Cargos> cargos){
        String datos = " ";
        for (int i=0; i<cargos.size(); i++){
            datos += " El cargo "+cargos.get(i).getCargo()+" La cantidad de personas: "+cargos.get(i).getCantSalario()+"\n";
        }
        return datos;
    }

    public String mostrarDatoslista2(List<Cargos> cargos){
        String datos = " ";
        for (int i=0; i<cargos.size(); i++){
            datos += " El cargo "+cargos.get(i).getCargo()+" La cantidad de personas: "+cargos.get(i).getCantSalario()+"\n";
        }
        return datos;
    }
}