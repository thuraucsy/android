package com.example.thuraaung.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by thuraaung on 12/7/15.
 */
public class Tabs extends Activity implements View.OnClickListener {

    TabHost th;
    TextView showResults;
    long start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs);

        th = (TabHost) findViewById(R.id.tabHost);
        Button newTab = (Button) findViewById(R.id.bAddTab);
        Button bStart = (Button) findViewById(R.id.bStart);
        Button bStop = (Button) findViewById(R.id.bStop);
        showResults = (TextView) findViewById(R.id.tvShowResults);

        newTab.setOnClickListener(this);
        bStart.setOnClickListener(this);
        bStop.setOnClickListener(this);
        th.setup();

        TabHost.TabSpec spec = th.newTabSpec("Tag1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Stop Watch");
        th.addTab(spec);
        spec = th.newTabSpec("Tag2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Tab 2");
        th.addTab(spec);
        spec = th.newTabSpec("Tag3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Add a Tab");
        th.addTab(spec);

        start = 0;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bAddTab:
                TabHost.TabSpec spec = th.newTabSpec("Tag 1");
                spec.setContent(new TabHost.TabContentFactory() {
                    @Override
                    public View createTabContent(String s) {
                        TextView text = new TextView(Tabs.this);
                        text.setText("You've created a new tab");
                        return text;
                    }
                });
                spec.setIndicator("New Tab");
                th.addTab(spec);
                break;

            case R.id.bStart:
                start = System.currentTimeMillis();

                break;

            case R.id.bStop:
                stop = System.currentTimeMillis();

                if (start != 0) {
                    long result = stop - start;
                    int millis = (int) result;
                    int seconds = (int) millis/1000;
                    int minutes = seconds/60;
                    millis = millis % 1000;
                    seconds = seconds % 60;
                    showResults.setText(String.format("%d:%02d:%02d",minutes,seconds,millis));

                }
                break;
        }
    }
}
