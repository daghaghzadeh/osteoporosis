package com.phoenix.osteoporosis.activities.diagnosisActivities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.phoenix.osteoporosis.R;

/**
 * Created by phoenix on 12/12/2014.
 */
public class Diag57 extends Activity {
    int score_first1 = 0;
    int score_first2 = 0;
    int score_first3 = 0;
    int score_first4 = 0;
    int score_first5 = 0;
    int score_first6 = 0;
    int score_first7 = 0;
    int score_first8 = 0;
    int score_first9 = 0;
    int score_first10 = 0;
    int score_first11 = 0;
    int score_first12 = 0;
    int score_first13 = 0;
    int score_first14 = 0;
    int score_first15 = 0;
    int score_first16 = 0;
    int score_first17 = 0;
    int score_first18 = 0;
    int score_first19 = 0;
    int score_first20 = 0;

    int score_age = 0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diag57);

        RadioGroup first_group1 = (RadioGroup) findViewById(R.id.diag57_first_group_1);
        RadioGroup first_group2 = (RadioGroup) findViewById(R.id.diag57_first_group_2);
        RadioGroup first_group3 = (RadioGroup) findViewById(R.id.diag57_first_group_3);
        RadioGroup first_group4 = (RadioGroup) findViewById(R.id.diag57_first_group_4);
        RadioGroup first_group5 = (RadioGroup) findViewById(R.id.diag57_first_group_5);
        RadioGroup first_group6 = (RadioGroup) findViewById(R.id.diag57_first_group_6);
        RadioGroup first_group7 = (RadioGroup) findViewById(R.id.diag57_first_group_7);
        RadioGroup first_group8 = (RadioGroup) findViewById(R.id.diag57_first_group_8);
        RadioGroup first_group9 = (RadioGroup) findViewById(R.id.diag57_first_group_9);
        RadioGroup first_group10 = (RadioGroup) findViewById(R.id.diag57_first_group_10);
        RadioGroup first_group11 = (RadioGroup) findViewById(R.id.diag57_first_group_11);
        RadioGroup first_group12 = (RadioGroup) findViewById(R.id.diag57_first_group_12);
        RadioGroup first_group13 = (RadioGroup) findViewById(R.id.diag57_first_group_13);
        RadioGroup first_group14 = (RadioGroup) findViewById(R.id.diag57_first_group_14);
        RadioGroup first_group15 = (RadioGroup) findViewById(R.id.diag57_first_group_15);
        RadioGroup first_group16 = (RadioGroup) findViewById(R.id.diag57_first_group_16);
        RadioGroup first_group17 = (RadioGroup) findViewById(R.id.diag57_first_group_17);
        RadioGroup first_group18 = (RadioGroup) findViewById(R.id.diag57_first_group_18);
        RadioGroup first_group19 = (RadioGroup) findViewById(R.id.diag57_first_group_19);
        RadioGroup first_group20 = (RadioGroup) findViewById(R.id.diag57_first_group_20);
        RadioGroup age_group = (RadioGroup) findViewById(R.id.diag57_second_group);

        first_group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag57_1_y) {
                    score_first1 = 1;
                }
                if (i == R.id.diag57_1_n) {
                    score_first1 = 0;
                }
                update_scoreboard();
            }
        });
        first_group2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag57_2_y) {
                    score_first2 = 1;
                }
                if (i == R.id.diag57_2_n) {
                    score_first2 = 0;
                }
                update_scoreboard();
            }
        });
        first_group3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag57_3_y) {
                    score_first3 = 1;
                }
                if (i == R.id.diag57_3_n) {
                    score_first3 = 0;
                }
                update_scoreboard();
            }
        });
        first_group4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag57_4_y) {
                    score_first4 = 1;
                }
                if (i == R.id.diag57_4_n) {
                    score_first4 = 0;
                }
                update_scoreboard();
            }
        });
        first_group5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag57_5_y) {
                    score_first5 = 1;
                }
                if (i == R.id.diag57_5_n) {
                    score_first5 = 0;
                }
                update_scoreboard();
            }
        });
        first_group6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag57_6_y) {
                    score_first6 = 1;
                }
                if (i == R.id.diag57_6_n) {
                    score_first6 = 0;
                }
                update_scoreboard();
            }
        });
        first_group7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag57_7_y) {
                    score_first7 = 1;
                }
                if (i == R.id.diag57_7_n) {
                    score_first7 = 0;
                }
                update_scoreboard();
            }
        });
        first_group8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag57_8_y) {
                    score_first8 = 1;
                }
                if (i == R.id.diag57_8_n) {
                    score_first8 = 0;
                }
                update_scoreboard();
            }
        });
        first_group9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag57_9_y) {
                    score_first9 = 1;
                }
                if (i == R.id.diag57_9_n) {
                    score_first9 = 0;
                }
                update_scoreboard();
            }
        });
        first_group10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag57_10_y) {
                    score_first10 = 1;
                }
                if (i == R.id.diag57_10_n) {
                    score_first10 = 0;
                }
                update_scoreboard();
            }
        });
        first_group11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag57_11_y) {
                    score_first11 = 1;
                }
                if (i == R.id.diag57_11_n) {
                    score_first11 = 0;
                }
                update_scoreboard();
            }
        });
        first_group12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag57_12_y) {
                    score_first12 = 2;
                }
                if (i == R.id.diag57_12_n) {
                    score_first12 = 0;
                }
                update_scoreboard();
            }
        });
        first_group13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag57_13_y) {
                    score_first13 = 2;
                }
                if (i == R.id.diag57_13_n) {
                    score_first13 = 0;
                }
                update_scoreboard();
            }
        });
        first_group14.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag57_14_y) {
                    score_first14 = 2;
                }
                if (i == R.id.diag57_14_n) {
                    score_first14 = 0;
                }
                update_scoreboard();
            }
        });
        first_group15.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag57_15_y) {
                    score_first15 = 2;
                }
                if (i == R.id.diag57_15_n) {
                    score_first15 = 0;
                }
                update_scoreboard();
            }
        });
        first_group16.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag57_16_y) {
                    score_first16 = 2;
                }
                if (i == R.id.diag57_16_n) {
                    score_first16 = 0;
                }
                update_scoreboard();
            }
        });
        first_group17.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag57_17_y) {
                    score_first17 = 2;
                }
                if (i == R.id.diag57_17_n) {
                    score_first17 = 0;
                }
                update_scoreboard();
            }
        });
        first_group18.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag57_18_y) {
                    score_first18 = 3;
                }
                if (i == R.id.diag57_18_n) {
                    score_first18 = 0;
                }
                update_scoreboard();
            }
        });
        first_group19.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag57_19_y) {
                    score_first19 = 6;
                }
                if (i == R.id.diag57_19_n) {
                    score_first19 = 0;
                }
                update_scoreboard();
            }
        });
        first_group20.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag57_20_y) {
                    score_first20 = 6;
                }
                if (i == R.id.diag57_20_n) {
                    score_first20 = 0;
                }
                update_scoreboard();
            }
        });

        age_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diag57_second_1) {
                    score_age = 1;
                }
                if (i == R.id.diag57_second_2) {
                    score_age = 2;
                }
                if (i == R.id.diag57_second_3) {
                    score_age = 3;
                }
                if (i == R.id.diag57_second_4) {
                    score_age = 4;
                }
                if (i == R.id.diag57_second_5) {
                    score_age = 5;
                }
                update_scoreboard();
            }
        });

    }

    public void update_scoreboard() {

        int score = score_age;
        score += score_first1;
        score += score_first2;
        score += score_first3;
        score += score_first4;
        score += score_first5;
        score += score_first6;
        score += score_first7;
        score += score_first8;
        score += score_first9;
        score += score_first10;
        score += score_first11;
        score += score_first12;
        score += score_first13;
        score += score_first14;
        score += score_first15;
        score += score_first16;
        score += score_first17;
        score += score_first18;
        score += score_first19;
        score += score_first20;

        TextView score_view = (TextView) findViewById(R.id.diag57_score);
        RadioGroup result_view = (RadioGroup) findViewById(R.id.diag57_result);

        score_view.setText("شاخص = " + score);

        if (score == 0) {
            result_view.check(R.id.diag57_score1);
        } else if (score < 3) {
            result_view.check(R.id.diag57_score2);


        } else if (score < 5) {
            result_view.check(R.id.diag57_score3);

        } else if (score > 4) {
            result_view.check(R.id.diag57_score4);

        }


    }
}