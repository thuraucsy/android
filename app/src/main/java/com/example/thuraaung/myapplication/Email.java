package com.example.thuraaung.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by thuraaung on 11/26/15.
 */
public class Email extends Activity implements View.OnClickListener{

    EditText email, hatefulIntro, personName, stupidThings, hatefulAction, outro;
    String sEmail, sHatefulIntro, sPersonName, sStupidThings, sHatefulAction, sOutro;
    Button sendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);
        initializeVar();
        sendEmail.setOnClickListener(this);
    }

    private void initializeVar() {
        email = (EditText) findViewById(R.id.etEmail);
        hatefulIntro = (EditText) findViewById(R.id.etHatefulIntro);
        personName = (EditText) findViewById(R.id.etName);
        stupidThings = (EditText) findViewById(R.id.etStupidThings);
        hatefulAction = (EditText) findViewById(R.id.etWantToDo);
        outro = (EditText) findViewById(R.id.etHatefulOutro);

        sendEmail = (Button) findViewById(R.id.bEmail);
    }

    @Override
    public void onClick(View view) {
        convertEditTextToString();
        String emailAddresses[] = { sEmail };
        String message = "Well hello"
                        + sPersonName
                        + " I just want to say "
                        + sHatefulIntro
                        + ". Not only but I hate when you"
                        + sStupidThings
                        + ", that just really makes me crazy. I just want to make you"
                        + sHatefulAction
                        +". Welt, that's all I wanted to chit-chatter"
                        + sOutro
                        + ". Oh, also if you get bored you should checked out my wall"
                        + "\n　PS. I think I love you :) ";

        String[] CC = {"thura.ucsy@hotmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, emailAddresses);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "I hate you!");
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email...", "");
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Email.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }

    }

    private void convertEditTextToString() {
        sEmail = email.getText().toString();
        sHatefulIntro = hatefulIntro.getText().toString();
        sPersonName = personName.getText().toString();
        sStupidThings = stupidThings.getText().toString();
        sHatefulAction = hatefulAction.getText().toString();
        sOutro = outro.getText().toString();
    }
}
