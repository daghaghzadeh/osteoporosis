package com.phoenix.osteoporosis.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.phoenix.osteoporosis.R;

/**
 * Created by phoenix on 18/11/2014.
 */
public class MainActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        Animation fade_in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);

        fade_in.setDuration(3000);

//
//        findViewById(R.id.main_alaem).startAnimation(fade_in);
//
//        findViewById(R.id.main_avarez).startAnimation(fade_in);
//
//        findViewById(R.id.main_darman).startAnimation(fade_in);
//
//        findViewById(R.id.main_maghalat).startAnimation(fade_in);
//
//        findViewById(R.id.main_moshavere).startAnimation(fade_in);
//
//        findViewById(R.id.main_test).startAnimation(fade_in);
//
//        findViewById(R.id.main_pezeshk).startAnimation(fade_in);
//
//        findViewById(R.id.main_ravesh).startAnimation(fade_in);
//
//        findViewById(R.id.main_pishgiri).startAnimation(fade_in);
//
//        findViewById(R.id.main_layout_footer).startAnimation(fade_in);


    }

    public void onClick(View view) {

        Intent intent = new Intent(this, FakeActivity.class);
        startActivity(intent);

    }
}