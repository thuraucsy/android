package com.example.thuraaung.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

import java.io.InterruptedIOException;

/**
 * Created by thuraaung on 11/26/15.
 */
public class Splash extends Activity {
    MediaPlayer ourSong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        ourSong = MediaPlayer.create(Splash.this, R.raw.apple_iphone);

        SharedPreferences getPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean music = getPref.getBoolean("checkbox", true);
        if (music == true)
            ourSong.start();

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent startingPoint = new Intent("com.example.thuraaung.myapplication.MENU");
                    startActivity(startingPoint);
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ourSong.release();
        finish();
    }
}
