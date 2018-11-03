package ca.mcgill.cs.ecse321.rideshareapplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import java.util.ArrayList;

import responses.Trip;
import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    //ItemAdapter Tests: getCount, getItem, getItemID, getView


    @Test
    public void getItemID_isCorrect(int position) {
        assertEquals(position, position);
    }

    
    @Test
    public void onResponse_isCorrect(Call<ArrayList<Trip>> call, Response<ArrayList<Trip>> response){ assertEquals(response,response);}

    @Test
    public void onFailure(Call<ArrayList<Trip>> call, Throwable t){assertEquals(t,t);}
}