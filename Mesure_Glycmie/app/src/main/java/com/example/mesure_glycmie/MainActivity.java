package com.example.mesure_glycmie;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etValeur;
    private Button bConsulter;
    private TextView tvAge, tvRésultat;
    private RadioButton rbOui, rbNon;
    private SeekBar sbAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //listener SeekBar
        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("Information", "onProgressChanged " + i);
                tvAge.setText("Votre âge : " + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        bConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calculer(view);
            }
        });
    }

    private void init() {
        etValeur = (EditText) findViewById(R.id.vm);
        sbAge = (SeekBar) findViewById(R.id.sbAge);
        tvAge = (TextView) findViewById(R.id.votreAge);
        rbOui = (RadioButton) findViewById(R.id.rbtOui);
        rbNon = (RadioButton) findViewById(R.id.rbtNon);
        tvRésultat = (TextView) findViewById(R.id.res);
        bConsulter = (Button) findViewById(R.id.btn);
    }

    public void Calculer(View v) {
        int age;
        float valeurMesurer;
        boolean verifAge = false, verifValeur = false;
        if (sbAge.getProgress() != 0)
            verifAge = true;
        else
            Toast.makeText(MainActivity.this, "Veillez verifier votre age", Toast.LENGTH_SHORT).show();
        if (!etValeur.getText().toString().isEmpty())
            verifValeur = true;
        else
            Toast.makeText(MainActivity.this, "veillez verifier la valeur mesurer", Toast.LENGTH_LONG).show();
        if (verifAge && verifValeur) {
            age = sbAge.getProgress();
            valeurMesurer = Float.valueOf(etValeur.getText().toString());
            boolean fastiing = rbOui.isChecked();
            if (fastiing) {
                if (age >= 13) {
                    if (valeurMesurer < 5)
                        tvRésultat.setText("niveau de glycémie est bas");
                    else if (valeurMesurer >= 5 && valeurMesurer <= 7.2)
                        tvRésultat.setText("niveau de glycémie est normale");
                    else
                        tvRésultat.setText("niveau de glycémie est élevé");
                } else if (age >= 6 && age <= 12) {
                    if (valeurMesurer < 5)
                        tvRésultat.setText("niveau de glycémie est bas");
                    else if (valeurMesurer >= 5 && valeurMesurer <= 10)
                        tvRésultat.setText("niveau de glycémie est normale");
                    else
                        tvRésultat.setText("niveau de glycémie est élevé");
                } else if (age < 6) {
                    if (valeurMesurer < 5.5)
                        tvRésultat.setText("niveau de glycémie est bas");
                    else if (valeurMesurer >= 5.5 && valeurMesurer <= 10)
                        tvRésultat.setText("niveau de glycémie est normale");
                    else
                        tvRésultat.setText("niveau de glycémie est élevé");
                }
            } else {
                if (valeurMesurer > 10.5)
                    tvRésultat.setText("niveau de glycémie est élevé");
                else
                    tvRésultat.setText("niveau de glycémie est normale");
            }
        }
    }
}