package com.example.bariscincik.trialapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    //declare your list view globally
    ListView myListView;

//    String[] items;  //will store the item names
//    String[] prices;  //will store the prices
//    String[] descriptions;  //will store the descriptions

    String[] origins;  //will store the item names
    String[] destinations;  //will store the prices
    String[] seats;  //will store the descriptions



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        //fetch the resources you have put in the values xml
        Resources res = getResources();
        //initiate your list view
        myListView = (ListView) findViewById(R.id.myListView);
        //fetch the properties from the resources
        origins = res.getStringArray(R.array.origins);
        destinations = res.getStringArray(R.array.destinations);
        seats = res.getStringArray(R.array.availableSeats);

//        items = res.getStringArray(R.array.items);
//        prices = res.getStringArray(R.array.prices);
//        descriptions = res.getStringArray(R.array.descriptions);



        //right now your table view has no datasource. Lets adopt a datasource
        //everything about the list view will be specified in the data source
        //ex: number of rows,height,cell configuration etc




        //same way, itemAdaptor class we just created adapts items as source
        ItemAdaptor itemAdaptor = new ItemAdaptor(this,origins,this.destinations,this.seats);
        //set adopter (source)
        myListView.setAdapter(itemAdaptor);

        //what to do when a cell is clicked
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override //define what to do when cell "position" is clicked
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //make a new intent that is connected to DetailActivity class
                Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity.class);
                //add extra info to the intent(index of cell clicked)
                showDetailActivity.putExtra("INDEX", position);
                //execute the intent
                startActivity(showDetailActivity);

            }
        });






//        //this array adopter will use "items as its source"
//        ArrayAdapter arrayAdopter = new ArrayAdapter<String>(this, R.layout.my_listview_detail, items );
//        //set the array adaptor of your listview to the one you just created
//        myListView.setAdapter(arrayAdopter);




    }
}
