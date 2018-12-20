package com.baway.wanghengyu20181217;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.baway.wanghengyu20181217.fragment.ShopCartFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ShopCartFragment shopCartFragment = new ShopCartFragment();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.beginTransaction().add(R.id.contentaa, shopCartFragment).commit();
    }
}
