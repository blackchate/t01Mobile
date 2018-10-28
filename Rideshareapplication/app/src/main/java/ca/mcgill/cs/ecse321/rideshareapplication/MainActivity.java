package ca.mcgill.cs.ecse321.rideshareapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new BrowseTripsFragment()).commit(); // opens browse_trips fragment first
        bottomNav.getMenu().getItem(1).setChecked(true); // on startup, Browse Trips is selected
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) { // item that was selected
                    Fragment selectedFragment = null; // fragment that we want to open

                    switch(menuItem.getItemId()) {
                        case R.id.nav_browse_trips:
                            selectedFragment = new BrowseTripsFragment();
                            break;
                        case R.id.nav_booked_trip:
                            selectedFragment = new BookedTripFragment();
                            break;
                        case R.id.nav_history:
                            selectedFragment = new HistoryFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                    return true; // when we return the fragment, nav item showing the fragment is selected as well
                }
            };
}
