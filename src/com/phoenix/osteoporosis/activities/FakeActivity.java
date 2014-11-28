package com.phoenix.osteoporosis.activities;

import android.app.Activity;
import android.os.Bundle;
import com.phoenix.osteoporosis.R;

/**
 * Created by phoenix on 18/11/2014.
 */
public class FakeActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fake_layout);
    }
}