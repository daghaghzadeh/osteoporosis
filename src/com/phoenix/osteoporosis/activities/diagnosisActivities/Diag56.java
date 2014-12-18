package com.phoenix.osteoporosis.activities.diagnosisActivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.phoenix.osteoporosis.R;

/**
 * Created by phoenix on 12/12/2014.
 */
public class Diag56 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diag56);
    }

    public void onClick(View view) {

        int id = view.getId();
        Intent intent = null;

        switch (id) {
            case R.id.diag_l3:
                intent = new Intent(this, DiagInformation.class);
                intent.putExtra("page", 69);

                startActivity(intent);
                break;
            case R.id.diag_l4:
                intent = new Intent(this, Diag70.class);


                startActivity(intent);
                break;
            case R.id.diag_l1:
                intent = new Intent(this, Diag57.class);

                startActivity(intent);
                break;
            case R.id.diag_l2:
                intent = new Intent(this, Diag62.class);

                startActivity(intent);
                break;
            case R.id.diag_header_back:
                onBackPressed();
                break;
        }
    }
}