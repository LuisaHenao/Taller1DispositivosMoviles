package com.lh.taller;

import java.util.ArrayList;

public class Persona {

    private String nombre;
    private String apellidos;
    private int edad;
    private String correo;

    public Persona() {
    }
    public Persona(String nombre, String apellidos, int edad, String correo) {

        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.correo = correo;

    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre() {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos() {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo() {
        this.correo = correo;
    }







}
