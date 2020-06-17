package com.example.demofragment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentActionListener {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        addCountriesFragment();
    }

    private void addCountriesFragment(){
        fragmentTransaction = fragmentManager.beginTransaction();
        CountryFragment countryListFragment = new CountryFragment();
        countryListFragment.setFragmentActionListener(this);

        fragmentTransaction.add(R.id.fragmentContainer,countryListFragment);
        fragmentTransaction.commit();

    }

    private void addContriesDescriptionFragment(String countryname){
        fragmentTransaction = fragmentManager.beginTransaction();
        CountryDescriptionFragment countryDescriptionFragment = new CountryDescriptionFragment();

        Bundle bundle = new Bundle();
        bundle.putString(FragmentActionListener.KEY_SELECTED_COUNTRY,countryname);
        countryDescriptionFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.fragmentContainer,countryDescriptionFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onSelectedCountry(String countryname) {
        addContriesDescriptionFragment(countryname);
    }
}
