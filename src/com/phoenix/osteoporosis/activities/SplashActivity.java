package com.phoenix.osteoporosis.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.phoenix.osteoporosis.R;

/**
 * Created by phoenix on 18/11/2014.
 */
public class SplashActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        start();


    }

    public void start(){
        Intent intent  = new Intent(this,MainActivity.class);

        startActivity(intent);

    }

}