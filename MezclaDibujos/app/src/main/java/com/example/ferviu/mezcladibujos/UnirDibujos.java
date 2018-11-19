package com.example.ferviu.mezcladibujos;

import android.content.Context;
import android.content.pm.LauncherApps;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

public class UnirDibujos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiDibujo(this));
        //setContentView();
        Toast.makeText(this, "Dibujar circulo", Toast.LENGTH_SHORT).show();
    }

    class MiDibujo extends View {
        private ShapeDrawable miDrawable;

        public MiDibujo(Context c) {
            super(c);
        }

        protected void onDraw(Canvas c) {
            Paint miPincel = new Paint();
            Paint miPincel2 = new Paint();

            miPincel.setColor(Color.RED);
            miPincel2.setColor(Color.BLUE);

            miPincel.setStyle(Paint.Style.FILL_AND_STROKE);
            miPincel2.setStyle(Paint.Style.FILL_AND_STROKE);

            c.drawRect(130, 200, 350, 420, miPincel);
            c.drawCircle(70, 70, 50, miPincel2);
            c.drawCircle(410, 70, 50, miPincel2);
            c.drawCircle(70, 600, 50, miPincel2);
            c.drawCircle(410, 600, 50, miPincel2);

            /*
            miPincel.setTextSize(30);
            lienzo.drawText("MI CIRCULO",100,450,miPincel);
            String mensaje="Ancho: " + getWidth()+" Alto: "+ getHeight();
            lienzo.drawText(mensaje,100,500,miPincel);
            Toast.makeText(getApplicationContext(), "mas dibujos", Toast.LENGTH_SHORT).show();
            */
        }
    }
}
