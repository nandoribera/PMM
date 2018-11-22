package com.example.ferviu.solobici;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SoloBici extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solo_bici);

        Button jugar = findViewById(R.id.jugar);
        Button configurar = findViewById(R.id.configurar);
        Button acerca_de = findViewById(R.id.acerca_de);
        Button salir = findViewById(R.id.salir);

        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jugar();
            }
        });
    }

    public void jugar(){
        Intent intentJugar = new Intent(SoloBici.this, PantallaJugar.class);

        startActivity(intentJugar);
    }
}
