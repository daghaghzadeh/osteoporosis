package com.phoenix.osteoporosis.activities.diagnosisActivities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.phoenix.osteoporosis.R;

/**
 * Created by phoenix on 12/12/2014.
 */
public class Diag62 extends Activity {
    int score1 = 0;
    int score2 = 0;
    int score3 = 0;
    int score4 = 0;
    int score5 = 0;
    int score6 = 0;
    int score7 = 0;
    int score8 = 0;
    int score9 = 0;
    int score10 = 0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diag62);

        RadioGroup score1_group = (RadioGroup) findViewById(R.id.diag62_score1);
        RadioGroup score2_group = (RadioGroup) findViewById(R.id.diag62_score2);
        RadioGroup score3_group = (RadioGroup) findViewById(R.id.diag62_score3);
        RadioGroup score4_group = (RadioGroup) findViewById(R.id.diag62_score4);
        RadioGroup score5_group = (RadioGroup) findViewById(R.id.diag62_score5);
        RadioGroup score6_group = (RadioGroup) findViewById(R.id.diag62_score6);
        RadioGroup score7_group = (RadioGroup) findViewById(R.id.diag62_score7);
        RadioGroup score8_group = (RadioGroup) findViewById(R.id.diag62_score8);
        RadioGroup score9_group = (RadioGroup) findViewById(R.id.diag62_score9);
        RadioGroup score10_group = (RadioGroup) findViewById(R.id.diag62_score10);

        score1_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag62_score1_1) {
                    score1 = 0;
                }
                if (i == R.id.diag62_score1_2) {
                    score1 = 5;
                }
                if (i == R.id.diag62_score1_3) {
                    score1 = 10;
                }
                update_scoreBoard();
            }
        });
        score2_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag62_score2_1) {
                    score2 = 0;
                }
                if (i == R.id.diag62_score2_2) {
                    score2 = 5;
                }
                update_scoreBoard();
            }
        });
        score3_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag62_score3_1) {
                    score3 = 0;
                }
                if (i == R.id.diag62_score3_2) {
                    score3 = 5;
                }

                update_scoreBoard();
            }
        });
        score4_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag62_score4_1) {
                    score3 = 0;
                }
                if (i == R.id.diag62_score4_2) {
                    score3 = 5;
                }
                if (i == R.id.diag62_score4_3) {
                    score3 = 10;
                }
                update_scoreBoard();
            }
        });

        score5_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag62_score5_1) {
                    score3 = 0;
                }
                if (i == R.id.diag62_score5_2) {
                    score3 = 5;
                }
                if (i == R.id.diag62_score5_3) {
                    score3 = 10;
                }
                update_scoreBoard();
            }
        });

        score6_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag62_score6_1) {
                    score3 = 0;
                }
                if (i == R.id.diag62_score6_2) {
                    score3 = 5;
                }
                if (i == R.id.diag62_score6_3) {
                    score3 = 10;
                }
                if (i == R.id.diag62_score6_4) {
                    score3 = 15;
                }
                update_scoreBoard();
            }
        });

        score7_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag62_score7_1) {
                    score3 = 0;
                }
                if (i == R.id.diag62_score7_2) {
                    score3 = 5;
                }
                if (i == R.id.diag62_score7_3) {
                    score3 = 10;
                }
                if (i == R.id.diag62_score7_4) {
                    score3 = 15;
                }
                update_scoreBoard();
            }
        });

        score8_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag62_score8_1) {
                    score3 = 0;
                }
                if (i == R.id.diag62_score8_2) {
                    score3 = 5;
                }
                if (i == R.id.diag62_score8_3) {
                    score3 = 10;
                }
                update_scoreBoard();
            }
        });

        score9_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag62_score9_1) {
                    score3 = 0;
                }
                if (i == R.id.diag62_score9_2) {
                    score3 = 5;
                }
                if (i == R.id.diag62_score9_3) {
                    score3 = 10;
                }
                update_scoreBoard();
            }
        });

        score10_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag62_score10_1) {
                    score3 = 0;
                }
                if (i == R.id.diag62_score10_2) {
                    score3 = 5;
                }
                if (i == R.id.diag62_score10_3) {
                    score3 = 10;
                }
                update_scoreBoard();
            }
        });
    }

    private void update_scoreBoard() {

        int score = score1 + score2 + score3 + score4 + score5 + score6 + score7 + score8 + score9 + score10;



        TextView sum_tv = (TextView) findViewById(R.id.diag62_sum);
        TextView res_tv = (TextView) findViewById(R.id.diag62_result);
        sum_tv.setText("جمع: " + score + "امتیاز");

        if (score < 41) {
            int color = getResources().getColor(R.color.difer_tile_back);
            res_tv.setBackgroundColor(color);
        } else {
            int color = getResources().getColor(R.color.background);
            res_tv.setBackgroundColor(color);
        }


    }
}