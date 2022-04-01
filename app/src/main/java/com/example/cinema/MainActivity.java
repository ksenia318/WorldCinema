package com.example.cinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.window.SplashScreen;

public class MainActivity extends AppCompatActivity {
 private final int SPLASH_DISPLEY_LEHGHT=5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent mainIntent = new Intent(MainActivity.this, SignInScreen.class);
                MainActivity.this.startActivity(mainIntent);
                MainActivity.this.finish();
            }

        }, SPLASH_DISPLEY_LEHGHT);
    }
//    @Override
//    public void onBackPresserd(){
//        super.onBackPressed();
//    }
}