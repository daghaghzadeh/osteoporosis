package com.phoenix.osteoporosis.activities.diagnosisActivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.phoenix.osteoporosis.R;

/**
 * Created by phoenix on 12/12/2014.
 */
public class Diag24 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diag24);
    }

    public void onClick(View view) {

        int id = view.getId();
        Intent intent = null;

        switch (id) {
            case R.id.diag_yes:
                intent = new Intent(this, Diag26.class);
                startActivity(intent);
                break;
            case R.id.diag_no:
                intent = new Intent(this, DiagInformation.class);
                startActivity(intent);
                break;
            case R.id.diag_info:
                intent = new Intent(this, DiagInformation.class);
                intent.putExtra("page", 25);
                startActivity(intent);
                break;
            case R.id.diag_header_back:
                onBackPressed();
                break;

        }

    }
}