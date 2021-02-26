package com.richieoscar.miwok.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.richieoscar.miwok.R;

public class SplashActivity extends AppCompatActivity {

    private static final int DELAY_MILLIS = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

       new Handler().postDelayed(()->{
           Intent intent = new Intent(SplashActivity.this, MainActivity.class);
           startActivity(intent);
           finish();
       }, DELAY_MILLIS);
    }
}