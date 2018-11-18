package com.example.ferviu.alquilercoches;

import java.io.Serializable;

public class Coche implements Serializable {
    private String modelo;
    private String marca;
    private int precio;
    private int imagen;

    public Coche(String modelo, String marca, int precio, int imagen){
        this.modelo = modelo;
        this.setMarca(marca);
        this.setPrecio(precio);
        this.setImagen(imagen);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
