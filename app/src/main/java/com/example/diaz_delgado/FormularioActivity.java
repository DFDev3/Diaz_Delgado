package com.example.diaz_delgado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

public class FormularioActivity extends AppCompatActivity {
    EditText txtNombre,txtImg,txtPrecio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        txtNombre = findViewById(R.id.ednombre);
        txtPrecio = findViewById(R.id.edprecio);
        txtImg = findViewById(R.id.edUrl);
    }

    public void guardar(View view){
        Producto p = new Producto();
        p.setNombre(txtNombre.getText().toString());
        p.setPrecio(Double.parseDouble(txtPrecio.getText().toString()));
        p.setUrlImg(txtImg.getText().toString());

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        Toast.makeText(this, "Se guardó el objeto", Toast.LENGTH_SHORT).show();
    }
}