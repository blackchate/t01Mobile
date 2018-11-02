package ca.mcgill.cs.ecse321.rideshareapplication;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import responses.Trip;

public class BrowseTripsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Resources res = getResources();

        Controller tripsController = new Controller();
        tripsController.start();

        ArrayList<Trip> trips = tripsController.getTrips();

//        if(trips.isEmpty()) {
//            Log.d("empty", "empty");
//        } else {
//            Log.d("not empty", "empty");
//        }

        //Log.d("sss", Arrays.toString(tripsController.getTrips().toArray()));

        //Log.d("ssss", tripsController.getTrips().get(0).getPickUpLocation());

//        for(Trip trip : tripsController.getTrips()) {
//            Log.d("prettypleasework", trip.getPickUpLocation());
//            Log.d("prettypleasework", trip.getDestination());
//        }

        String[] sources = res.getStringArray(R.array.sources);
        String[] destinations = res.getStringArray(R.array.destinations);
        String[] prices = res.getStringArray(R.array.prices);

//        String[] sources = {trips.get(0).getPickUpLocation()};
//        String[] destinations = {trips.get(0).getDestination()};
//        String[] prices = res.getStringArray(R.array.prices);

        View view = inflater.inflate(R.layout.fragment_browse_trips, container, false);
        ListView myListView = (ListView) view.findViewById(R.id.myListView);

        //myListView.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.browse_trip_textview, sources));

        ItemAdapter itemAdapter = new ItemAdapter(getActivity(), sources, destinations, prices);
        myListView.setAdapter(itemAdapter);

        return view;
    }
}
