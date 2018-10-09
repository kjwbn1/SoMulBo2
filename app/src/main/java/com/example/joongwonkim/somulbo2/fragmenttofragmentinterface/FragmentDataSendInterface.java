package com.example.joongwonkim.somulbo2.fragmenttofragmentinterface;

import com.example.joongwonkim.somulbo2.data.Time;

public interface FragmentDataSendInterface {


    public void transferTab();

    void myStartTimeStart(String selectedHour, String selectedMin);

    void myStartTimeEnd(String selectedHour, String selectedMin);
}
