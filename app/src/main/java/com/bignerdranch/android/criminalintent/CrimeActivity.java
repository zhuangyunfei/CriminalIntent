package com.bignerdranch.android.criminalintent;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class CrimeActivity extends SingleFragmentActivity {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        //获取到FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        //找到要处理的Fragment
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
        //提交事务给FragmentManager
        if (fragment == null){
            fragment = new CrimeFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_container,fragment).commit();
        }

    }*/

    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }
}
