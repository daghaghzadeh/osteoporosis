package com.phoenix.osteoporosis.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
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
//        test();
        finish();


    }

    public void start() {
        Intent intent = new Intent(this, MainActivity.class);


        startActivity(intent);

    }

    public void test() {
        try {
            String sourceDir = getPackageManager().getPackageInfo(getPackageName(), 0).applicationInfo.sourceDir;
            Log.d("SplashActivity", sourceDir);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }

}