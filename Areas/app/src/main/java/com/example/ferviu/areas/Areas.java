package com.example.ferviu.areas;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Areas extends AppCompatActivity {

    private Figura[] figuras = new Figura[]{
            new Figura("Circulo",R.drawable.circulo),
            new Figura("Triangulo",R.drawable.triangulo)
    };

    public int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas);



        Spinner spinnerFiguras = findViewById(R.id.spinner);
        AdaptadorFigura miAdaptador = new AdaptadorFigura(this);
        spinnerFiguras.setAdapter(miAdaptador);
        spinnerFiguras.setSelection(-1);



        spinnerFiguras.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String mensaje = "";
                mensaje = "Item clicked => " + figuras[position];
                index = position;

                showToast(mensaje);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final Intent intent = new Intent(this, Pantalla2.class);
        final Bundle bundle = new Bundle();

        Button pasar = (findViewById(R.id.btnPasar));

        pasar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bundle.putSerializable("Object",figuras[index]);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }

    public void showToast(String Text){
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }

    //adaptador
    class AdaptadorFigura extends ArrayAdapter {
        Activity context;
        AdaptadorFigura(Activity context){
            super(context, R.layout.lista_figuras, figuras);
            this.context = context;
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            View view = getView(position, convertView, parent);
            return view;
        }

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public View getView(int position, View converView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.lista_figuras, null);

            TextView nombre = item.findViewById(R.id.nombre);
            ImageView imagen = item.findViewById(R.id.imagen);

            nombre.setText(figuras[position].getNombre());
            imagen.setBackground(getDrawable(figuras[position].getImagen()));
            return item;
        }
    }

}
