package com.phoenix.osteoporosis.fragments;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.phoenix.osteoporosis.R;
import com.phoenix.osteoporosis.activities.*;
import com.phoenix.osteoporosis.util.Global;

import java.io.File;

/**
 * Created by phoenix on 28/11/2014.
 */
public class FooterFragment extends Fragment implements View.OnClickListener
{
    RadioButton rbSendViaBluetooth;
    RadioButton rbSendViaEmail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.footer_layout, null);

        inflate.findViewById(R.id.footer_developer).setOnClickListener(this);
        inflate.findViewById(R.id.footer_search).setOnClickListener(this);
        inflate.findViewById(R.id.footer_send).setOnClickListener(this);
        inflate.findViewById(R.id.footer_site).setOnClickListener(this);

        return inflate;
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();


        Intent intent = null;
        switch (id) {
            case R.id.footer_search:
                intent = new Intent(view.getContext(), SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.footer_site:
                intent = new Intent(view.getContext(), AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.footer_send:
                send_app();
                break;
            case R.id.footer_developer:
                intent = new Intent(view.getContext(), DeveloperActivity.class);
                startActivity(intent);
                break;
        }


    }


    public void send_app() {
        show_Alert_And_Send();
    }

    private void show_Alert_And_Send() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final AlertDialog ad = builder.create();
        //ad.setCancelable(false);
        ad.show();

        ad.setContentView(R.layout.custom_alert_dialog);

        Typeface face = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Zar_Bd.ttf");

        LinearLayout llCustomAlertDialog_Message = (LinearLayout) ad.findViewById(R.id.llCustomAlertDialog_Message);
        TextView Title = (TextView) ad.findViewById(R.id.tvCustomTitle);
        rbSendViaBluetooth = (RadioButton) ad.findViewById(R.id.rbSendViaBluetooth);
        rbSendViaEmail = (RadioButton) ad.findViewById(R.id.rbSendViaEmail);
        TextView tv_rbSendViaBluetooth = (TextView) ad.findViewById(R.id.tv_rbSendViaBluetooth);
        TextView tv_rbSendViaEmail = (TextView) ad.findViewById(R.id.tv_rbSendViaEmail);
        Button btnOk = (Button) ad.findViewById(R.id.btnOk);
        Button btnCancel = (Button) ad.findViewById(R.id.btnCancel);

        llCustomAlertDialog_Message.setVisibility(View.GONE);

        Title.setTypeface(face);
        tv_rbSendViaBluetooth.setTypeface(face);
        tv_rbSendViaEmail.setTypeface(face);
        btnOk.setTypeface(face);
        btnCancel.setTypeface(face);

        Title.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        tv_rbSendViaBluetooth.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        tv_rbSendViaEmail.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        btnOk.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 13);
        btnCancel.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 13);

        Title.setText("انتخاب کنید");
        tv_rbSendViaBluetooth.setText("ارسال از طریق بلوتوث");
        tv_rbSendViaEmail.setText("ارسال از طریق ایمیل");
        btnOk.setText("تایید");
        btnCancel.setText("انصراف");

        rbSendViaBluetooth.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                rbSendViaEmail.setChecked(false);
            }
        });

        rbSendViaEmail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                rbSendViaBluetooth.setChecked(false);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                ad.dismiss();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                ad.dismiss();

                selectAction();
            }
        });

    }

    private void selectAction() {
        if (rbSendViaBluetooth.isChecked()) {
            String s = getActivity().getPackageName();
            try {
                s = getActivity().getPackageManager().getPackageInfo(s, 0).applicationInfo.sourceDir;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }

            File source = new File(s);
            File destination = new File(Global.DIR_APP_TO_SEND + "/osteoporosis.apk");

            Log.i("TAG", "Source: " + source);
            Log.i("TAG", "Destination: " + destination);

            if (!destination.exists()) {
                Log.i("TAG", "APK File Not Exists, Copy Needed!");
                Global.resourceHandler.copyFile(source, destination);
            }

            Intent i = new Intent(Intent.ACTION_SEND);
            //i.setType("application/vnd.android.package-archive");
            i.setType("application/zip");
            i.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(destination));
            i.setPackage("com.android.bluetooth");
            startActivity(i);

        } // End if(rbSendViaBluetooth.isChecked())

        //---------------------------------------

        if (rbSendViaEmail.isChecked()) {
            String s = getActivity().getPackageName();
            try {
                s = getActivity().getPackageManager().getPackageInfo(s, 0).applicationInfo.sourceDir;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }

            File source = new File(s);
            File destination = new File(Global.DIR_APP_TO_SEND + "/osteoporosis.apk");

            Log.i("TAG", "Source: " + source);
            Log.i("TAG", "Destination: " + destination);

            if (!destination.exists()) {
                Log.i("TAG", "APK File Not Exists, Copy Needed!");
                Global.resourceHandler.copyFile(source, destination);
            }

            Intent i = new Intent(Intent.ACTION_SEND);
            i.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(destination));
            i.setType("message/rfc822");
            //--------------------------
            i.putExtra(Intent.EXTRA_EMAIL, new String[]{"ایمیل گیرنده را اینجا بنویسید"});
            i.putExtra(Intent.EXTRA_SUBJECT, "عنوان: ");
            i.putExtra(Intent.EXTRA_TEXT, "متن: ");

            startActivity(i);

        } // End if(rbSendViaEmail.isChecked())

    }

    public void show_site() {

        Intent i = new Intent(Intent.ACTION_VIEW);
        String url = "http://www.orped.com";
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}