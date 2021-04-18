package com.lh.taller;

public class Cargos {
    private String cargo;
    private double salario;
    private int cantSalario;
    private double promSalario;

    public Cargos(){

    }
    public Cargos(String cargo){
        this.cargo = cargo;

    }

    public Cargos(String cargo, double salario){
        this.cargo = cargo;
        this.salario = salario;


    }
    public Cargos(String cargo, double salario, int cantSalario, double promSalario ){
        this.cargo = cargo;
        this.salario = salario;
        this.cantSalario = cantSalario;
        this.promSalario = promSalario;


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

    public double getCantSalario() {
        return cantSalario;
    }

    public void setCantSalarioSalario() {
        this.cantSalario = cantSalario;
    }

    public double getPromSalario() {
        return promSalario;
    }

    public void setPromSalarioSalarioSalario() {
        this.promSalario = promSalario;
    }
}
