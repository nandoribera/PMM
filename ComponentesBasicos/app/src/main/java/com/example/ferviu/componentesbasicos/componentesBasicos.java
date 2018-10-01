package com.example.ferviu.componentesbasicos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class componentesBasicos extends AppCompatActivity {

        CheckBox chkBoxCycling;
        CheckBox chkBoxTeaching;
        CheckBox chkBoxBlogging;
        Button btnHobby;
        TextView txtHobby;
        String strMessage = "";


        protected void onCreate(Bundle savedInstanceState){
            // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_componentes_basicos);

            chkBoxCycling = (CheckBox) findViewById(R.id.chkBoxCycling);
            chkBoxTeaching = (CheckBox) findViewById(R.id.chkBoxTeaching);
            chkBoxBlogging = (CheckBox) findViewById(R.id.chkBoxBlogging);
            txtHobby = (TextView) findViewById(R.id.txtHobby);

            chkBoxCycling.setOnCheckedChangeListener(new Mia());
            chkBoxTeaching.setOnCheckedChangeListener(new Mia());
            chkBoxBlogging.setOnCheckedChangeListener(new Mia());
        }

            class Mia implements CompoundButton.OnCheckedChangeListener {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    strMessage = "";


                        if(chkBoxCycling.isChecked()){
                            strMessage += "Cycling ";
                        }

                        if(chkBoxTeaching.isChecked()){
                            strMessage += "Teaching ";
                        }

                        if(chkBoxBlogging.isChecked()){
                            strMessage += "Blogging ";
                        }

                    txtHobby.setText(strMessage);

                }
            }
        }