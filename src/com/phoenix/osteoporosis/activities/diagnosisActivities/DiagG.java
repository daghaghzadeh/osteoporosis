package com.phoenix.osteoporosis.activities.diagnosisActivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.phoenix.osteoporosis.R;

/**
 * Created by phoenix on 12/12/2014.
 */
public class DiagG extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diagg);
    }

    public void onClick(View view) {

        int id = view.getId();
        Intent intent = null;

        switch (id) {
            case R.id.diag_yes:
                intent = new Intent(this, Diag31.class);
                startActivity(intent);
                break;
            case R.id.diag_no:
                intent = new Intent(this, DiagInformation.class);
                intent.putExtra("page", 44);
                startActivity(intent);
                break;
            case R.id.diag_header_back:
                onBackPressed();
                break;
            case R.id.diag_info:
                intent = new Intent(this,DiagInformation.class);
                intent.putExtra("page",43);
                startActivity(intent);
                break;

        }

    }
}