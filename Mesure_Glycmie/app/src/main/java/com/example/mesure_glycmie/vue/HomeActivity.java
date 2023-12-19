package com.example.mesure_glycmie.vue;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mesure_glycmie.R;

import com.example.mesure_glycmie.controller.LoginController ;

public class HomeActivity extends AppCompatActivity
    {
        private Button btnConsultation;
        private EditText etUserName;
        private EditText etpassword;
        private LoginController loginController;
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);
            init();
            etUserName.setText(loginController.getUserName());
            etpassword.setText(loginController.getPassword());
            btnConsultation.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    String userName,password;
                    Boolean verifUserName = false,verifPassword = false;
                    if(!etUserName.getText().toString().isEmpty())
                        verifUserName = true;
                    else
                        Toast.makeText(HomeActivity.this, "Veuillez saisir votre nom d'utilisateur", Toast.LENGTH_SHORT).show();
                    if(!etpassword.getText().toString().isEmpty())
                        verifPassword = true;
                    else
                        Toast.makeText(HomeActivity.this, "Veuillez saisir votre mot de passe", Toast.LENGTH_LONG).show();
                    if (verifUserName && verifPassword)
                    {

                        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });
        }
        private void init()
        {
            loginController = LoginController.getInstance(HomeActivity.this);
            btnConsultation = (Button) findViewById(R.id.btnConsultation);
            etpassword = (EditText)findViewById(R.id.etPassword);
            etUserName = (EditText)findViewById(R.id.etUserName);
        }
    }



