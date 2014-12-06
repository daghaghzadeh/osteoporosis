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
public class AlaemActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alaem_layout);
        set_fonts();

    }

    public void onClick(View view) {
        Intent intent = new Intent(this, ArticleActivity.class);
        int id = view.getId();

        switch (id) {

            case R.id.alaem_dard:
                intent.putExtra("id", 3);
                break;
            case R.id.alaem_ghad:
                intent.putExtra("id", 6);
                break;
            case R.id.alaem_khamidegi:
                intent.putExtra("id", 5);
                break;
            case R.id.alaem_osteo:
                intent.putExtra("id", 7);
                break;
            case R.id.alaem_poosidegi:
                intent.putExtra("id", 8);
                break;
            case R.id.alaem_shekastegi:
                intent.putExtra("id", 4);
                break;

        }


        startActivity(intent);

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