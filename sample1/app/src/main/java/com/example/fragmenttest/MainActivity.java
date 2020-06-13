package com.example.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static String message = "tag-1";
    Button btnAddFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(message,"Activity : onCreate");
        btnAddFragment = (Button) findViewById(R.id.btnAddFragment);
        btnAddFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment();
            }
        });
     }

    private void addFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction frgTransaction = fragmentManager.beginTransaction();
        SampleFragment sampleFragment = new SampleFragment();
        frgTransaction.add(R.id.frameContainer,sampleFragment);
        frgTransaction.commit();
    }




    @Override
    protected void onStart() {
        super.onStart();
        Log.d(message,"Activity : onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(message,"Activity : onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(message,"Activity : onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(message,"Activity : onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(message,"Activity : onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(message,"Activity : onDestroy");
    }
}
