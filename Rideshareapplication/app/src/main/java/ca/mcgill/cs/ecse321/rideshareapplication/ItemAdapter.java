package ca.mcgill.cs.ecse321.rideshareapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {

    String[] sources;
    String[] destinations;
    String[] prices;
    LayoutInflater mInflater;

    public ItemAdapter(Context c, String[] src, String[] dest, String[] p) {
        sources = src;
        destinations = dest;
        prices = p;
        mInflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return sources.length;
    }

    @Override
    public Object getItem(int position) {
        return sources[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        RecyclerView.ViewHolder holder;
        convertView = mInflater.inflate(R.layout.browse_trips_listview, null);

        TextView srcTextView = (TextView)convertView.findViewById(R.id.sourceTextView);
        TextView destTextView = (TextView)convertView.findViewById(R.id.destinationTextView);
        TextView priceTextView = (TextView)convertView.findViewById(R.id.priceTextView);

        String source = sources[position];
        String destination = destinations[position];
        String price = prices[position];

        srcTextView.setText(source);
        destTextView.setText(destination);
        priceTextView.setText(price);

        return convertView;
    }
}
