package com.phoenix.osteoporosis.activities.diagnosisActivities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.phoenix.osteoporosis.R;

/**
 * Created by phoenix on 11/12/2014.
 */
public class DiagB extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diagb);

        TextView title_tv = (TextView) findViewById(R.id.diag_information_title);
        TextView content_tv = (TextView) findViewById(R.id.diag_information_content);

        title_tv.setText(getInfoTitle());
        content_tv.setText(getInfoContent());


    }

    public String getInfoTitle() {
        String title = "شواهدی از درمان های خاص پوکی استخوان";

        return title;
    }

    public String getInfoContent() {
        String content ="شواهد حاکی از آن است که موارد خاص درمان پوکی استخوان در بیماران مسن، مفید واقع شده اند. اما اطلاعات موجود در مطالاعات صرفاً مختص به مسن ترین بیماران (بیش از 80 سال) و آن دسته از بیمارانی است که دو بیماری مزمن بطور همزمان داشته اند. در برخی موارد، حفظ درمان دارویی پوکی استخوان پس از ایجاد ترک، منطقی به نظر می رسد. در یک مطالعه بر روی جمعیت بزرگی از مردمان امریکا که دچار شکستگی لگن، مهره های بالینی، یا مچ و بازو بوده اند، خطر مرگ قابل توجه ارزیابی شده است و اغلب از خطر شکستگی ثانویه پس از اولین شکستگی های ذکر شده فراتر می رود.";

        return content;
    }
}