package com.phoenix.osteoporosis.activities;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;
import com.phoenix.osteoporosis.R;


public class DeveloperActivity extends Activity
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.developer_layout);
        //-----------------------------------------
        Typeface Face = Typeface.createFromAsset(getAssets(), "fonts/Yekan.ttf");

//        TextView Page_Title = (TextView) findViewById(R.id.tvCustomTitle);
//        Page_Title.setText("درباره تیم توسعه دهنده");
//        Page_Title.setTypeface(Face);
//        Page_Title.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);

        //********************************************************

        TextView tvAboutDeveloperTeam = (TextView) findViewById(R.id.tvAboutDevelopersTeam);
        tvAboutDeveloperTeam.setTypeface(Face);
        tvAboutDeveloperTeam.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);

        TextView tvAboutDeveloper = (TextView) findViewById(R.id.textView1);
        tvAboutDeveloper.setTypeface(Face);

        //----------------------------------------------------------------

        tvAboutDeveloperTeam.setText("شرکت پیشگامان کسب و کار هوشمند - بيپ (Bip) به صورت حرفه اي و دانش محور با بهره گيري از تخصص اساتيد محترم دانشگاه در رشته هاي  مهندسي کامپيوتر و  فناوري اطلاعات و ارتباطات،  به توليد نرم افزارهاي موبايل (android/ios) تحت وب (Web-Base) و دسکتاپ (desktop) مي پردازد."
                + "\n" + "از ديگر خدمات تيم توسعه بيپ (Bip) طراحي سايت و بهينه سازي سايت براي موتورهاي جستجو (SEO) به شيوه علمي و بر اساس متدولوژي محتوا محور و کارآمد است که باعث بهبود موثر کسب و کار مشتري و افزايش مخاطب مي شود."
                + "\n\n" + "تلفن تماس:"
                + "\n" + "031-32680941"
                + "\n" + "همراه:"
                + "\n" + "09397262608 " + "(دقاق زاده)"
                + "\n\n" + "پست الکترونیک:"
                + "\n" + "h.daghagh@gmail.com"
                + "\n" + "drdaghaghzadeh@gmail.com"
                + "\n" + "bipcompany.android@gmail.com"
                + "\n"); // Apply Justification

        //     tvAboutDeveloperTeam.setTextAlign(Align.RIGHT);

        //Converts 15 dip into its equivalent px
        Resources r = getResources();
        float px = (float) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, r.getDisplayMetrics());
        tvAboutDeveloperTeam.setLineSpacing(px, 1);


    } // End onCreate()


    //----------------------------------


} // End Activity
