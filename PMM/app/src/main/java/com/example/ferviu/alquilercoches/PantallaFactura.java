package com.example.ferviu.alquilercoches;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DigitalClock;
import android.widget.ImageView;
import android.widget.TextView;

public class PantallaFactura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_factura);

        //declarar el intent y recoger datos
        final Intent intent = getIntent();
        intent.getExtras();

        Coche objectCoche = (Coche) intent.getSerializableExtra("Object");

        ImageView imagen = findViewById(R.id.imagen);
        TextView modelo = findViewById(R.id.modelo);
        TextView precio = findViewById(R.id.precio);
        TextView extras = findViewById(R.id.extras);
        TextView tiempo = findViewById(R.id.tiempo);
        TextView seguro = findViewById(R.id.seguro);
        TextView costeTotal = findViewById(R.id.costeTotal);
        final CheckBox hora = findViewById(R.id.hora);
        final DigitalClock clock = findViewById(R.id.digi);

        imagen.setBackground(getDrawable(objectCoche.getImagen()));
        modelo.setText(objectCoche.getModelo());
        precio.setText(String.valueOf(objectCoche.getPrecio() + "€"));

        extras.setText(String.valueOf(getIntent().getIntExtra("extras", 0)) + "€");
        tiempo.setText(String.valueOf(getIntent().getIntExtra("tiempo", 0))+ " h");
        seguro.setText(getIntent().getStringExtra("seguro"));
        costeTotal.setText(String.valueOf(getIntent().getIntExtra("costeTotal", 0)) + "€");

        hora.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (hora.isChecked()) {
                    clock.setVisibility(View.VISIBLE);

                    //Pasar Hora TODO
                    Intent intentClock = new Intent(PantallaFactura.this, AlquilerCoches.class);
                    Bundle bundleClock = new Bundle();
                    bundleClock.putString("clock", clock.getText().toString());
                    intentClock.putExtras(bundleClock);

                    //Cerrar Pantalla factura
                   //android.os.Process.killProcess(android.os.Process.myPid());
                }
                else
                    clock.setVisibility(View.INVISIBLE);
            }
        });
    }
}
