package com.example.thuraaung.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by thuraaung on 12/10/15.
 */
public class ExternalData extends Activity {

    private TextView mCanRead, mCanWrite;
    private String state;
    private Boolean mRead, mWrite;
    private Spinner spinner;
    private String[] paths = {"Music", "Pictures", "Download"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.externaldata);
        mCanRead = (TextView) findViewById(R.id.tvCanRead);
        mCanWrite = (TextView) findViewById(R.id.tvCanWrite);
        state = Environment.getExternalStorageState();



        if (state.equals(Environment.MEDIA_MOUNTED)){
            // can read and write
            mCanRead.setText("true");
            mCanWrite.setText("true");
            mRead = mWrite = true;

        } else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
            // read only
            mCanRead.setText("true");
            mCanWrite.setText("false");
            mRead = true;
            mWrite = false;

        } else {
            // no read write permission
            mCanRead.setText("false");
            mCanWrite.setText("false");
            mRead = mWrite = false;

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, paths);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

    }
}
