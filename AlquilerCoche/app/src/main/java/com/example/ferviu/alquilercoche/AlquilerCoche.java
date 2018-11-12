package com.example.ferviu.alquilercoche;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AlquilerCoche extends AppCompatActivity {
    int index = 0;
    private Coche[] datos = new Coche[]{
            new Coche("X-11","Ferrari",100,R.drawable.ferrari1),
            new Coche("Fiesta","Ford",20,R.drawable.fiesta1),
            new Coche("Megane","Renault",50,R.drawable.megan1)

    };

        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_alquiler_coche);

            AdaptadorCoche adaptador = new AdaptadorCoche(this);
            Spinner spinnerCoche = (Spinner) findViewById(R.id.spinnerCoche);

            spinnerCoche.setAdapter(adaptador);


            spinnerCoche.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                    index = pos;
                }
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });

        }

    class AdaptadorCoche extends ArrayAdapter{
        Activity context;
        AdaptadorCoche(Activity context){
            super(context, R.layout.listcoche, datos);
            this.context = context;
        }
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View vista = getView(position, convertView, parent);
            return vista;
        }
        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)

        public View getView(int position, View convertiView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listcoche, null);

            TextView nombre = (TextView) item.findViewById(R.id.nombre);
            TextView marca = (TextView) item.findViewById(R.id.marca);
            TextView precio = (TextView) item.findViewById(R.id.precio);
            ImageView image = (ImageView) item.findViewById(R.id.image);

            nombre.setText(datos[position].getNombre());
            nombre.setText(datos[position].getMarca());
            precio.setText(String.valueOf(datos[position].getPrecio()));
            image.setBackground(getDrawable(datos[position].getImage()));

            return item;
        }
    }
}
