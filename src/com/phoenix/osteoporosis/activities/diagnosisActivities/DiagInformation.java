package com.phoenix.osteoporosis.activities.diagnosisActivities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.phoenix.osteoporosis.R;

/**
 * Created by phoenix on 11/12/2014.
 */
public class DiagInformation extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diag_information);

        TextView title_tv = (TextView) findViewById(R.id.diag_information_title);
        TextView content_tv = (TextView) findViewById(R.id.diag_information_content);

        title_tv.setText(getInfoTitle());
        content_tv.setText(getInfoContent());


    }

    public String getInfoTitle() {
        String title = "";

        int page = getIntent().getIntExtra("page", -1);

        int id = getResources().getIdentifier("com.phoenix.osteoporosis:string/info_title_" + page, null, null);
        title = getResources().getString(id);


        return title;
    }

    public String getInfoContent() {
        String content = "";

        int page = getIntent().getIntExtra("page", -1);

        int id = getResources().getIdentifier("com.phoenix.osteoporosis:string/info_content_" + page, null, null);
        content = getResources().getString(id);

        return content;
    }
}