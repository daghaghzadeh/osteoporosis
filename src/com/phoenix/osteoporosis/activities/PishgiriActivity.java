package com.phoenix.osteoporosis.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.phoenix.osteoporosis.R;

/**
 * Created by phoenix on 27/11/2014.
 */
public class PishgiriActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pishgiri_layout);
    }


    public void onClick(View view) {
        Intent intent = new Intent(this, ArticleActivity.class);
        int id = view.getId();

        switch (id) {

            case R.id.pishgiri_adat:
                intent.putExtra("id", 53);
                break;
            case R.id.pishgiri_bardari:
                intent.putExtra("id", 54);
                break;
            case R.id.pishgiri_control_daroo:
                intent.putExtra("id", 52);
                break;
            case R.id.pishgiri_rezhim:
                intent.putExtra("id", 41);
                break;
            case R.id.pishgiri_varzesh:
                intent.putExtra("id", 61);
                break;
            case R.id.pishgiri_vazn:
                intent.putExtra("id", 51);
                break;

        }

        startActivity(intent);
    }
}