package com.example.ferviu.alquilercoches;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.annotation.Target;
import java.util.ArrayList;

public class AlquilerCoches extends AppCompatActivity {
    public Coche[] datos = new Coche[] {
            new Coche("X-11","Ferrari",100,R.drawable.ferrari1),
            new Coche("Fiesta","Ford",20, R.drawable.fiesta1),
            new Coche("Leon","Seat",40, R.drawable.leon1)
    };

    public int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alquiler_coches);

        //declarar Adaptador, this, esta actividad
        AdaptadorCoches miAdaptador = new AdaptadorCoches(this);

        //crear spinner
        final Spinner spinnerCoches = (findViewById(R.id.spinner));
        ImageView imagen = findViewById(R.id.coche);

        //asignar adaptador al spinner y primera selección
        spinnerCoches.setAdapter(miAdaptador);
        spinnerCoches.setSelection(-1);

        //configurar spinner para mostrar las selecciones
        spinnerCoches.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                index = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //crear radiobuttons
        final RadioButton sinSeguro = (RadioButton)
                findViewById(R.id.sinSeguro);

        final RadioButton seguroTodoRiesgo = (RadioButton)
                findViewById(R.id.conSeguro);

        //crear checkbox
        final CheckBox aireAcondicionado = findViewById(R.id.aire);
        final CheckBox gps = findViewById(R.id.gps);
        final CheckBox radioDvd = findViewById(R.id.radioDvd);

        //calculo de horas
        final EditText nHoras = findViewById(R.id.nHoras);

        Button btnprecio = findViewById(R.id.btnPrecio);
        final TextView resPrecio = findViewById(R.id.resPrecio);

        //crear bundle(para pasar datos a otra actividad)
        final Intent intent = new Intent(AlquilerCoches.this, PantallaFactura.class);
        final Bundle bundle = new Bundle();

        btnprecio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nHoras.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(getApplicationContext(), "Debes introducir número de horas", Toast.LENGTH_SHORT).show();
                } else {

                    int horas = Integer.valueOf(nHoras.getText().toString());
                    bundle.putInt("tiempo", horas);

                    int costeTotal = datos[index].getPrecio() * horas;
                    int extras = 0;

                    if (seguroTodoRiesgo.isChecked()) {
                        costeTotal = costeTotal + ((costeTotal * 20) / 100);
                        bundle.putString("seguro", "Con seguro");
                    } else{
                        bundle.putString("seguro", "Sin seguro");
                    }
                    if (aireAcondicionado.isChecked()) {
                        costeTotal += 50;
                        extras += 1;
                    }
                    if (gps.isChecked()) {
                        costeTotal += 50;
                        extras += 1;
                    }
                    if (radioDvd.isChecked()) {
                        costeTotal += 50;
                        extras += 1;
                    }

                    bundle.putInt("extras", extras * 50);

                    resPrecio.setText(String.valueOf(costeTotal) + "€");
                    bundle.putInt("costeTotal", costeTotal);

                }
            }
        });

        //boton factura
        Button btnFact = (findViewById(R.id.btnFact));

        btnFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bundle.putSerializable("Object", datos[index]);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

        Intent intentClock = getIntent();
        intentClock.getExtras();
    }

    //Crear menu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
         switch(item.getItemId()) {
            case R.id.menuop1:
                Toast.makeText(getApplicationContext(), "Imagen", Toast.LENGTH_SHORT).show();
                Intent intentImagen = new Intent(this, Logo.class);
                startActivity(intentImagen);
                return true;

            case R.id.menuop2:
                Toast.makeText(getApplicationContext(), "Acerca de", Toast.LENGTH_SHORT).show();
                Intent intentDes = new Intent(this, Desarrollador.class);
                startActivity(intentDes);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    //adaptador
    class AdaptadorCoches extends ArrayAdapter{
        Activity context;
        AdaptadorCoches(Activity context){
            super(context, R.layout.lista_coches, datos);
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
            View item = inflater.inflate(R.layout.lista_coches, null);

            TextView modelo = item.findViewById(R.id.modelo);
            TextView marca = item.findViewById(R.id.marca);
            TextView precio = item.findViewById(R.id.precio);
            ImageView imagen = item.findViewById(R.id.imagen);

            modelo.setText(datos[position].getModelo());
            marca.setText(datos[position].getMarca());
            precio.setText(String.valueOf(datos[position].getPrecio() + "€"));
            imagen.setBackground(getDrawable(datos[position].getImagen()));
            return item;
        }
    }
}
