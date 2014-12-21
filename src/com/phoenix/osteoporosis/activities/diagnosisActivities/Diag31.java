package com.phoenix.osteoporosis.activities.diagnosisActivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.phoenix.osteoporosis.R;

/**
 * Created by phoenix on 12/12/2014.
 */
public class Diag31 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diag31);
    }


    public void onClick(View view) {

        int id = view.getId();
        Intent intent = null;

        int first_color = getResources().getColor(R.color.tile_back2);
        int second_color = getResources().getColor(R.color.tile_back);

        switch (id) {


            case R.id.diag_info_btn:
                intent = new Intent(this, Diag29.class);
                startActivity(intent);
                break;
            case R.id.diag_header_back:
                onBackPressed();
                break;
            case R.id.diag_l1:
                LinearLayout l1 = (LinearLayout) findViewById(R.id.diag_l1);
                TextView title1 = (TextView) l1.findViewById(R.id.diag_title1);
                String tag = (String) title1.getTag();

                if (tag.equals("0")) {
                    title1.setTag("1");

                    animate(l1, title1, "ادامه", second_color, 1);
                } else {
                    title1.setTag("0");
                    animate(l1, title1, "بیسفسفنات خوراکی", first_color, 1);
                }
                break;
            case R.id.diag_l2:
                LinearLayout l2 = (LinearLayout) findViewById(R.id.diag_l2);
                TextView title2 = (TextView) l2.findViewById(R.id.diag_title2);
                String tag2 = (String) title2.getTag();

                if (tag2.equals("0")) {
                    title2.setTag("1");

                    animate(l2, title2, "ادامه", second_color, 2);
                } else {
                    title2.setTag("0");
                    animate(l2, title2, "بیسفسفنات وریدی", first_color, 2);
                }
                break;
            case R.id.diag_l3:
                LinearLayout l3 = (LinearLayout) findViewById(R.id.diag_l3);
                TextView title3 = (TextView) l3.findViewById(R.id.diag_title3);
                String tag3 = (String) title3.getTag();

                if (tag3.equals("0")) {
                    title3.setTag("1");

                    animate(l3, title3, "ادامه", second_color, 3);
                } else {
                    title3.setTag("0");
                    animate(l3, title3, "دنوسوماب", first_color, 3);
                }
                break;
            case R.id.diag_l4:
                LinearLayout l4 = (LinearLayout) findViewById(R.id.diag_l4);
                TextView title4 = (TextView) l4.findViewById(R.id.diag_title4);
                String tag4 = (String) title4.getTag();

                if (tag4.equals("0")) {
                    title4.setTag("1");

                    animate(l4, title4, "ترک موقت دارو برای 35 روز", second_color, 4);
                } else {
                    title4.setTag("0");
                    animate(l4, title4, "تعدیل کننده های انتخابی گیرنده  استروژن (SERM برای مثال رالوکسیفن)", first_color, 4);
                }
                break;
            case R.id.diag_l5:
                LinearLayout l5 = (LinearLayout) findViewById(R.id.diag_l5);
                TextView title5 = (TextView) l5.findViewById(R.id.diag_title5);
                String tag5 = (String) title5.getTag();

                if (tag5.equals("0")) {
                    title5.setTag("1");

                    animate(l5, title5, "تغییر روش درمانی به مصرف بیسفسفنات خوراکی", second_color, 5);
                } else {
                    title5.setTag("0");
                    animate(l5, title5, "استرانسیوم رانلات", first_color, 5);
                }
                break;
            case R.id.diag_l6:
                LinearLayout l6 = (LinearLayout) findViewById(R.id.diag_l6);
                TextView title6 = (TextView) l6.findViewById(R.id.diag_title6);
                String tag6 = (String) title6.getTag();

                if (tag6.equals("0")) {
                    title6.setTag("1");

                    animate(l6, title6, "ادامه مصرف (تا حداکثر 24 ماه از زمان شروع)", second_color, 6);
                } else {
                    title6.setTag("0");
                    animate(l6, title6, "تریپاراتید، PTH", first_color, 6);
                }
                break;

            case R.id.diag_i1:
                intent = new Intent(this, DiagInformation.class);
                intent.putExtra("page", 32);
                startActivity(intent);
                break;
            case R.id.diag_i4:
                intent = new Intent(this, DiagInformation.class);
                intent.putExtra("page", 36);
                startActivity(intent);
                break;
            case R.id.diag_i5:
                intent = new Intent(this, DiagInformation.class);
                intent.putExtra("page", 38);
                startActivity(intent);
                break;
            case R.id.diag_i6:
                intent = new Intent(this, DiagInformation.class);
                intent.putExtra("page", 42);
                startActivity(intent);
                break;

        }
    }


    public void animate(final View parent, final View child, final String text, final int back_color, final int i) {

        Animation outAnim = AnimationUtils.makeOutAnimation(this, false);
        final Animation inAnim = AnimationUtils.makeInAnimation(this, false);
        outAnim.setDuration(500);

        inAnim.setDuration(500);

        outAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ((TextView) child).setText(text);
                parent.setBackgroundColor(back_color);
                if (i == 1) {
                    View view = findViewById(R.id.diag_i1);
                    if (view.getVisibility() == View.GONE) {
                        view.setVisibility(View.VISIBLE);
                    } else {
                        view.setVisibility(View.GONE);
                    }
                }
                if (i == 4) {
                    View view = findViewById(R.id.diag_i4);
                    if (view.getVisibility() == View.GONE) {
                        view.setVisibility(View.VISIBLE);
                    } else {
                        view.setVisibility(View.GONE);
                    }
                }
                if (i == 5) {
                    View view = findViewById(R.id.diag_i5);
                    if (view.getVisibility() == View.GONE) {
                        view.setVisibility(View.VISIBLE);
                    } else {
                        view.setVisibility(View.GONE);
                    }
                }
                if (i == 6) {
                    View view = findViewById(R.id.diag_i6);
                    if (view.getVisibility() == View.GONE) {
                        view.setVisibility(View.VISIBLE);
                    } else {
                        view.setVisibility(View.GONE);
                    }
                }
                parent.startAnimation(inAnim);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        parent.startAnimation(outAnim);

    }
}