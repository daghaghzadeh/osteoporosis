package com.phoenix.osteoporosis.activities.diagnosisActivities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.phoenix.osteoporosis.R;

/**
 * Created by phoenix on 12/12/2014.
 */
public class Diag70 extends Activity {
    int score = 0;
    int score1 = 0;
    int score2 = 0;
    int score3 = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diag70);

        RadioGroup score1_group = (RadioGroup) findViewById(R.id.diag70_score1);
        RadioGroup score2_group = (RadioGroup) findViewById(R.id.diag70_score2);
        RadioGroup score3_group = (RadioGroup) findViewById(R.id.diag70_score3);

        score1_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag70_score1_1) {
                    score1 = 3;
                }
                if (i == R.id.diag70_score1_2) {
                    score1 = 2;
                }
                if (i == R.id.diag70_score1_3) {
                    score1 = 1;
                }
                if (i == R.id.diag70_score1_4) {
                    score1 = 0;
                }
                update_scoreBoard();
            }
        });
        score2_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag70_score2_1) {
                    score2 = 3;
                }
                if (i == R.id.diag70_score2_2) {
                    score2 = 2;
                }
                if (i == R.id.diag70_score2_3) {
                    score2 = 1;
                }
                if (i == R.id.diag70_score2_4) {
                    score2 = 0;
                }
                update_scoreBoard();
            }
        });
        score3_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag70_score3_1) {
                    score3 = 3;
                }
                if (i == R.id.diag70_score3_2) {
                    score3 = 2;
                }
                if (i == R.id.diag70_score3_3) {
                    score3 = 1;
                }
                if (i == R.id.diag70_score3_4) {
                    score3 = 0;
                }

                update_scoreBoard();
            }
        });

    }

    public void update_scoreBoard() {
        score = score1 + score2 + score3;

        TextView sum_tv = (TextView) findViewById(R.id.diag70_sum);
        TextView res_tv = (TextView) findViewById(R.id.diag70_result);
        sum_tv.setText("جمع: " + score + "امتیاز");

        if (score < 4) {
            int color = getResources().getColor(R.color.difer_tile_back);
            res_tv.setBackgroundColor(color);
        } else {
            int color = getResources().getColor(R.color.background);
            res_tv.setBackgroundColor(color);
        }
    }
}