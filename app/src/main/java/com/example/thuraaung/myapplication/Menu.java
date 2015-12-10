package com.example.thuraaung.myapplication;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by thuraaung on 11/26/15.
 */
public class Menu extends ListActivity {

    String classes[] = {"MainActivity", "TextPlay", "Email", "Camera",
            "Tabs", "Flipper", "SharedPrefs", "InternalData", "ExternalData"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String cheese = classes[position];
        try {
            Class ourClass = Class.forName("com.example.thuraaung.myapplication." + cheese);
            Intent intent = new Intent(Menu.this, ourClass);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater blowup = getMenuInflater();
        blowup.inflate(R.menu.cool_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.aboutUs:
                Intent i = new Intent("com.example.thuraaung.myapplication.ABOUT");
                startActivity(i);
                break;

            case R.id.preferences:
                Intent p = new Intent("com.example.thuraaung.myapplication.PREFS");
                startActivity(p);
                break;

            case R.id.exit:
                finish();
                break;
        }
        return false;
    }
}
