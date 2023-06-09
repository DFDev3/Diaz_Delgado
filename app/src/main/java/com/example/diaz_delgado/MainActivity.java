package com.example.diaz_delgado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Producto> prodList;
    private RecyclerView rvprods;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.listprodtitle));
        LoadData();
        rvprods = findViewById(R.id.rv);
        CustomAdapter myAdapter = new CustomAdapter(prodList);
        myAdapter.setOnItemClickListener(new CustomAdapter.onItemClickListener() {
            @Override
            public void onItemClick(Producto myprod, int posicion) {
                Intent intent = new Intent(MainActivity.this,Detalle.class);
                intent.putExtra("Producto",myprod);
                startActivity(intent);
            }
            @Override
            public void onItemBtnClick(Producto myprod, int posicion) {
                prodList.remove(posicion);
                myAdapter.setDataSet(prodList);
                Toast.makeText(MainActivity.this, getString(R.string.clicbtn)+myprod.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        rvprods.setAdapter(myAdapter);
        rvprods.setLayoutManager(new LinearLayoutManager(this));
    }

    public void LoadData() {
        Producto prod = new Producto();
        prod.setNombre("Computador HP");
        prod.setPrecio(3000000.0);
        prod.setUrlImg("https://www.bitbol.la/files/image/51/51647/636d05b1b1d95.jpg");

        Producto prod1 = new Producto("Keyboard", 200000.0, "https://www.bitbol.la/files/image/51/51647/636d05b1b1d95.jpg");
        Producto prod2 = new Producto("Mouse", 150000.0, "https://www.bitbol.la/files/image/51/51647/636d05b1b1d95.jpg");

        prodList = new ArrayList<>();
        prodList.add(prod);
        prodList.add(prod1);
        prodList.add(prod2);
    }

    public void clicLogout(View view){
        SharedPreferences preferences = getSharedPreferences("Tienda_App",0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();

        startActivity(new Intent(this,LoginActivity.class));
    }
}