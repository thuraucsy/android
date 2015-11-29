package com.example.thuraaung.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;

/**
 * Created by thuraaung on 11/26/15.
 */
public class Camera extends Activity implements View.OnClickListener{

    ImageButton ib;
    Button b;
    ImageView iv;
    Intent i;
    final static int cameraData = 0;
    Bitmap btp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);
        initialize();
    }

    private void initialize() {
        ib = (ImageButton) findViewById(R.id.ibTakePic);
        b = (Button) findViewById(R.id.bSetWall);
        iv = (ImageView) findViewById(R.id.ivReturnPic);
        b.setOnClickListener(this);
        ib.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bSetWall:
                try {
//                    we should no longer use this setWallpaper deprecated function
                    getApplicationContext().setWallpaper(btp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.ibTakePic:
                i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, cameraData);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            btp = (Bitmap) extras.get("data");
            iv.setImageBitmap(btp);
        }
    }
}
