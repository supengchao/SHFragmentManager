package com.smallsoho.sohofragmentmanager;

import android.support.v4.app.Fragment;

/**
 * Created by longlong on 15-10-19.
 */
public class FragmentModel {

    private Fragment fragment;
    private String tag;

    public FragmentModel(Fragment fragment, String tag) {
        this.fragment = fragment;
        this.tag = tag;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
