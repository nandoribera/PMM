package com.example.ferviu.alquilercoches;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Desarrollador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desarrollador);

        TextView nombre = findViewById(R.id.nombre);

        registerForContextMenu(nombre);
    }

    public void onCreateContextMenu(ContextMenu menu_ctx, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu_ctx, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ctx, menu_ctx);

        }

    public boolean onContextItemSelected(MenuItem itemMenu){
        switch (itemMenu.getItemId()) {
            case R.id.opcion1:
                TextView lblMensaje = findViewById(R.id.nombre);
                lblMensaje.setText("Programador\nLugar de nacimiento: Castellón\nDomicilio: Valencia\nTelefono: 666666666");
                return true;
        }
        return true;
    }
}
