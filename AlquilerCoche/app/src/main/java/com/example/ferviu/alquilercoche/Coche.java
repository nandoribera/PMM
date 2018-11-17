package com.example.ferviu.alquilercoche;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Coche extends AppCompatActivity {

    private String nombre;
    private String marca;
    private int precio;
    public int image;

    public Coche(String nombre, String marca, int precio, int image) {
        nombre = nombre;
        marca = marca;
        precio = precio;
        image = image;
    }

    public String getNombre() { return nombre; }

    public String getMarca() { return marca; }

    public int getPrecio(){ return precio;}

    public int getImage(){return image; }
}
