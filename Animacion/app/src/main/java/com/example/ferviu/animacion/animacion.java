package com.example.ferviu.animacion;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

public class animacion extends AppCompatActivity {

    AnimationDrawable animacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animacion);

        //Obtenemos el recurso creado en animacion.xml
        animacion=(AnimationDrawable)getResources().getDrawable(R.drawable.animacion);

        //Creamos una vista que contendrá una imagen
        ImageView imagen = new ImageView(this);

        //Le ponemos color de fondo
        imagen.setBackgroundColor(Color.WHITE);

        //Cargamos en lugar de una imagen, una animación.
        imagen.setImageDrawable(animacion);
        setContentView(imagen);
    }

    public boolean onTouchEvent(MotionEvent evento) {
        //Al realizar una pulsación en pantalla
        if (evento.getAction() == MotionEvent.ACTION_DOWN) {
            //Ponemos en marcha la animación
            animacion.start();
            return true;
        }
        return super.onTouchEvent(evento);
    }
}
