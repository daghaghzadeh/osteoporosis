package com.phoenix.osteoporosis.activities.diagnosisActivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.phoenix.osteoporosis.R;

/**
 * Created by phoenix on 12/12/2014.
 */
public class Diag13 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diag13);
    }

    public void onClick(View view) {

        int id = view.getId();
        Intent intent = null;

        switch (id) {
            case R.id.diag_hyper:
                intent = new Intent(this, Diag14.class);
                startActivity(intent);
                break;
            case R.id.diag_hypo:
                intent = new Intent(this, Diag16.class);
                startActivity(intent);
                break;
            case R.id.diag_norm:
                intent = new Intent(this, Diag17.class);
                startActivity(intent);
                break;
            case R.id.diag_header_back:
                onBackPressed();
                break;

        }

    }
}