package com.example.ferviu.botonesnormales;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class botonesNormales extends Activity {
    Context ctx=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx=this;

        setContentView(R.layout.activity_botones_normales);

        final TextView miTxt = (TextView)this.findViewById(R.id.mitxt);
        Button btn=(Button)this.findViewById(R.id.cmdTres);
        btn.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, "Pulsado botón Tres", Toast.LENGTH_SHORT).show();
            }}
        );
    }

    public void cmdDos_click(View v){
        Toast.makeText(this, "Pulsado botón Dos", Toast.LENGTH_SHORT).show();
    }
}