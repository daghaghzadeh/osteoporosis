package com.phoenix.osteoporosis.activities.diagnosisActivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.phoenix.osteoporosis.R;

/**
 * Created by phoenix on 12/12/2014.
 */
public class Diag26 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diag26);
    }

    public void onClick(View view) {

        int id = view.getId();
        Intent intent = null;

        switch (id) {
            case R.id.diag_i1:
                intent = new Intent(this, DiagInformation.class);
                intent.putExtra("page", 5);

                startActivity(intent);
                break;
            case R.id.diag_i2:
                intent = new Intent(this, DiagInformation.class);
                intent.putExtra("page", 5);

                startActivity(intent);
                break;
            case R.id.diag_l1:
                intent = new Intent(this, DiagInformation.class);
                intent.putExtra("page", 27);
                startActivity(intent);
                break;
            case R.id.diag_l2:
                intent = new Intent(this, DiagInformation.class);
                intent.putExtra("page", 28);
                startActivity(intent);
                break;
            case R.id.diag_header_back:
                onBackPressed();
                break;
        }
    }
}