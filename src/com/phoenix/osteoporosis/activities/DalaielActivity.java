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
public class DalaielActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dalaiel_layout);
        set_fonts();
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, ArticleActivity.class);
        int id = view.getId();

        switch (id) {

            case R.id.dalaiel_alkol:
                intent.putExtra("id", 26);
                break;
            case R.id.dalaiel_bimariha:
                intent.putExtra("id", 27);
                break;
            case R.id.dalaiel_darooha:
                intent.putExtra("id",33);
                break;
            case R.id.dalaiel_dokhaniat:
                intent.putExtra("id", 7);
                break;
            case R.id.dalaiel_ghabel:
                intent.putExtra("id", 18);
                break;
            case R.id.dalaiel_gheirghabel:
                intent.putExtra("id", 11);
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