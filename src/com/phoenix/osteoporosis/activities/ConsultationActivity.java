package com.phoenix.osteoporosis.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;
import com.phoenix.osteoporosis.R;
import com.phoenix.osteoporosis.util.DbHelper;


public class ConsultationActivity extends Activity {

    RadioButton rbBackPain, rbNeckPain, rbKneePain, rbShoulderPain, rbFootPain;
    RadioButton rbSendViaSms, rbSendViaEmail;
    //Button               btnProblem;
    EditText etName, etAge, etMobile, etTozihat;
    TableRow trMobile;
    Spinner spinner_state, spinner_city;

    DbHelper db;
    ArrayAdapter<String> SP_State_Adapter;
    ArrayAdapter<String> SP_City_Adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consultation_layout);

        //-----------------------------------------
        findViewById(R.id.btnSendArticle).setVisibility(View.GONE);
        findViewById(R.id.iv).setVisibility(View.GONE);

        //-----------------------------------------
        db = new DbHelper(this);
        //-----------------------------------------
        trMobile = (TableRow) findViewById(R.id.trMobile);
        trMobile.setVisibility(View.GONE);

        TextView tvName = (TextView) findViewById(R.id.tvName);
        etName = (EditText) findViewById(R.id.etName);
        TextView tvAge = (TextView) findViewById(R.id.tvAge);
        etAge = (EditText) findViewById(R.id.etAge);
        TextView tvMobile = (TextView) findViewById(R.id.tvMobile);
        etMobile = (EditText) findViewById(R.id.etMobile);

        TextView tvState = (TextView) findViewById(R.id.tvState);
        spinner_state = (Spinner) findViewById(R.id.spinner_state);
        spinner_state.setPrompt("استان خود را انتخاب کنید");
        TextView tvCity = (TextView) findViewById(R.id.tvCity);
        spinner_city = (Spinner) findViewById(R.id.spinner_city);
        spinner_city.setPrompt("شهرستان خود را انتخاب کنید");

        //TextView tvProblem = (TextView) findViewById(R.id.tvProblem);
        //btnProblem = (Button) findViewById(R.id.btnProblem);
        TextView tvTozihat = (TextView) findViewById(R.id.tvTozihat);
        etTozihat = (EditText) findViewById(R.id.etTozihat);
        rbSendViaSms = (RadioButton) findViewById(R.id.rbSendViaSms);
        TextView tv_rbSendViaSms = (TextView) findViewById(R.id.tv_rbSendViaSms);
        rbSendViaEmail = (RadioButton) findViewById(R.id.rbSendViaEmail);
        TextView tv_rbSendViaEmail = (TextView) findViewById(R.id.tv_rbSendViaEmail);
        Button btnOk = (Button) findViewById(R.id.btnOk);
        Button btnCancel = (Button) findViewById(R.id.btnCancel);

        Typeface Face = Typeface.createFromAsset(getAssets(), "fonts/Yekan.ttf");

        TextView Page_Title = (TextView) findViewById(R.id.tvCustomTitle);
        Page_Title.setText("مشاوره با درمانگران کلینیک");
        Page_Title.setTypeface(Face);
        Page_Title.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);

        tvName.setText("نام و نام خانوادگی:");
        tvName.setTypeface(Face);
        tvName.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);

        etName.setTypeface(Face);
        etName.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);

        tvAge.setText("سن:");
        tvAge.setTypeface(Face);
        tvAge.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);

        etAge.setTypeface(Face);
        etAge.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);

        tvMobile.setText("تلفن همراه:");
        tvMobile.setTypeface(Face);
        tvMobile.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);

        etMobile.setTypeface(Face);
        etMobile.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);

        tvState.setText("استان:");
        tvState.setTypeface(Face);
        tvState.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);

        tvCity.setText("شهرستان:");
        tvCity.setTypeface(Face);
        tvCity.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);

        //tvProblem.setText("شکایت اصلی:");
        //tvProblem.setTypeface(Face);
        //tvProblem.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);

        //btnProblem.setText("انتخاب کنید");
        //btnProblem.setTypeface(Face);
        //btnProblem.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);

        tvTozihat.setText("توضیحات:");
        tvTozihat.setTypeface(Face);
        tvTozihat.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);

        etTozihat.setTypeface(Face);
        etTozihat.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);
        //Converts 10 dip into its equivalent px
        Resources r = getResources();
        float px = (float) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, r.getDisplayMetrics());
        etTozihat.setLineSpacing(px, 1);

        tv_rbSendViaSms.setText("ارسال از طریق پیامک");
        tv_rbSendViaSms.setTypeface(Face);
        tv_rbSendViaSms.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);

        tv_rbSendViaEmail.setText("ارسال از طریق ایمیل");
        tv_rbSendViaEmail.setTypeface(Face);
        tv_rbSendViaEmail.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);

        btnOk.setText("تایید");
        btnOk.setTypeface(Face);
        btnOk.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);

        btnCancel.setText("انصراف");
        btnCancel.setTypeface(Face);
        btnCancel.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);

        //-----------------------------------------------------
        SP_State_Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line);
        SP_City_Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line);
        spinner_state.setAdapter(SP_State_Adapter);
        spinner_city.setAdapter(SP_City_Adapter);

        SP_State_Adapter.clear();
        SP_City_Adapter.clear();

        db.open();

        db.delete_Total_States();
        db.insert_Total_States();

        db.delete_Total_Cities();
        db.insert_Total_Cities();

        db.close();

        Fill_Spinner_State();

        spinner_state.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                SP_City_Adapter.clear();
                Fill_Spinner_City(position + 1);
            }


            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });

        //------------------------------------------------------
        rbSendViaSms.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                rbSendViaEmail.setChecked(false);

                trMobile.setVisibility(View.GONE);
            }
        });
        //-----------------------------------------------
        rbSendViaEmail.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                rbSendViaSms.setChecked(false);

                trMobile.setVisibility(View.VISIBLE);

                if (etMobile.getText().toString().equals(""))

                {
                    etMobile.requestFocus();
                    Toast.makeText(ConsultationActivity.this, "شماره تلفن همراه خود را وارد کنید", Toast.LENGTH_LONG).show();
                }
            }
        });
        //-----------------------------------------------
        /*
                btnProblem.setOnClickListener(new OnClickListener()
                {

                    @Override
                    public void onClick(View arg0)
                    {
                        Show_Alert_And_Select_Problem();
                    }
                });
        */
        //------------------------------------------------------------------
        btnCancel.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                onBackPressed();
            }
        });

        //---------------------------------------------------

        btnOk.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Check_Entries_And_Send();
            }
        });
        //---------------------------------------------------

        ImageView ivBackButton = (ImageView) findViewById(R.id.ivBackButton);

        ivBackButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i = new Intent();
                i.setClass(getApplicationContext(), MainActivity.class);
                startActivity(i);

                overridePendingTransition(R.anim.slide_in_to_right, R.anim.slide_out_to_right);
                finish();
            }
        });
        //-----------------------------

    } // End onCreate()


    //----------------------------------
    /*
        void Show_Alert_And_Select_Problem()
        {
            Builder builder = new AlertDialog.Builder(this);
            final AlertDialog ad = builder.create();
            ad.setCancelable(false);
            ad.show();

            ad.setContentView(R.layout.custom_alert_dialog);

            Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Zar_Bd.ttf");

            LinearLayout llSamplePic = (LinearLayout) ad.findViewById(R.id.llSamplePic);
            LinearLayout llCustomAlertDialog_Message = (LinearLayout) ad.findViewById(R.id.llCustomAlertDialog_Message);
            LinearLayout llSendAppToOthers = (LinearLayout) ad.findViewById(R.id.llSendAppToOthers);
            TextView Title = (TextView) ad.findViewById(R.id.tvCustomTitle);
            rbBackPain = (RadioButton) ad.findViewById(R.id.rbBackPain);
            rbNeckPain = (RadioButton) ad.findViewById(R.id.rbNeckPain);
            rbKneePain = (RadioButton) ad.findViewById(R.id.rbKneePain);
            rbShoulderPain = (RadioButton) ad.findViewById(R.id.rbShoulderPain);
            rbFootPain = (RadioButton) ad.findViewById(R.id.rbFootPain);
            TextView tv_rbBackPain = (TextView) ad.findViewById(R.id.tv_rbBackPain);
            TextView tv_rbNeckPain = (TextView) ad.findViewById(R.id.tv_rbNeckPain);
            TextView tv_rbKneePain = (TextView) ad.findViewById(R.id.tv_rbKneePain);
            TextView tv_rbShoulderPain = (TextView) ad.findViewById(R.id.tv_rbShoulderPain);
            TextView tv_rbFootPain = (TextView) ad.findViewById(R.id.tv_rbFootPain);
            Button btnOk = (Button) ad.findViewById(R.id.btnOk);
            Button btnCancel = (Button) ad.findViewById(R.id.btnCancel);

            llSamplePic.setVisibility(View.GONE);
            llCustomAlertDialog_Message.setVisibility(View.GONE);
            llSendAppToOthers.setVisibility(View.GONE);
            //btnCancel.setVisibility(View.GONE);

            Title.setTypeface(face);
            tv_rbBackPain.setTypeface(face);
            tv_rbNeckPain.setTypeface(face);
            tv_rbKneePain.setTypeface(face);
            tv_rbShoulderPain.setTypeface(face);
            tv_rbFootPain.setTypeface(face);
            btnOk.setTypeface(face);
            btnCancel.setTypeface(face);

            Title.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
            tv_rbBackPain.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
            tv_rbNeckPain.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
            tv_rbKneePain.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
            tv_rbShoulderPain.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
            tv_rbFootPain.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
            btnOk.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 13);
            btnCancel.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 13);

            Title.setText("انتخاب کنید");
            tv_rbBackPain.setText("کمر درد");
            tv_rbNeckPain.setText("گردن درد");
            tv_rbKneePain.setText("زانو درد");
            tv_rbShoulderPain.setText("شانه درد");
            tv_rbFootPain.setText("پا درد");
            btnOk.setText("تایید");
            btnCancel.setText("انصراف");

            if (btnProblem.getText().toString().equals("انتخاب کنید"))
                rbBackPain.setChecked(true);
            else
            {
                if (btnProblem.getText().toString().equals("کمر درد"))
                    rbBackPain.setChecked(true);
                if (btnProblem.getText().toString().equals("گردن درد"))
                    rbNeckPain.setChecked(true);
                if (btnProblem.getText().toString().equals("زانو درد"))
                    rbKneePain.setChecked(true);
                if (btnProblem.getText().toString().equals("شانه درد"))
                    rbShoulderPain.setChecked(true);
                if (btnProblem.getText().toString().equals("پا درد"))
                    rbFootPain.setChecked(true);
            }

            rbBackPain.setOnClickListener(new OnClickListener()
            {

                @Override
                public void onClick(View arg0)
                {

                    rbNeckPain.setChecked(false);
                    rbKneePain.setChecked(false);
                    rbShoulderPain.setChecked(false);
                    rbFootPain.setChecked(false);
                }
            });

            rbNeckPain.setOnClickListener(new OnClickListener()
            {

                @Override
                public void onClick(View arg0)
                {

                    rbBackPain.setChecked(false);
                    rbKneePain.setChecked(false);
                    rbShoulderPain.setChecked(false);
                    rbFootPain.setChecked(false);
                }
            });

            rbKneePain.setOnClickListener(new OnClickListener()
            {

                @Override
                public void onClick(View arg0)
                {

                    rbBackPain.setChecked(false);
                    rbNeckPain.setChecked(false);
                    rbShoulderPain.setChecked(false);
                    rbFootPain.setChecked(false);
                }
            });

            rbShoulderPain.setOnClickListener(new OnClickListener()
            {

                @Override
                public void onClick(View arg0)
                {

                    rbBackPain.setChecked(false);
                    rbNeckPain.setChecked(false);
                    rbKneePain.setChecked(false);
                    rbFootPain.setChecked(false);
                }
            });

            rbFootPain.setOnClickListener(new OnClickListener()
            {

                @Override
                public void onClick(View arg0)
                {

                    rbBackPain.setChecked(false);
                    rbNeckPain.setChecked(false);
                    rbKneePain.setChecked(false);
                    rbShoulderPain.setChecked(false);
                }
            });

            btnCancel.setOnClickListener(new OnClickListener()
            {

                @Override
                public void onClick(View arg0)
                {
                    ad.hide();
                }
            });

            btnOk.setOnClickListener(new OnClickListener()
            {

                @Override
                public void onClick(View arg0)
                {
                    ad.hide();

                    Show_Problem_On_Button();
                }
            });

        } // End Show_Alert_And_Select_Problem()
    */

    //------------------------------
    /*
        void Show_Problem_On_Button()
        {
            if (rbBackPain.isChecked())
                btnProblem.setText("کمر درد");
            if (rbNeckPain.isChecked())
                btnProblem.setText("گردن درد");
            if (rbKneePain.isChecked())
                btnProblem.setText("زانو درد");
            if (rbShoulderPain.isChecked())
                btnProblem.setText("شانه درد");
            if (rbFootPain.isChecked())
                btnProblem.setText("پا درد");

        } // End Show_Problem_On_Button()
    */

    //-------------------------------
    void Check_Entries_And_Send() {
        if (etName.getText().toString().trim().equals("")) {
            Toast.makeText(this, "نام و نام خانوادگی را وارد کنید", Toast.LENGTH_LONG).show();
            etName.requestFocus();
            return;
        }
        if (etAge.getText().toString().trim().equals("")) {
            Toast.makeText(this, "سن خود را وارد کنید", Toast.LENGTH_LONG).show();
            etAge.requestFocus();
            return;
        }
        if (trMobile.getVisibility() == View.VISIBLE && etMobile.getText().toString().trim().equals("")) {
            Toast.makeText(this, "شماره تلفن همراه خود را وارد کنید", Toast.LENGTH_LONG).show();
            etMobile.requestFocus();
            return;
        }
        /*        if (btnProblem.getText().toString().trim().equals("انتخاب کنید"))
                {
                    Toast.makeText(this, "شکایت اصلی خود را مشخص کنید", Toast.LENGTH_LONG).show();
                    return;
                }
        */
        Select_Action();

    } // End Check_Entries_And_Send()


    //-------------------------------

    void Select_Action() {
        if (rbSendViaSms.isChecked()) {
            Uri smsUri = Uri.parse("smsto:" + "09128444990");
            Intent i = new Intent(Intent.ACTION_SENDTO, smsUri);
            i.putExtra("sms_body", spinner_state.getSelectedItem().toString().trim() + "/" +
                            spinner_city.getSelectedItem().toString().trim() + "/" +
                            etName.getText().toString().trim() + "/" +
                            etAge.getText().toString().trim() + // "/" +
                            //btnProblem.getText().toString().trim() +
                            "\n" + etTozihat.getText().toString().trim()
            );

            startActivity(i);

        } // End if (rbSendViaSms.isChecked())

        if (rbSendViaEmail.isChecked()) {
            Intent i = new Intent(Intent.ACTION_SEND);

            i.setType("message/rfc822");
            i.putExtra(Intent.EXTRA_EMAIL, new String[]{"omidclinic.pmr@gmail.com"});
            i.putExtra(Intent.EXTRA_SUBJECT, "درخواست مشاوره با کلینیک امید");
            i.putExtra(Intent.EXTRA_TEXT, "استان: " + spinner_state.getSelectedItem().toString().trim() + "\n" +
                            "شهرستان: " + spinner_city.getSelectedItem().toString().trim() + "\n" +
                            "نام و نام خانوادگی: " + etName.getText().toString().trim() + "\n" +
                            "سن: " + etAge.getText().toString().trim() + "\n" +
                            "تلفن همراه: " + etMobile.getText().toString().trim() + // "\n" +
                            //"شکایت اصلی: " + btnProblem.getText().toString().trim() +
                            "\n\n" + "توضیحات: " + etTozihat.getText().toString().trim()
            );

            startActivity(i);

        } // End if (rbSendViaEmail.isChecked())

    } // End Select_Action()


    //---------------------------------

    @Override
    public void onBackPressed() {
        Intent i = new Intent();
        i.setClass(this, MainActivity.class);
        startActivity(i);

        overridePendingTransition(R.anim.slide_in_to_right, R.anim.slide_out_to_right);
        finish();
    }


    //------------------------------
    void Fill_Spinner_State() {
        db.open();

        Cursor c = db.get_All_States();

        if (c.moveToFirst()) {
            do {
                String state_name = c.getString(1);
                SP_State_Adapter.add(state_name);
            }
            while (c.moveToNext());
        }

        c.close();
        db.close();

    } // End Fill_Spinner_State()


    //------------------------------

    void Fill_Spinner_City(int state_id) {
        db.open();

        Cursor c = db.get_State_Cities(state_id);
        //startManagingCursor(c);

        if (c.moveToFirst()) {
            do {
                String city_name = c.getString(0);
                SP_City_Adapter.add(city_name);
            }
            while (c.moveToNext());
        }

        c.close();
        db.close();

    } // End Fill_Spinner_City()

    //------------------------------

} // End Activity
