package com.phoenix.osteoporosis.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.phoenix.osteoporosis.R;

/**
 * Created by phoenix on 28/11/2014.
 */
public class FooterFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.footer_layout, null);

        return inflate;
    }
}