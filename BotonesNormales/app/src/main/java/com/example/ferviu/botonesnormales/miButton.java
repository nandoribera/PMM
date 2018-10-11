package com.example.ferviu.botonesnormales;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class miButton extends android.support.v7.widget.AppCompatButton implements View.OnClickListener {
    Context ctx=null;
    TextView miTxt;

    public miButton(Context context) {
        super(context);
        ctx=context;
        this.setOnClickListener(this); //pedir recoger los eventos
    }


    //cuando se cree desde un recurso XML
    public miButton(Context context, AttributeSet attr){
        super(context,attr);
        ctx=context;
        this.setOnClickListener(this);
    }

    //cuando se cree desde un recurso XML
    public miButton(Context context, AttributeSet attr, int defaultStyles){

        super(context, attr, defaultStyles);
        ctx=context;
        this.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        miTxt = (TextView)((botonesNormales)ctx).findViewById(R.id.mitxt);
        miTxt.setText("Has pulsado un botón");
        Toast.makeText(ctx, "Pulsado mi botón", Toast.LENGTH_SHORT).show();
    }

}