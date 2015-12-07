package com.example.thuraaung.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

/**
 * Created by thuraaung on 12/7/15.
 */
public class Flipper extends Activity implements View.OnClickListener {

    ViewFlipper flippy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flipper);
        flippy = (ViewFlipper) findViewById(R.id.viewFlipper);
        flippy.setOnClickListener(this);
        flippy.setFlipInterval(400);
        flippy.startFlipping();
    }

    @Override
    public void onClick(View view) {
        flippy.showNext();
    }
}
