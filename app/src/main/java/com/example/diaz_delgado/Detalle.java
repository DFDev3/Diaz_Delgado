package com.example.diaz_delgado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Detalle extends AppCompatActivity {

    private TextView tvTituloDetalle,tvPrecioDetalle;
    private ImageView ivImagenDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        setTitle(getString(R.string.DetalleTitle));

        tvTituloDetalle = findViewById(R.id.detalletv);
        ivImagenDetalle = findViewById(R.id.detalleiv);
        tvPrecioDetalle = findViewById(R.id.detallepreciotv);

        Producto miProductoAtrapado = (Producto) getIntent().getSerializableExtra("Producto");

        tvTituloDetalle.setText(miProductoAtrapado.getNombre());
        tvPrecioDetalle.setText(miProductoAtrapado.getPrecio().toString());
        Picasso.get()
                .load(miProductoAtrapado.getUrlImg())
                .error(R.drawable.ic_launcher_background)
                .into(ivImagenDetalle);




    }
}