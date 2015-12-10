package com.example.thuraaung.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by thuraaung on 12/8/15.
 */
public class InternalData extends Activity implements View.OnClickListener {
    EditText sharedData;
    TextView dataResults;
    FileOutputStream fos;
    String FILENAME = "InternalString";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedpreferences);
        setUpVariables();
    }

    private void setUpVariables() {
        Button save = (Button) findViewById(R.id.bSave);
        Button load = (Button) findViewById(R.id.bLoad);
        sharedData = (EditText) findViewById(R.id.etSharedPref);
        dataResults = (TextView)findViewById(R.id.tvLoadSharedPref);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
        try {
            fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bSave:
                String data = sharedData.getText().toString();
                try {
                    fos= openFileOutput(FILENAME, Context.MODE_PRIVATE);
                    fos.write(data.getBytes());
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.bLoad:
                new loadSomeStuff().execute(FILENAME);
                break;
        }
    }

    private class loadSomeStuff extends AsyncTask<String, Integer, String>{

        ProgressDialog dialog;
        String collected = "blank";
        FileInputStream fis = null;

        protected void onPreExecute(){
            dialog = new ProgressDialog(InternalData.this);
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setMax(100);
            dialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            for (int i=0; i<20; i++){
                publishProgress(5);
                try{
                    Thread.sleep(88);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            dialog.dismiss();

            try {
                fis = openFileInput(FILENAME);
                byte[] dataArray = new byte[fis.available()];
                while (fis.read(dataArray) != -1){
                    collected = new String(dataArray);
                }
                fis.close();
                return collected;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onProgressUpdated(Integer...progress){
            dialog.incrementProgressBy(progress[0]);
        }

        @Override
        protected void onPostExecute(String result){
            dataResults.setText(result);
        }
    }
}
