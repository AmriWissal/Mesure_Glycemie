package com.example.mesure_glycmie.controller;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mesure_glycmie.model.User ;


public class LoginController {

    private static final String SHERED_PREFS = "sharedPrefs";
        private static User user;
        private static LoginController instance = null;
        private LoginController()
        {
            super();
        }
        public static final LoginController getInstance(Context context)
        {
            if(LoginController.instance==null)
                LoginController.instance=new LoginController();
            recapUser(context);
            return LoginController.instance;
        }
        private static void recapUser(Context context)
        {
            SharedPreferences sharedPreferences = context.getSharedPreferences(SHERED_PREFS,Context.MODE_PRIVATE);
            String userName = sharedPreferences.getString("userName","");
            String password = sharedPreferences.getString("password","");
            user = new User(userName,password);
        }
        public void createUser(String userName, String password, Context context)
        {
            //creation de l'utilisateur
            user = new User(userName,password);
            //persistance des données de l'utilisateur
            SharedPreferences sharedPreferences = context.getSharedPreferences(SHERED_PREFS,Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("userName",userName);
            editor.putString("password",password);
            editor.apply();
        }
        public String getUserName()
        {
            return user.getUserName();
        }
        public String getPassword()
        {
            return user.getPassword();
        }
}
