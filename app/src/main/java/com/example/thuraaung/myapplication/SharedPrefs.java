package com.example.thuraaung.myapplication;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by thuraaung on 12/7/15.
 */
public class SharedPrefs extends Activity implements View.OnClickListener {

    EditText sharedData;
    TextView dataResults;
    public static String FILENAME = "MySharedString";
    SharedPreferences someData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedpreferences);
        setUpVariables();
        someData = getSharedPreferences(FILENAME, 0);
    }

    private void setUpVariables() {
        Button save = (Button) findViewById(R.id.bSave);
        Button load = (Button) findViewById(R.id.bLoad);
        sharedData = (EditText) findViewById(R.id.etSharedPref);
        dataResults = (TextView)findViewById(R.id.tvLoadSharedPref);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bSave:
                String stringData = sharedData.getText().toString();
                SharedPreferences.Editor editor = someData.edit();
                editor.putString("sharedString", stringData);
                editor.commit();
                break;
            case R.id.bLoad:
                someData = getSharedPreferences(FILENAME, 0);
                String dataReturned = someData.getString("sharedString", "Couldn't load the data");
                dataResults.setText(dataReturned);
                break;
        }
    }
}
