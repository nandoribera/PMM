package com.example.ferviu.areas;

import java.io.Serializable;

public class Figura implements Serializable {

    private String nombre;
    private int imagen;

    public Figura(String nombre, int imagen){
        this.setNombre(nombre);
        this.setImagen(imagen);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
