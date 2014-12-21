package com.phoenix.osteoporosis.activities.diagnosisActivities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.phoenix.osteoporosis.R;

/**
 * Created by phoenix on 11/12/2014.
 */
public class DiagH extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diagh);

        TextView title_tv = (TextView) findViewById(R.id.diag_information_title);
        TextView content_tv = (TextView) findViewById(R.id.diag_information_content);

        title_tv.setText(getInfoTitle());
        content_tv.setText(getInfoContent());


    }

    public String getInfoTitle() {
        String title = "طول مدت درمان";

        return title;
    }

    public String getInfoContent() {
        String content = "درمان باعث از میان رفتن خطر ایجاد ترک نمی شود بلکه آن را کاهش می دهد. در بیمارانی که دست کم به مدت 6 ماه تحت درمان بوده و با این وجود باز هم دچار ترک و شکستگی می شوند، این به معنای شکست خوردن درمان نیست. طبق دستورالعمل های NICE پاسخ به درمان هنگامی رضایت بخش نیست که بیمار با وجود 1 سال حفظ درمان، دچار شکستگی ثانویه می گردد و همچنین شواهدی مبنی بر کاهش BMD به پایین تر از حدپایه آن پیش از درمان می رسد. بسیاری از آژانس ها و سازمان های ارزیابی تکنولوژی سلامتی، درمان ها را به دو دسته سطح اول و سطح دوم تقسیم بندی می کنند و تنها پس از 2 سال، تغییر در درمان دارویی را توصیه و هزینه آن را نیز تقبل می کنند. ";

        return content;
    }
}