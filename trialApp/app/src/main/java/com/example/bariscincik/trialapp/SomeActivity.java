package com.example.bariscincik.trialapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_some);


        /*
         findViewById searches through your views
         R is your resources. R.id searches resources for an ID
         R.id.addBtn gives you the id(int) of the resource named addBtn
         (Button is just typecasting)
         */
        Button addBtn = (Button) findViewById(R.id.addBtn);


        addBtn.setOnClickListener(new View.OnClickListener() {  //gotta create a new OnClickClistener
            @Override
            public void onClick(View v) {
                //get the edit texts
                EditText firstNumEditText = (EditText) findViewById(R.id.editText);
                EditText secondNumEditText = (EditText) findViewById(R.id.editText2);
               // get the text view
                TextView resultTextView  = (TextView) findViewById(R.id.resultTextView);

                //read the values from the edit texts and add them
                int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                int num2 = Integer.parseInt(secondNumEditText.getText().toString());
                int result = num1 + num2;
                //display the result on text view
                resultTextView.setText(result + "");


            }
        });






    }
}
