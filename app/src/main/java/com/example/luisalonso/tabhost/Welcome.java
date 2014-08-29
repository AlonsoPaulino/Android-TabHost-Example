package com.example.luisalonso.tabhost;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * Created by luisalonso on 28/08/14.
 */
public class Welcome extends Fragment{

    private ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle savedInstanceState){
        super.onCreateView(inflater, group, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_welcome, group);
        imageView = (ImageView)view.findViewById(R.id.imagen_robot);
        imageView.setImageResource(R.drawable.robot);
        return view;
    }
}
