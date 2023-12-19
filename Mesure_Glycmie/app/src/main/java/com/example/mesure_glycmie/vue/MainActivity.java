package com.example.mesure_glycmie.vue;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mesure_glycmie.R;

import com.example.mesure_glycmie.controller.Controller ;

public class MainActivity extends AppCompatActivity
    {
        private EditText etValeur;
        private Button bConsulter;
        private TextView tvAge,tvRésultat;
        private RadioButton rbOui,rbNon;
        private SeekBar sbAge;
        private Controller controller=new Controller();
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            init();
            //listener SeekBar
            sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
            {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b)
                {
                    Log.i("Information", "onProgressChanged " + i);
                    tvAge.setText("Votre âge : "+ i);
                }
                @Override
                public void onStartTrackingTouch(SeekBar seekBar)
                {

                }
                @Override
                public void onStopTrackingTouch(SeekBar seekBar)
                {

                }
            });
            bConsulter.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    int age;
                    float valeurMesurer;
                    boolean verifAge=false,verifValeur=false;
                    if(sbAge.getProgress()!=0)
                        verifAge=true;
                    else
                        Toast.makeText(MainActivity.this, "Veillez verifier votre age", Toast.LENGTH_SHORT).show();
                    if(!etValeur.getText().toString().isEmpty())
                        verifValeur=true;
                    else
                        Toast.makeText(MainActivity.this, "veillez verifier la valeur mesurer", Toast.LENGTH_LONG).show();
                    if (verifAge && verifValeur)
                    {
                        age = sbAge.getProgress();
                        valeurMesurer = Float.valueOf(etValeur.getText().toString());
                        boolean fasting = rbOui.isChecked();
                        //userAction:view---->Controller
                        controller.createPatient(age,valeurMesurer,fasting);
                        //Update Controller----->View
                        tvRésultat.setText(controller.getResult());

                    }
                }
            }
            );
        }
        private void init()
        {
            etValeur=(EditText) findViewById(R.id.vm);
            sbAge=(SeekBar) findViewById(R.id.sbAge);
            tvAge=(TextView) findViewById(R.id.votreAge);
            rbOui=(RadioButton) findViewById(R.id.rbtOui);
            rbNon=(RadioButton) findViewById(R.id.rbtNon);
            tvRésultat=(TextView) findViewById(R.id.res);
            bConsulter=(Button) findViewById(R.id.btn);
        }


    }
