package com.example.ferviu.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView otroSaludo= (TextView)findViewById(R.id.miMensaje);
        final ImageButton imgBtn = (ImageButton) findViewById(R.id.miBtn);

        Bundle miBundleRecoger = getIntent().getExtras();
        otroSaludo.setText(miBundleRecoger.getString("TEXTO"));


        imgBtn.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent mio=new Intent(Pantalla2.this, MainActivity.class);
                startActivity(mio);

            }
        });
    }
}
