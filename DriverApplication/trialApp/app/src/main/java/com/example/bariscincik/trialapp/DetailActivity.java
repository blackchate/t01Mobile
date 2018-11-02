package com.example.bariscincik.trialapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //fetch resources
        Resources res = getResources();
        String driverName = res.getString(R.string.driverName);
        String carDesc = res.getString(R.string.carDesc);
        String[] origins  = res.getStringArray(R.array.origins);
        String[] destinations  = res.getStringArray(R.array.destinations);
        String[] availableSeats  = res.getStringArray(R.array.availableSeats);
        String[] stopsList  = res.getStringArray(R.array.stops);

        //what got you here was an intent. Grab it
        Intent in = getIntent();
        //fetch the extra info(index of cell clicked)
        int index = in.getIntExtra("INDEX",-1);



        //use index to fetch the right info
        String origin = origins[index];
        String destination = destinations[index];
        String seats = availableSeats[index];
        String stops = stopsList[index];
        Log.d("myTag", stops);


        driverName = driverName;
        carDesc = carDesc;
        int driverPic = getImg(0);

        //get the text views from the activity
        TextView originView = (TextView) findViewById(R.id.origin);
        TextView destinationView = (TextView) findViewById(R.id.destination);
         TextView seatsView = (TextView) findViewById(R.id.seats);
        TextView stopsView = (TextView) findViewById(R.id.stops);
        TextView driverNameView = (TextView) findViewById(R.id.driverName);
        TextView carDescView = (TextView) findViewById(R.id.carDesc);
        ImageView img = (ImageView) findViewById(R.id.driverImage);

        //set the text views
        originView.setText(origin);
        destinationView.setText(destination);
        seatsView.setText(seats);
        stopsView.setText(stops);
        driverNameView.setText(driverName);
        carDescView.setText(carDesc);


    //    trialText.setText(stops[index]);

        scaleImg(img,driverPic);



        //deal with the edit button
        Button editBtn = (Button) findViewById(R.id.editButton);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editIntent = new Intent(getApplicationContext(), EditActivity.class);
                //pass the textViews to the other activity to edit
              //  editIntent.putExtra;
                startActivity(editIntent);


            }
        });

    }

    private int getImg(int index){
        switch (index) {
            case 0: return R.drawable.jason_statham;
            case 1: return R.drawable.black_audi;
            default: return -1;
        }
    }

    //shrinks the image pic to fit the image view img
    private void scaleImg(ImageView img,int pic){
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);

        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if(imgWidth > screenWidth){
            int ratio = Math.round((float)imgWidth / (float)screenWidth);
            options.inSampleSize = ratio;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaledImg);


    }

}
