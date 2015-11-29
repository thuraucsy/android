package com.example.thuraaung.myapplication;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by thuraaung on 11/29/15.
 */
public class Prefs extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);
    }

    private void addPreferencesFromResource() {
    }
}
