package com.example.demofragment1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CountryDescriptionFragment extends Fragment {

    View rootView;

    public CountryDescriptionFragment() {
        // Required empty public constructor
    }

    TextView textDescription;
    String countryDescription;
    String countryName;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_country_description, container, false);
        initUI();
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(countryName);
        textDescription.setText(countryDescription);
    }

    private void initUI(){
        textDescription = rootView.findViewById(R.id.idTextDescription);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        countryName = bundle.getString(FragmentActionListener.KEY_SELECTED_COUNTRY,"India");
        countryDescription = getStringId(countryName);
    }

    private String getStringId(String countryname){

        if(countryname.equals("India")){
            return getString(R.string.India);
        }else if(countryname.equals("USA")){
            return "Its is a USA";
        }else{
            return "India hai";
        }
    }


}
