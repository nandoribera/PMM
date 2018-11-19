package com.example.ferviu.areas;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final Intent intent = getIntent();
        intent.getExtras();

        Figura objectFigura = (Figura) intent.getSerializableExtra("Object");

        TextView nombre = findViewById(R.id.nombre);
        ImageView imagen = findViewById(R.id.imagen);

        nombre.setText(objectFigura.getNombre());
        imagen.setBackground(getDrawable(objectFigura.getImagen()));

    }
}
