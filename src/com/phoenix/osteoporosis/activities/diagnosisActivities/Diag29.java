package com.phoenix.osteoporosis.activities.diagnosisActivities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.phoenix.osteoporosis.R;

/**
 * Created by phoenix on 21/12/2014.
 */
public class Diag29 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diag29);
    }

    public void onClick(View view) {
        int id = view.getId();
        int first_color = getResources().getColor(R.color.tile_back2);
        int second_color = getResources().getColor(R.color.tile_back);
        switch (id) {
            case R.id.diag29_l1:
                LinearLayout l1 = (LinearLayout) findViewById(R.id.diag29_l1);
                TextView title1 = (TextView) l1.findViewById(R.id.diag29_title1);
                String tag = (String) title1.getTag();

                if (tag.equals("0")) {
                    title1.setTag("1");
                    animate(l1, title1,"70 میلی گرم در هفته؛ 2،000 واحد ویتامین دی 3 و 1،000 میلی گرم کلسیم روزانه",second_color);
                } else {
                    title1.setTag("0");
                    animate(l1, title1,"آلندرونات",first_color);
                }
                break;
            case R.id.diag29_l2:
                LinearLayout l2 = (LinearLayout) findViewById(R.id.diag29_l2);
                TextView title2 = (TextView) l2.findViewById(R.id.diag29_title2);
                String tag2 = (String) title2.getTag();

                if (tag2.equals("0")) {
                    title2.setTag("1");
                    animate(l2, title2,"60 میلی گرم SC هر 6 ماه؛ 2،000 واحد ویتامین دی 3 و 1،000 میلی گرم کلسیم روزانه",second_color);
                } else {
                    title2.setTag("0");
                    animate(l2, title2,"دنوسوماب:",first_color);
                }
                break;
            case R.id.diag29_l3:
                LinearLayout l3 = (LinearLayout) findViewById(R.id.diag29_l3);
                TextView title3 = (TextView) l3.findViewById(R.id.diag29_title3);
                String tag3 = (String) title3.getTag();
                if (tag3.equals("0")) {
                    title3.setTag("1");
                    animate(l3, title3,"60 میلی گرم مصرف روزانه خوراکی؛ 2،000 واحد ویتامین دی 3 و 1،000 میلی گرم کلسیم روزانه",second_color);
                } else {
                    title3.setTag("0");
                    animate(l3, title3,"رالوکسیفن:",first_color);
                }
                break;
            case R.id.diag29_l4:
                LinearLayout l4 = (LinearLayout) findViewById(R.id.diag29_l4);
                TextView title4 = (TextView) l4.findViewById(R.id.diag29_title4);
                String tag4 = (String) title4.getTag();
                if (tag4.equals("0")) {
                    title4.setTag("1");
                    animate(l4, title4,"2 گرم هر بعد از ظهر؛ 2،000 واحد ویتامین دی 3 و 1،000 میلی گرم کلسیم روزانه",second_color);
                } else {
                    title4.setTag("0");
                    animate(l4, title4,"استرانسیوم رانلات:",first_color);
                }
                break;
            case R.id.diag29_l5:
                LinearLayout l5 = (LinearLayout) findViewById(R.id.diag29_l5);
                TextView title5 = (TextView) l5.findViewById(R.id.diag29_title5);
                String tag5 = (String) title5.getTag();

                if (tag5.equals("0")) {
                    title5.setTag("1");
                    animate(l5, title5,"20 میلی گرم SC روزانه هر بعد از ظهر برای 2 سال؛ 2،000 واحد ویتامین دی 3 و 1،000 میلی گرم کلسیم روزانه",second_color);
                } else {
                    title5.setTag("0");
                    animate(l5, title5,"تریپاراتید:",first_color);
                }
                break;
            case R.id.diag29_l6:
                LinearLayout l6 = (LinearLayout) findViewById(R.id.diag29_l6);
                TextView title6 = (TextView) l6.findViewById(R.id.diag29_title6);
                String tag6 = (String) title6.getTag();
                if (tag6.equals("0")) {
                    title6.setTag("1");
                    animate(l6, title6,"5 میلی گرم برای هر تزریق در هر سال؛ 2،000 واحد ویتامین دی 3 و 1،000 میلی گرم کلسیم روزانه",second_color);
                } else {
                    title6.setTag("0");
                    animate(l6, title6,"زالدرونیک اسید:",first_color);
                }
                break;

        }


    }


    public void animate(final View parent, final View child, final String text, final int back_color) {

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
                ((TextView)child).setText(text);
                parent.setBackgroundColor(back_color);
                parent.startAnimation(inAnim);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        parent.startAnimation(outAnim);

    }
}