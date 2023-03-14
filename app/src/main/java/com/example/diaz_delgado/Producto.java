package com.example.diaz_delgado;

public class Producto {
    private String nombre,urlImg;
    private Double precio;


    public Producto(){}
    public Producto(String nombre, Double precio, String urlImg) {
        this.nombre = nombre;
        this.precio = precio;
        this.urlImg = urlImg;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
}
