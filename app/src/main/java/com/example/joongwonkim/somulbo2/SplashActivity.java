package com.example.joongwonkim.somulbo2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.joongwonkim.somulbo2.utils.Constants;
import com.example.joongwonkim.somulbo2.utils.Validation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import static com.example.joongwonkim.somulbo2.utils.Validation.validateFields;

public class SplashActivity extends AppCompatActivity  {


    private SharedPreferences mSharedPreferences;

    String mToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        mToken = mSharedPreferences.getString(Constants.TOKEN,"");





        if(!validateFields(mToken)){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();

        } else {
            Intent intents = new Intent(this, StateActivity.class);
            startActivity(intents);
            finish();
        }







    }
}
