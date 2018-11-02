package ca.mcgill.cs.ecse321.rideshareapplication;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import responses.Trip;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller implements Callback<ArrayList<Trip>> {

    static final String BASE_URL = "https://shrouded-fjord-72003.herokuapp.com/";
    public static ArrayList<Trip> trips;

    public ArrayList<Trip> getTrips() {
        return trips;
    }

    public void setTrips(ArrayList<Trip> trips) {
        this.trips = trips;
    }

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        API tripsAPI = retrofit.create(API.class);

        Call<ArrayList<Trip>> call = tripsAPI.getTrips();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ArrayList<Trip>> call, Response<ArrayList<Trip>> response) {
        ArrayList<Trip> tripsArrayList;
        if(response.isSuccessful()) {
            tripsArrayList = response.body();

            trips = tripsArrayList;

//            Log.d("Testsss", "test");
//            for(Trip trip : tripsArrayList) {
//                Log.d("insidebrowse", trip.getPickUpLocation());
//                Log.d("insidebrowse", trip.getDestination());
//            }
        } else {
            // do nothing
        }
    }

    @Override
    public void onFailure(Call<ArrayList<Trip>> call, Throwable t) {
        t.printStackTrace();
    }
}
