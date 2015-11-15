package com.smallsoho.example;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.smallsoho.sohofragmentmanager.SohoFragmentManager;

public class MainActivity extends FragmentActivity {

    private FragmentOne one;
    private FragmentTwo two;
    private FragmentThree three;
    private SohoFragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init object,need a fragment manager and a container
        fragmentManager = new SohoFragmentManager(getSupportFragmentManager(), R.id.fragment_container);

        //the choose fragment be init
        one = new FragmentOne();
        two = new FragmentTwo();
        three = new FragmentThree();
        
//        fragmentManager.addFragment(one, "one");
//        fragmentManager.addFragment(two, "two");
//        fragmentManager.addFragment(three, "three");

        //set onClick
        findViewById(R.id.btn_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.replace("one");
            }
        });

        findViewById(R.id.btn_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.replace("two");
            }
        });

        findViewById(R.id.btn_three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.replace("three");
            }
        });
    }

}
