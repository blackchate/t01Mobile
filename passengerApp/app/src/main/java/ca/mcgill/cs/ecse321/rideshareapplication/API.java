package ca.mcgill.cs.ecse321.rideshareapplication;

import java.util.ArrayList;

import responses.Trip;
import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("trips")
    Call<ArrayList<Trip>> getTrips();
}
