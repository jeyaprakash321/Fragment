package com.example.demofragment1;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class CountryFragment extends Fragment {

    View rootView;
    ListView listViewCountries;
    ArrayAdapter<String> countryNameAdapter;
    Context context;
    String[] countries;

    FragmentActionListener fragmentActionListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_country, container, false);
        initUI();
        return rootView;

    }

    public void initUI(){
        context = getContext();
        countries = getResources().getStringArray(R.array.arrStrcountries);
        listViewCountries = (ListView) rootView.findViewById(R.id.idCountryListArr);

        countryNameAdapter = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,countries);
        listViewCountries.setAdapter(countryNameAdapter);

        listViewCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(fragmentActionListener != null) {
                    fragmentActionListener.onSelectedCountry(countries[position]);
                }
            }
        });

    }

    public void setFragmentActionListener(FragmentActionListener fragmentActionListener) {
        this.fragmentActionListener = fragmentActionListener;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Countries List");
    }
}
