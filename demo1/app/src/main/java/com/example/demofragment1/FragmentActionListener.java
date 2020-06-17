package com.example.demofragment1;

import android.os.Bundle;

public interface FragmentActionListener {

    String ACTION_KEY = "action_key";
    int ACTION_VALUE_COUNTRY_SELECTED = 1;

    String KEY_SELECTED_COUNTRY = "KEY_SELECTED_COUNTRY";

    public void onActionPerformed(Bundle bundle);
}
