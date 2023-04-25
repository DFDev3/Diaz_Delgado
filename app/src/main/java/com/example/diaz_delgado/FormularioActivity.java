package com.example.diaz_delgado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class FormularioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
    }



    public void guardar(View view){
        Producto p = new Producto();
        p.setNombre(txtNombre.getText().toString());
        p.setPrecio(Double.parseDouble(txtPrecio.getText().toString()));
        p.setUrlImg(txtImg.getText().toString());
    }
}