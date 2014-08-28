package com.example.luisalonso.tabhost;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;


public class MyActivity extends Activity {

    /*Probando si funciona el push :v*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        TabHost tabHost = (TabHost)findViewById(R.id.tabHost); tabHost.setup();
        TabHost.TabSpec spec = tabHost.newTabSpec("Tab1");
            spec.setContent(R.id.tabFragmentWelcome);
            spec.setIndicator("Welcome",getResources().getDrawable(R.drawable.ic_action_social_person));
            tabHost.addTab(spec);

            spec = tabHost.newTabSpec("Tab2");
            spec.setContent(R.id.tabFragment1);
            spec.setIndicator("Maintenance ...",getResources().getDrawable(R.drawable.ic_action_device_access_storage_1));
            tabHost.addTab(spec);

            spec = tabHost.newTabSpec("Tab3");
            spec.setContent(R.id.tabFragmentConsole);
            spec.setIndicator("Console",getResources().getDrawable(R.drawable.ic_action_hardware_computer));
            tabHost.addTab(spec);
        for(int i=0; i<3; i++){
            tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#000030"));

        }
        tabHost.setCurrentTab(2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
