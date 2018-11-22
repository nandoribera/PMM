package com.example.ferviu.solobici;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

class Grafico {

    private Drawable drawable //Imagen

    //Posición y velocidad de los graficos en pantalla
    private double posX, posY, incX, incY;
    private int ancho, alto;
    private int angulo, rotacion;
    private int radioColision;
    private View view;

    public static final int MAX_VELOCIDAD = 20;

    public Grafico(View view, Drawable drawable){
        this.view = view;
        this.drawable = drawable;
        ancho = drawable.getIntrinsicWidth();
        alto = drawable.getIntrinsicHeight();
        radioColision = (alto + ancho) / 4;
    }

    public void dibujarGrafico(Canvas canvas){
        canvas.save();
        int x = (int) (posX + ancho / 2);
        int y = (int) (posY + alto / 2);

        canvas.rotate((float) angulo);
    }

}

