package com.example.fragmenttest;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class SampleFragment extends Fragment {

    private static String message = "tag-2";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(message,"Fragment : onCreateView");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sample, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(message,"Fragment : onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(message,"Fragment : onCreate");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(message,"Fragment : onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(message,"Fragment : onStart");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(message,"Fragment : onPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(message,"Fragment : onPause");
    }


    @Override
    public void onStop() {
        super.onStop();
        Log.d(message,"Fragment : onStop");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(message,"Fragment : onDetach");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(message,"Fragment : onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(message,"Fragment : onDestroy");
    }
}
