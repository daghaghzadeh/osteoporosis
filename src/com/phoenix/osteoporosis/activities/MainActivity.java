package com.phoenix.osteoporosis.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.phoenix.osteoporosis.R;
import com.phoenix.osteoporosis.activities.diagnosisActivities.Diag1;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        Animation fade_in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);

        set_fonts();

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

        int id = view.getId();
        Intent intent = null;
        switch (id) {
            case R.id.main_alaem:
                intent = new Intent(view.getContext(), AlaemActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_to_right, R.anim.slide_out_to_right);
                break;
            case R.id.main_avarez:
                intent = new Intent(view.getContext(), ArticleActivity.class);
                intent.putExtra("id", 9);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_to_right, R.anim.slide_out_to_right);
                break;
            case R.id.main_azmaiesh:
                intent = new Intent(view.getContext(), FakeActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_to_right, R.anim.slide_out_to_right);
                break;
            case R.id.main_dalaiel:
                intent = new Intent(view.getContext(), DalaielActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_to_right, R.anim.slide_out_to_right);
                break;
            case R.id.main_moshavere:
                intent = new Intent(view.getContext(), ConsultationActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_to_right, R.anim.slide_out_to_right);
                break;
            case R.id.main_pishgiri:
                intent = new Intent(view.getContext(), PishgiriActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_to_right, R.anim.slide_out_to_right);
                break;
            case R.id.main_ravesh_darman:
                intent = new Intent(view.getContext(), DarmanActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_to_right, R.anim.slide_out_to_right);
                break;
            case R.id.main_test:
                intent = new Intent(view.getContext(), Diag1.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_to_right, R.anim.slide_out_to_right);
                break;
        }


    }


    public void set_fonts() {
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Yekan.ttf");

        ((TextView) findViewById(R.id.main_title1)).setTypeface(face);
        ((TextView) findViewById(R.id.main_title2)).setTypeface(face);
        ((TextView) findViewById(R.id.main_title3)).setTypeface(face);
        ((TextView) findViewById(R.id.main_title4)).setTypeface(face);
        ((TextView) findViewById(R.id.main_title5)).setTypeface(face);
        ((TextView) findViewById(R.id.main_title6)).setTypeface(face);
        ((TextView) findViewById(R.id.main_title7)).setTypeface(face);
        ((TextView) findViewById(R.id.main_title8)).setTypeface(face);
        ((TextView) findViewById(R.id.main_title9)).setTypeface(face);
    }

}