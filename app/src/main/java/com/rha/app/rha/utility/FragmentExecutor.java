package com.rha.app.rha.utility;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by Ashish Saini on 04-Apr-18.
 */

public class FragmentExecutor {

    public static void addFragment(FragmentManager manager, int containerId, Fragment fragment, String tag, boolean isBackStack) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(containerId, fragment, tag);
        if (isBackStack)
            transaction.addToBackStack(tag);
        transaction.commit();
    }

    public static void removeFragment(FragmentManager manager, Fragment fragment) {
        manager.beginTransaction().remove(fragment);
    }
}
