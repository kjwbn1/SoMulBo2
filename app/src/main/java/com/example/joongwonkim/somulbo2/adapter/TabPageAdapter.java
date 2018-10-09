package com.example.joongwonkim.somulbo2.adapter;




import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.joongwonkim.somulbo2.fragmenttofragmentinterface.FragmentDataSendInterface;
import com.example.joongwonkim.somulbo2.timeFragment.TimeEndFragment;
import com.example.joongwonkim.somulbo2.timeFragment.TimeStartFragment;


public class TabPageAdapter extends FragmentStatePagerAdapter {

    private int tabCount;


    public TabPageAdapter(FragmentManager fm , int tabCount){
        super(fm);
        this.tabCount =  tabCount;


    }






    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                TimeStartFragment timeStartFragment = new TimeStartFragment();
                return timeStartFragment;
            case 1:
                TimeEndFragment timeEndFragment = new TimeEndFragment();
                return timeEndFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }



}
