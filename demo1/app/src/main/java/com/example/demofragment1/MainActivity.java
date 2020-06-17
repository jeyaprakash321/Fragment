package com.example.demofragment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CallBackInterface {

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
        countryListFragment.setCallBackInterface(this);

        fragmentTransaction.add(R.id.fragmentContainer,countryListFragment);
        fragmentTransaction.commit();

    }

    private void addContriesDescriptionFragment(){
        fragmentTransaction = fragmentManager.beginTransaction();
        CountryDescriptionFragment countryDescriptionFragment = new CountryDescriptionFragment();

        fragmentTransaction.replace(R.id.fragmentContainer,countryDescriptionFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void callBackMethod() {
        //Toast.makeText(this,"Trigger other fragment",Toast.LENGTH_SHORT).show();
        addContriesDescriptionFragment();
    }
}
