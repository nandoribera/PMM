package com.example.ferviu.transiciones;

import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class transiciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transiciones);



        ImageView imagen = new ImageView(this);
        setContentView(imagen);
        TransitionDrawable mi_transicion = (TransitionDrawable)
                getResources().getDrawable(R.drawable.transicion);
        imagen.setImageDrawable(mi_transicion);



        mi_transicion.startTransition(2000);
    }

}
