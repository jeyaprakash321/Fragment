package com.example.demofragment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentActionListener {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    String message = "TAG";

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

    private void addContriesDescriptionFragment(Bundle bundle){
        fragmentTransaction = fragmentManager.beginTransaction();
        CountryDescriptionFragment countryDescriptionFragment = new CountryDescriptionFragment();


        countryDescriptionFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.fragmentContainer,countryDescriptionFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onActionPerformed(Bundle bundle) {

        int actionPeformed = bundle.getInt(FragmentActionListener.ACTION_KEY);

        switch (actionPeformed){
            case FragmentActionListener.ACTION_VALUE_COUNTRY_SELECTED :
                addContriesDescriptionFragment(bundle);
                break;
        }

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){
            Log.d(message,"Its Landscape mode");
        }else if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT){
            Log.d(message,"Its Portrait mode");
        }
    }
}
