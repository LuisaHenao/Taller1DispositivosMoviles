package com.lh.taller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Empleado extends Persona {
    private String cargo;
    private double salario;

    public Empleado(){

    }

    public Empleado(String nombre, String apellidos, String correo, int edad, String cargo, double salario){

    }

    public Empleado(String nombre, String apellidos, int edad, String correo,  String cargo, double salario) {
        super(nombre, apellidos, edad, correo);

        this.cargo = cargo;
        this.salario = salario;
    }


    public String getCargo() {
        return cargo;
    }

    public void setCargo() {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario() {
        this.salario = salario;
    }




}
