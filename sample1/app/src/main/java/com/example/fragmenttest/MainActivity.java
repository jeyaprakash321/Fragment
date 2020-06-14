package com.example.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static String message = "tag-1";
    private static String backStackEntru = "backstack";
    Button btnAddFragment;
    FragmentManager fragmentManager;
    FragmentTransaction frgTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(message,"Activity : onCreate");
        btnAddFragment = (Button) findViewById(R.id.btnAddFragment);
        final TextView txtFragmentCount = (TextView) findViewById(R.id.textviewCount);
        fragmentManager = getSupportFragmentManager();
        btnAddFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment();
            }
        });

        txtFragmentCount.setText(" current back stack count is "+fragmentManager.getBackStackEntryCount());

        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                txtFragmentCount.setText(" current back stack count is "+fragmentManager.getBackStackEntryCount());
                StringBuilder backStackEntryMsg = new StringBuilder("current status of back stack entry is "+fragmentManager.getBackStackEntryCount());
                for(int index=(fragmentManager.getBackStackEntryCount()-1);index>=0;index--){
                    FragmentManager.BackStackEntry entry = fragmentManager.getBackStackEntryAt(index);
                    backStackEntryMsg.append(entry.getName()+"\n");
                }

                Log.d(backStackEntru,backStackEntryMsg.toString());
            }
        });
     }

    private void addFragment(){
         /*  Fragment fragment;

        switch (fragmentManager.getBackStackEntryCount()){
            case 0:fragment = new SampleFragment();break;
            case 1:fragment = new firstFragment();break;
            case 2:fragment = new SecondFragment(); break;
            case 3 :fragment = new ThirdFragment(); break;
            default:fragment = new SampleFragment();break;
        }
         frgTransaction = fragmentManager.beginTransaction();
        frgTransaction.add(R.id.frameContainer,fragment,"demofragment");
        frgTransaction.addToBackStack(null);
        frgTransaction.commit();

         */

        Fragment fragment = fragmentManager.findFragmentById(R.id.frameContainer);

        if(fragment instanceof SampleFragment){
            fragment = new firstFragment();
        }else if(fragment instanceof firstFragment){
            fragment = new SecondFragment();
        }else if(fragment instanceof SecondFragment){
            fragment = new ThirdFragment();
        }else if(fragment instanceof ThirdFragment){
            fragment = new SampleFragment();
        }else{
            fragment=new SampleFragment();
        }

        frgTransaction = fragmentManager.beginTransaction();
        frgTransaction.replace(R.id.frameContainer,fragment);
        frgTransaction.addToBackStack("Replace "+fragment.toString());
        frgTransaction.commit();


    }

    @Override
    public void onBackPressed() {

        Fragment fragment = fragmentManager.findFragmentById(R.id.frameContainer);

        if(fragment != null){
            frgTransaction = fragmentManager.beginTransaction();
            frgTransaction.remove(fragment);
            frgTransaction.addToBackStack("Remove "+fragment.toString());
            frgTransaction.commit();
        }else{
            super.onBackPressed();
        }
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
