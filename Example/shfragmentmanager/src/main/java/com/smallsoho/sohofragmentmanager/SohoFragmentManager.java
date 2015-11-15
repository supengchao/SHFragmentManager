package com.smallsoho.sohofragmentmanager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by longlong on 15-10-17.
 */
public class SohoFragmentManager {

    private FragmentManager manager;
    private int container;
    private ArrayList<FragmentModel> list;

    public SohoFragmentManager(FragmentManager manager, int container) {
        this.manager = manager;
        this.container = container;
        list = new ArrayList<>();
    }

    public void choose(String tag) {
        Log.d("chenlongbo", tag);
        showFragment(tag);
    }

    public void choose(Fragment fragment) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getFragment().equals(fragment)) {
                showFragment(fragment);
                return;
            }
        }
        list.add(new FragmentModel(fragment, String.valueOf(list.size())));
        showFragment(fragment);
    }

    //Add a fragment to my list
    public void addFragment(Fragment fragment, String tag) {

        int index = getFragment(fragment);

        if (index == -1) {
            list.add(new FragmentModel(fragment, tag));
        }

    }

    //Remove a fragment from my list
    public void removeFragment(Fragment fragment) {

        int index = getFragment(fragment);
        if (index != -1) {
            list.remove(index);
            if (manager.findFragmentByTag(list.get(index).getTag()) != null) {
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.remove(fragment);
                transaction.commitAllowingStateLoss();
            }
        }

    }

    public void removeFragment(String tag) {

        int index;
        index = getFragment(tag);
        if (index != -1) {
            list.remove(index);
            if (manager.findFragmentByTag(tag) != null) {
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.remove(manager.findFragmentByTag(tag));
                transaction.commitAllowingStateLoss();
            }
        }

    }

    //Like the usual replace
    public void replace(Fragment fragment, String tag) {
        if (getFragment(tag) == -1) {
            list.add(new FragmentModel(fragment, tag));
        }
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment, tag);
        transaction.commitAllowingStateLoss();
    }

    public void replace(String tag) {
        int index = getFragment(tag);
        if (index != -1) {
            replace(list.get(index).getFragment());
        }
    }

    public void replace(Fragment fragment) {
        int i = getFragment(fragment);
        FragmentTransaction transaction = manager.beginTransaction();
        if (i != -1) {
            transaction.replace(container, fragment, list.get(i).getTag());
        } else {
            list.add(new FragmentModel(fragment, String.valueOf(list.size())));
            transaction.replace(container, fragment, String.valueOf(list.size() - 1));
        }
        transaction.commitAllowingStateLoss();
    }

    //destroy a object
    public void destroy() {
        container = -1;
        manager = null;
        list.clear();
    }

    //The private method
    private void showFragment(Fragment fragment) {
        for (int i = 0; i < list.size(); i++) {
            Log.d("chenlongbo", list.get(i).getTag() + "  ");
        }
        FragmentTransaction transaction = manager.beginTransaction();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getFragment().equals(fragment)) {
                if (manager.findFragmentByTag(list.get(i).getTag()) == null) {
                    transaction.add(container, list.get(i).getFragment(), list.get(i).getTag());
                } else {
                    transaction.show(list.get(i).getFragment());
                }
            } else {
                Log.d("chenlongbo", "hide");
                transaction.hide(list.get(i).getFragment());
            }
        }
        Log.d("chenlongbo", "提交");
        transaction.commitAllowingStateLoss();
    }

    private int getFragment(String tag) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTag().equals(tag)) {
                return i;
            }
        }
        return -1;
    }

    private int getFragment(Fragment fragment) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getFragment().equals(fragment)) {
                return i;
            }
        }
        return -1;
    }

    private void showFragment(String tag) {
        int index = getFragment(tag);
        Log.d("chenlongbo", index + "");
        if (index != -1) {
            showFragment(list.get(index).getFragment());
        }

    }

}
