package com.example.bariscincik.trialapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

//this is the table view class! Specify everything about the table view here
public class ItemAdaptor extends BaseAdapter {


    LayoutInflater mInflator;  //inflate means fill. So this is a layout filler(injects the cell)
//    String[] items;  //will store the item names
//    String[] prices;  //will store the prices
//    String[] descriptions;  //will store the descriptions

    String[] origins;
    String[] destinations;
    String[] seats;


    //constructor
    public ItemAdaptor(Context c, String[] o, String[] d, String[] s){
        //initialize the arrays
//        items = o;
//        prices = d;
//        descriptions = s;

        origins = o;
        destinations = d;
        seats = s;

        mInflator = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {  //number of rows
        return origins.length;
    }

    @Override
    public Object getItem(int position) {
        return origins[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override//this is the cellForRowAt. You should get the cell from my_listview_detail
    public View getView(int position, View convertView, ViewGroup parent) {

        //fill a new view(using your inflator) with the layout(cell) you created
        View v = mInflator.inflate(R.layout.my_listview_detail,null);
        //fetch and store the elements from the filled view so that you can change them
        TextView originTextView = (TextView) v.findViewById(R.id.originTextView);
        TextView destinationTextView = (TextView) v.findViewById(R.id.destinationTextView);
        TextView seatsTextView = (TextView) v.findViewById(R.id.seatsTextView);

        String origin = origins[position];
        String destination = destinations[position];
        String seatsLeft = seats[position];

        originTextView.setText(origin);
        seatsTextView.setText(seatsLeft);
        destinationTextView.setText(destination);


        //return the view you have filled and set
        return v;
    }
}
