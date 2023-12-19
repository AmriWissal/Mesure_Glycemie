package com.example.mesure_glycmie.Vue;

import android.app.Activity;
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

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mesure_glycmie.R;

import com.example.mesure_glycmie.Controller.Controller;

public class MainActivity extends AppCompatActivity
    {
        private static final int CODE = 1;
        private EditText etValeur;
        private Button bConsulter;
        private TextView tvAge;
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
                        String Reponse= controller.getResult();

                        Intent intent = new Intent(MainActivity.this, ConsultActivity.class);
                        intent.putExtra("reponse", Reponse);
                        startActivityForResult(intent,CODE);
                    }
                }
            }
            );
        }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
            MainActivity.super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == CODE) {
                if (resultCode == Activity.RESULT_CANCELED) {
                    // Afficher un <link>Toast</link> d'erreur
                    Toast.makeText(MainActivity.this, "Opération annulée", Toast.LENGTH_SHORT).show();
                }
            }
        }
        private void init()
        {
            etValeur=(EditText) findViewById(R.id.vm);
            sbAge=(SeekBar) findViewById(R.id.sbAge);
            tvAge=(TextView) findViewById(R.id.votreAge);
            rbOui=(RadioButton) findViewById(R.id.rbtOui);
            rbNon=(RadioButton) findViewById(R.id.rbtNon);
            bConsulter=(Button) findViewById(R.id.btn);
        }


    }
