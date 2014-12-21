package com.phoenix.osteoporosis.activities;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.ScrollView;
import android.widget.TextView;
import com.phoenix.osteoporosis.R;


public class AboutActivity extends Activity
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_layout);
        //-----------------------------------------
        Typeface Face = Typeface.createFromAsset(getAssets(), "fonts/Yekan.ttf");

//        TextView Page_Title = (TextView) findViewById(R.id.tvCustomTitle);
//        Page_Title.setText("درباره کلینیک");
//        Page_Title.setTypeface(Face);
//        Page_Title.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);

        //********************************************************

        TextView tvAboutClinic = (TextView) findViewById(R.id.tvAboutClinic);
        tvAboutClinic.setTypeface(Face);
        tvAboutClinic.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);

        TextView tvAbout = (TextView) findViewById(R.id.textView1);
        tvAbout.setTypeface(Face);

        ScrollView sv = (ScrollView) findViewById(R.id.scrollView1);
        // sv.setDrawingCacheEnabled(false);
        //----------------------------------------------------------------

        tvAboutClinic.setText("مرکز جامع توانبخشی دکتر فرخانی با کمک جدیدترین متد های درمانی روز دنیا و با بهره گیری از آخرین دستگاه ها و تجهیزات پیشرفته به درمان بیماری های اسکلتی عضلانی می پردازد."
                + "\n\n" + "بخشی از خدماتی که در مرکز جامع توان بخشی دکتر فرخانی ارائه می شود به شرح زیر است :"
                + "\n" + "1- طب فیزیکی و توان بخشی"
                + "\n" + "2- فیزیوتراپی"
                + "\n" + "3- لیزرتراپی"
                + "\n" + "4- مگنت تراپی"
                + "\n" + "5- کشش ستون فقرات"
                + "\n" + "6- تحریک مغناطیسی مغز (TMS)"
                + "\n" + "7- شوک ویو تراپی"
                + "\n" + "8- درمان های دستی یا مانیپولاسیون"
                + "\n" + "9- تزریقات مفصلی و تاندونی"
                + "\n" + "10- ورزش درمانی"
                + "\n" + "11- تجویز ارتز و پروتز"
                + "\n" + "12- مکانو تراپی"
                + "\n" + ""
                + "\n\n" + "آدرس :"
                + "\n" + "اصفهان ، خیابان شمس آبادی ، چهارراه قصر ، رو به روی بانک ملت ، مجتمع پزشکی قصر ، طبقه زیر زمین"
                + "\n\n" + ""
                + "\n\n" + "تلقن های تماس :"
                + "\n" + "031-32330382"
                + "\n" + "031-32367465"
                + "\n\n" + ""
                + "\n\n" + "مشاوره مستقیم با دکتر فرخانی :"
                + "\n" + "0938-1114004"
                + "\n" + "(روزهای زوج 11:30 الی 12:30)"
                + "\n\n" + ""
                + "\n\n" + "وبسایت فارسی"
                + "\n" + "www.drfarkhani.ir"
                + "\n" + ""
                + "\n" + "وبسایت انگلیسی"
                + "\n" + "www.farkhaniclinic.ir"
                + "\n" + ""
                + "\n" + "وبسایت عربی"
                + "\n" + "www.farkhani.ir"

                + "\n\n"); // Apply Justification

        Resources r = getResources();
        float px = (float) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, r.getDisplayMetrics());
        tvAboutClinic.setLineSpacing(px, 1);



    } // End onCreate()



} // End Activity
