package com.phoenix.osteoporosis.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.phoenix.osteoporosis.R;

/**
 * Created by phoenix on 27/11/2014.
 */
public class DarmanActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.darman_layout);
        set_fonts();
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, ArticleActivity.class);
        int id = view.getId();

        switch (id) {

            case R.id.darman_darooie:
                intent.putExtra("id", 56);
                break;
            case R.id.darman_hormoni:
                intent.putExtra("id", 57);
                break;
            case R.id.darman_jaigozin:
                intent.putExtra("id", 58);
                break;
            case R.id.darman_mokamel:
                intent.putExtra("id", 59);
                break;
            case R.id.darman_tosie:
                intent.putExtra("id", 61);
                break;
            case R.id.darman_varzesh:
                intent.putExtra("id", 60);
                break;

        }
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_to_right, R.anim.slide_out_to_right);
    }

    public void set_fonts() {
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Yekan.ttf");

        ((TextView) findViewById(R.id.main_title1)).setTypeface(face);
        ((TextView) findViewById(R.id.main_title2)).setTypeface(face);
        ((TextView) findViewById(R.id.main_title3)).setTypeface(face);
        ((TextView) findViewById(R.id.main_title4)).setTypeface(face);
        ((TextView) findViewById(R.id.main_title5)).setTypeface(face);
        ((TextView) findViewById(R.id.main_title6)).setTypeface(face);
    }

}