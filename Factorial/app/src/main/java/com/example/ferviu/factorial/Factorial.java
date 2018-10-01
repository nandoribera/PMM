package com.example.ferviu.factorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Factorial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);
        final EditText miNum= (EditText)findViewById(R.id.miTxt);
        final Button miBoton= (Button)findViewById(R.id.miBtn);
        final TextView text= (TextView)findViewById(R.id.miTv);

        miBoton.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v) {
                int num = Integer.parseInt(miNum.getText().toString());
                miNum.setText("");

                int aux = num;

                for (int i = 1; i < num; i++){
                    aux = aux*i;

                }

                miNum.setText(""+aux);

                Intent mio=new Intent(Factorial.this,Pantalla2.class);
                Bundle miBundle = new Bundle();
                miBundle.putString("TEXTO", String.valueOf(miNum.getText()));
                mio.putExtras(miBundle);
                startActivity(mio);
            }


        });


    }
}
