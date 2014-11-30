package com.phoenix.osteoporosis.custom_button;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.Button;


public class Class_Custom_Button extends Button
{

    public Class_Custom_Button(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        init();
    }


    public Class_Custom_Button(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }


    public Class_Custom_Button(Context context)
    {
        super(context);
        init();
    }


    private void init()
    {
        Typeface Face = Typeface.createFromAsset(getContext().getAssets(), "fonts/Yekan.ttf");
        setTypeface(Face);
        setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
        setText("ارسال مطلب برای دیگران");
    }

}