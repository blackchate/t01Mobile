package com.example.bariscincik.trialapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);


        TextView stopsPrompt = (TextView) findViewById(R.id.stopsPrompt);
        stopsPrompt.setText("Please enter the stops seperated by a coma in the following format: Laval $30, Montreal $50, Ottawa 70$");


        Button doneBtn = (Button) findViewById(R.id.doneBtn);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(getApplicationContext(), DetailActivity.class);
                //pass the textViews to the other activity to edit
                //  editIntent.putExtra;
                startActivity(backIntent);


            }
        });

    }
}
