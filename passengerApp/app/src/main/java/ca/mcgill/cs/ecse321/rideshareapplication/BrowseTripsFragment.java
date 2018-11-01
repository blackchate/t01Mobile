package ca.mcgill.cs.ecse321.rideshareapplication;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BrowseTripsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Resources res = getResources();

        String[] sources;
        String[] destinations;
        String[] prices;

        sources = res.getStringArray(R.array.sources);
        destinations = res.getStringArray(R.array.destinations);
        prices = res.getStringArray(R.array.prices);

        View view = inflater.inflate(R.layout.fragment_browse_trips, container, false);
        ListView myListView = (ListView) view.findViewById(R.id.myListView);

        //myListView.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.browse_trip_textview, sources));

        ItemAdapter itemAdapter = new ItemAdapter(getActivity(), sources, destinations, prices);
        myListView.setAdapter(itemAdapter);

        return view;
    }
}
