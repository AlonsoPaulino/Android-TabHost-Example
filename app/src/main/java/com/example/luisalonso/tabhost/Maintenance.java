package com.example.luisalonso.tabhost;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luisalonso.tabhost.R;

/**
 * Created by luisalonso on 29/08/14.
 */
public class Maintenance extends Fragment {

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle savedInstanceState){
        super.onCreateView(inflater,group,savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_maintenance, group, false);
        return view;
    }
}
