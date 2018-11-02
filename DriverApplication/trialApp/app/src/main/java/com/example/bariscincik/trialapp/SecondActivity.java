package com.example.bariscincik.trialapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //if the current intent was passed extra info and it has the specified key
        if(getIntent().hasExtra("key1")){
            TextView tv = (TextView) findViewById(R.id.textView);
            //fetch the value from the extra infos of the intent
            String someText = getIntent().getExtras().getString("key1");
            //set it to the textView
            tv.setText(someText);
        }


    }
}
