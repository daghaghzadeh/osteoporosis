package com.phoenix.osteoporosis.listeners;

import android.content.Intent;
import android.view.View;
import com.phoenix.osteoporosis.activities.FakeActivity;

/**
 * Created by phoenix on 18/11/2014.
 */
public class MainListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        int id = view.getId();

        Intent intent = new Intent(view.getContext(), FakeActivity.class);
        view.getContext().startActivity(intent);


    }
}
