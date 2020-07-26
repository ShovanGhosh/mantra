package com.app.shovan.myapplication;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.VibrationEffect;
import android.os.Vibrator;

public class MainActivity extends AppCompatActivity {
    private int count =0;
    public int max;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get values from ditTextNumberSigned
        Button btn2=(Button) findViewById(R.id.butt);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText=(EditText) findViewById(R.id.editTextNumberSigned);
                max=Integer.parseInt(editText.getText().toString());
            }
        });//
        Button btn=(Button) findViewById(R.id.btnC);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;

                TextView textView = (TextView) findViewById(R.id.txtCount);
                if(count<=max) {
                    textView.setText("count is" + count);}
                    else if(count>max) {
                            textView.setText("count is complete");
                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                    } else {
                        vibrator.vibrate(500);
                    }

                            Intent intent;
                            intent = getIntent();
                            finish();
                             startActivity(intent);
                    }
                }


        });
    }
}





