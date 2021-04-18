package com.lh.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.ib.custom.toast.CustomToastView;
import com.omarshehe.forminputkotlin.FormInputText;

import java.util.ArrayList;
import java.util.List;

public class RegistrarPersona extends AppCompatActivity  implements OnClickListener {
    private FormInputText txtNombre;
    private FormInputText txtApellidos;
    private FormInputText txtCorreo;
    private FormInputText txtEdad;
    private FormInputText txtCargo;
    private FormInputText txtSalario;
    private Button btnGuardar;
    //public static ArrayList<Empleado> empleados = new ArrayList<>();
    public  static List<Empleado> empleados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_persona);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellidos = findViewById(R.id.txtApellidos);
        txtCorreo = findViewById(R.id.txtCorreo);
        txtEdad = findViewById(R.id.txtEdad);
        txtCargo = findViewById(R.id.txtCargo);
        txtSalario = findViewById(R.id.txtSalario);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(this);

    }

  @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnGuardar){
            String nombre = txtNombre.getValue();
            String apellidos = txtApellidos.getValue();
            String correo = txtCorreo.getValue();
            int edad = Integer.parseInt(txtEdad.getValue());
            String cargo = txtCargo.getValue();
            double salario = Double.parseDouble(txtSalario.getValue());
            Empleado empleado = new Empleado(nombre, apellidos, edad, correo, cargo, salario);
            empleados.add(empleado);
            CustomToastView.makeSuccessToast(this, "Empleado agregado ", R.layout.custom_toast).show();
            txtNombre.setValue( " ");


        }
    }
}