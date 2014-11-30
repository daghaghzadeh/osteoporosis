package com.phoenix.osteoporosis.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.phoenix.osteoporosis.R;
import com.phoenix.osteoporosis.quick_action_3d.ActionItem;
import com.phoenix.osteoporosis.quick_action_3d.QuickAction;
import com.phoenix.osteoporosis.util.Article;
import com.phoenix.osteoporosis.util.Global;
import com.phoenix.osteoporosis.util.RawHelper;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ArticleActivity extends Activity {

    String Html_Content;

    int count = 0;
    ArrayList<String> urls = new ArrayList<String>();


    TextView tv_Article_Content;

    SharedPreferences pref;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_layout);
        //-------------------------------------------------------------------

        int id = getIntent().getIntExtra("id", -1);

        Article article = Global.database.getArticle(id);

        //------------------------------------------------------------
        Typeface Face = Typeface.createFromAsset(getAssets(), "fonts/Yekan.ttf");

        final TextView Page_Title = (TextView) findViewById(R.id.tvCustomTitle);
        Page_Title.setText(article.title);
        Page_Title.setTypeface(Face);
        Page_Title.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
        //------------------------------------------------------
        Html_Content = article.content;
        //----------------------------------------------------------

        Prepare_Article_Image_Urls(Html_Content);

        Show_Article();

        urls.clear();

        //----------------------------

        ImageView ivBackButton = (ImageView) findViewById(R.id.ivBackButton);


        //-----------------------------

        Button btnSendArticle = (Button) findViewById(R.id.btnSendArticle);

        btnSendArticle.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(Intent.ACTION_SEND);

                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"ایمیل گیرنده را اینجا بنویسید"});
                i.putExtra(Intent.EXTRA_SUBJECT, Page_Title.getText().toString());
                i.putExtra(Intent.EXTRA_TEXT, tv_Article_Content.getText().toString()
                                + "\n--------------------\n"
                                + "ارسال شده از نرم افزار اندرویدی درمان بدون جراحی کمردرد"
                                + "\n" + "کاری از مرکز جامع توانبخشی امید"
                                + "\n" + "آدرس کلینیک دیباجی: تهران، خیابان پاسداران، خیابان شهید کلاهدوز (دولت)، دیباجی جنوبی، روبروی سنجابی، پلاک 17"
                                + "\n" + "تلفن: " + "021-22780701 / 021-22780702"
                                + "\n" + "آدرس کلینیک مطهری: تهران، خیابان ولیعصر، نرسیده به استاد مطهری، کوچه افتخار، پلاک 34، طبقه همکف"
                                + "\n" + "تلفن: " + "021-88898440 / 021-88898441"
                                + "\n" + "وب سایت: " + "http://omidrehab.com"
                        // + "\n" + "لینک دریافت  نرم افزار: " + "http://cafebazaar.ir/app/com.bip.farkhani.bazaar/?l=fa"
                );

                startActivity(i);
            }
        });

        //------- Quick Action 3D ---------

        Define_Font_Change_Functionality();

        //---------------------------------

    } // End onCreate()


    //---------------------------------

    void Prepare_Article_Image_Urls(String Html_Content) {
        urls.clear();

        int img_numbers = Count_img_Tags(Html_Content);

        Log.i("TAG", "IMG_Numbers: " + img_numbers);

        int offset = 0;

        for (int j = 1; j <= img_numbers; j++) {

            int img_tag_index = Html_Content.indexOf("img", offset);
            int src_index_start = Html_Content.indexOf("src", img_tag_index);
            int url_start = src_index_start + 5; // Begin of "http://..."
            int url_end = Html_Content.indexOf("\"", url_start);

            String image_url = Html_Content.substring(url_start, url_end);

            urls.add(image_url);

            offset = url_end;

        } // End for

    } // End Prepare_Article_Image_Urls


    //-------------------------------

    int Count_img_Tags(String content) {
        Pattern p = Pattern.compile("img");
        Matcher m = p.matcher(content);
        int count = 0;
        while (m.find()) {
            count++;
        }

        return count;

    } // End Count_img_Tags()


    //----------------------------------

    public void Show_Article() {

        tv_Article_Content = (TextView) findViewById(R.id.tvArticleContent);
        tv_Article_Content.setText(Html.fromHtml(Html_Content, new ImageGetter(), null));

        Typeface Face = Typeface.createFromAsset(Global.context.getAssets(), "fonts/Yekan.ttf");
        tv_Article_Content.setTypeface(Face);

        pref = getSharedPreferences("Preferences", MODE_PRIVATE);
        int Font_Size = pref.getInt("Font_Size_Normal", 14);
        tv_Article_Content.setTextSize(TypedValue.COMPLEX_UNIT_DIP, Font_Size);

        //Converts 15 dip into its equivalent px
        Resources r = Global.context.getResources();
        float px = (float) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, r.getDisplayMetrics());
        tv_Article_Content.setLineSpacing(px, 1);

    } // End Show_Article()


    //------------------------

    private class ImageGetter implements Html.ImageGetter {

        @Override
        public Drawable getDrawable(String source) {

            Drawable drawable;

            String url = urls.get(count);

            String filename = url;
            int Lenght = filename.length();
            String Dot_Ext = filename.substring(Lenght - 4, Lenght);
            filename = filename.replace(Dot_Ext, "");
            Log.i("TAG", "Image_Name: " + filename);

            int id = RawHelper.getResourceID(ArticleActivity.this, filename);
            Log.i("TAG", "Image_id: " + id);
            if (id > 0) {
                drawable = getResources().getDrawable(id);
            }
            else{
                drawable = getResources().getDrawable(R.drawable.image_not_found);
            }
            //------------------------------------------------------
            Display display = getWindowManager().getDefaultDisplay();
            int width = display.getWidth();

            drawable.setBounds((width / 2) - (drawable.getIntrinsicWidth() / 2),
                    0,
                    (width / 2) + (drawable.getIntrinsicWidth() / 2),
                    drawable.getIntrinsicHeight());

            count++;

            return drawable;

        } // End getDrawable()

    } // End class ImageGetter

    //------------------------------

    void Define_Font_Change_Functionality() {
        //action id
        final int INCREASE = 1;
        final int DECREASE = 2;

        ActionItem nextItem = new ActionItem(INCREASE, null, getResources().getDrawable(R.drawable.icon_font_increase));
        ActionItem prevItem = new ActionItem(DECREASE, null, getResources().getDrawable(R.drawable.icon_font_decrease));

        //use setSticky(true) to disable QuickAction dialog being dismissed after an item is clicked
        prevItem.setSticky(true);
        nextItem.setSticky(true);

        //create QuickAction. Use QuickAction.VERTICAL or QuickAction.HORIZONTAL param to define layout orientation
        final QuickAction quickAction = new QuickAction(this, QuickAction.HORIZONTAL, "Normal");

        //add action items into QuickAction
        quickAction.addActionItem(nextItem);
        quickAction.addActionItem(prevItem);

        //Set listener for action item clicked
        quickAction.setOnActionItemClickListener(new QuickAction.OnActionItemClickListener() {

            @Override
            public void onItemClick(QuickAction source, int pos, int actionId) {
                //ActionItem actionItem = quickAction.getActionItem(pos);

                //here we can filter which action item was clicked with pos or actionId parameter
                switch (actionId) {
                    case INCREASE:
                        int Font_Size = pref.getInt("Font_Size_Normal", 14);
                        SharedPreferences.Editor editor = pref.edit();
                        if (Font_Size < 24) {
                            editor.putInt("Font_Size_Normal", Font_Size + 1);
                            editor.commit();

                            tv_Article_Content.setTextSize(TypedValue.COMPLEX_UNIT_DIP, Font_Size + 1);
                            quickAction.set_New_Font_Size("Normal");
                        }
                        break;

                    case DECREASE:
                        Font_Size = pref.getInt("Font_Size_Normal", 14);
                        editor = pref.edit();
                        if (Font_Size > 10) {
                            editor.putInt("Font_Size_Normal", Font_Size - 1);
                            editor.commit();

                            tv_Article_Content.setTextSize(TypedValue.COMPLEX_UNIT_DIP, Font_Size - 1);
                            quickAction.set_New_Font_Size("Normal");
                        }
                        break;
                }

            }
        });

        //set listnener for on dismiss event, this listener will be called only if QuickAction dialog was dismissed
        //by clicking the area outside the dialog.
        quickAction.setOnDismissListener(new QuickAction.OnDismissListener() {

            @Override
            public void onDismiss() {
                //Toast.makeText(getApplicationContext(), "Dismissed", Toast.LENGTH_SHORT).show();
            }
        });

//        ImageView ivFont = (ImageView) findViewById(R.id.ivFont);
//        ivFont.setOnClickListener(new OnClickListener()
//        {
//
//            @Override
//            public void onClick(View v)
//            {
//                quickAction.show(v);
//            }
//
//        });

    } // End Defien_Font_Change_Functionality()

    //-----------------------------------------

} // End Activity
