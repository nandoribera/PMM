package com.example.ferviu.elementosobjetos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Titular extends AppCompatActivity {

    private String titulo;
    private String subtitulo;
    private int imagen;

    public Titular(String tit, String sub, int img){
        titulo = tit;
        subtitulo = sub;
        imagen = img;

    }

    public String getTitulo(){
        return titulo;
    }

    public String getSubtitulo(){
        return subtitulo;
    }

    public int getImagen(){
        return imagen;
    }

}
