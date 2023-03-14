package com.example.diaz_delgado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Producto> prodList;
    private RecyclerView rvprods;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoadData();
        rvprods = findViewById(R.id.rv);
        CustomAdapter myAdapter = new CustomAdapter(prodList);

        rvprods.setAdapter(myAdapter);
        rvprods.setLayoutManager(new LinearLayoutManager(this));
    }

    public void LoadData() {
        Producto prod = new Producto();
        prod.setNombre("Computador HP");
        prod.setPrecio(3000000.0);
        prod.setUrlImg("https://d34vmoxq6ylzee.cloudfront.net/catalog/product/cache/b3b166914d87ce343d4dc5ec5117b502/4/3/43K30LT-1_T1646844157.png");

        Producto prod1 = new Producto("Keyboard", 200000.0, "https://i.dell.com/is/image/DellContent/content/dam/images/products/electronics-and-accessories/dell/keyboards/kb500/kb500-kbm-02-bk.psd?fmt=pjpg&pscan=auto&scl=1&hei=402&wid=852&qlt=100,1&resMode=sharp2&size=852,402&chrss=full");
        Producto prod2 = new Producto("Mouse", 150000.0, "https://liquimarcas.co/wp-content/uploads/2021/05/mouse-gamer-usb-havit-ms1018-1.jpg");

        prodList = new ArrayList<>();
        prodList.add(prod);
        prodList.add(prod1);
        prodList.add(prod2);
    }
}