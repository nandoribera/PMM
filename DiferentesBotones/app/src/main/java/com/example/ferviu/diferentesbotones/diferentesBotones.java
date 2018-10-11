package com.example.ferviu.diferentesbotones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class diferentesBotones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diferentes_botones);

        final TextView lblMensaje = (TextView)findViewById(R.id.LblMensaje);
        final Button btn1 = (Button)findViewById(R.id.BtnBoton1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblMensaje.setText("Botón 1 pulsado");
            }
        });

        final ToggleButton btn2 = (ToggleButton)findViewById(R.id.BtnBoton2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn2.isChecked())
                    lblMensaje.setText("Botón 2: ON");
                else
                    lblMensaje.setText("Botón 2: OFF");
            }
        });

        final ImageButton btn3 =(ImageButton)findViewById(R.id.BtnBoton3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblMensaje.setText("Botón 3 pulsado!");
            }
        });

        final ToggleButton btn4 = (ToggleButton)findViewById(R.id.BtnBoton4);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn2.isChecked())
                    lblMensaje.setText("Botón 4: ON");
                else
                    lblMensaje.setText("Botón 4: OFF");
            }
        });
    }
}
