package com.example.ferviu.holamundo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class holaMundo3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hola_mundo3);

        final EditText miTexto= findViewById(R.id.miTxt);
        final Button miBoton= findViewById(R.id.miBtn);
        final TextView elSaludo= findViewById(R.id.miLbl);


        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aux = "Te saludo " +  miTexto.getText();
                elSaludo.setText(aux);

                Intent mio=new Intent(holaMundo3.this,Pantalla2.class);
                Bundle miBundle = new Bundle();
                miBundle.putString("paso", aux);
                mio.putExtras(miBundle);
                startActivity(mio);


            }
        });
    }
}
