package com.christian.meatfoodapp.ui.activities;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.christian.meatfoodapp.R;
import com.christian.meatfoodapp.ui.fragments.HomeFragment;
import com.christian.meatfoodapp.ui.fragments.ProductsFragment;
import com.christian.meatfoodapp.ui.fragments.ServicesFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                loadFragment(tabId);
            }
        });

        loadFragment(R.id.home_tab);
    }

    protected void loadFragment(int tabId) {

        Fragment fragment;
        switch (tabId) {
            case R.id.home_tab:
            default:
                fragment = new HomeFragment();
                break;
            case R.id.products_tab:
                fragment = new ProductsFragment();
                break;
            case R.id.services_tab:
                fragment = new ServicesFragment();
                break;
            case R.id.stores_tab:
                fragment = SupportMapFragment.newInstance();
                ((SupportMapFragment) fragment).getMapAsync(this);
                break;
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contentContainer, fragment, "tab_"+tabId)
                .commit();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(41.398626, 2.153080))
                .title(getString(R.string.store_gala)));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(41.402956, 2.174752))
                .title(getString(R.string.store_sagrada)));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(41.401322, 2.164366))
                .zoom(14)
                .build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}
