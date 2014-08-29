package com.example.luisalonso.tabhost;
import android.support.v4.app.FragmentActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TabHost;

public class MyActivity extends FragmentActivity{

    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        initComponents();
        setOnTabHost();
        animateView();
    }

    public void initComponents(){
        TabHost tabHost = (TabHost)findViewById(R.id.tabHost); tabHost.setup();
    }

    public void setOnTabHost(){
        TabHost.TabSpec spec = tabHost.newTabSpec("Tab1");
        spec.setContent(R.id.tabFragmentWelcome);
        spec.setIndicator("Welcome",getResources().getDrawable(R.drawable.ic_action_social_person));
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Tab2");
        spec.setContent(R.id.tabFragmentMaintenance);
        spec.setIndicator("Maintenance ...",getResources().getDrawable(R.drawable.ic_action_device_access_storage_1));
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Tab3");
        spec.setContent(R.id.tabFragmentConsole);
        spec.setIndicator("Console",getResources().getDrawable(R.drawable.ic_action_hardware_computer));
        tabHost.addTab(spec);
    }

    public void animateView(){
        for(int i=0; i<3; i++){
            tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#000030"));
        }
        tabHost.setOnTabChangedListener(new AnimatedTabHostListener(tabHost));
        tabHost.setCurrentTab(1);
    }
}
