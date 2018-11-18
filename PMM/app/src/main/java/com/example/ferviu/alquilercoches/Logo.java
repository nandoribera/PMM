package com.example.ferviu.alquilercoches;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Logo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new LogoCoche(this));
    }

    public class LogoCoche extends View{
        public LogoCoche(Context context) {
            super(context);
        }
        @Override
        protected void onDraw(Canvas canvas){

            //declarar pinceles
            Paint pincel = new Paint();
            Paint pincel1 = new Paint();

            //pincel dibujo
            pincel.setColor(Color.BLACK);
            pincel.setStrokeWidth(20);
            pincel.setStyle(Paint.Style.FILL_AND_STROKE);

            //pincel texto
            pincel1.setColor(Color.BLACK);
            pincel1.setTextSize(100);
            pincel1.setStyle(Paint.Style.FILL_AND_STROKE);

            //texto
            canvas.drawText("Alquileres DAM", 150, 200, pincel1);

            //ruedas
            canvas.drawCircle(300,600, 80, pincel);
            canvas.drawCircle(700,600, 80, pincel);

            //cabina
            canvas.drawLine(100, 600,900,600, pincel);
            canvas.drawLine(100,400,100,600, pincel);
            canvas.drawLine(100,400,300,400, pincel);
            canvas.drawLine(300,300,300,400, pincel);
            canvas.drawLine(300,300,500,300, pincel);
            canvas.drawLine(500,300,700,400, pincel);
            canvas.drawLine(700,400,900,400, pincel);
            canvas.drawLine(900,400,900,600, pincel);
        }
    }
}
