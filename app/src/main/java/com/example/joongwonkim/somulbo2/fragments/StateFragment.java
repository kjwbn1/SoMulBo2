package com.example.joongwonkim.somulbo2.fragments;

import android.animation.LayoutTransition;


import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;


import android.support.design.widget.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TimePicker;

import com.dev.matt.rangetimepicker.TimeRangePicker;
import com.example.joongwonkim.somulbo2.R;
import com.example.joongwonkim.somulbo2.adapter.TabPageAdapter;
import com.example.joongwonkim.somulbo2.data.Time;
import com.example.joongwonkim.somulbo2.fragmenttofragmentinterface.FragmentDataSendInterface;
import com.example.joongwonkim.somulbo2.view.CalendarPickerView;
import com.example.joongwonkim.somulbo2.view.NmapActivity;

import java.security.PrivateKey;


import static android.app.Activity.RESULT_OK;

public class StateFragment extends Fragment {






    public static final String TAG = StateFragment.class.getSimpleName();

    private static final int TAKE_TO_PRAYGRROUND_RESULT = 0;
    private static final int TAKE_TO_DAY_START = 1;
    private static final int TAKE_TO_TIME_START = 2;
    private static final int TAKE_TO_TIME_END = 3;


    private FrameLayout calendarFrame;
    private FrameLayout timeFrame;
    private Button searchGround;
    public  Button dayStart;
    private Button timeStart;
    private Button timeEnd;
    private Button gameSelect;
    private ImageView game1;
    private ImageView game2;
    private Button gameSelectComplete;
    TimePicker timePickerS;
    TimePicker timePickerE;

    String mapDataTemp;
    Context context;

    private ViewPager viewPager;
    private TabLayout tabLayout;

    private SharedPreferences mSharedPreferences;
    SharedPreferences.Editor editor;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_state,container,false);
        context = getActivity();

        initSharedPreferences();
        initViews(view);
        TabViewSetting();
        initClickButton();


        return view;
    }

    private void TabViewSetting() {
        tabLayout.addTab(tabLayout.newTab().setText("시작시간"));
        tabLayout.addTab(tabLayout.newTab().setText("종료시간"));
        tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);

        TabPageAdapter tabPageAdapter = new TabPageAdapter(getFragmentManager() , tabLayout.getTabCount());
        viewPager.setAdapter(tabPageAdapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




    }

    private void initClickButton() {
        searchGround.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NmapActivity.class);
                startActivityForResult(intent , TAKE_TO_PRAYGRROUND_RESULT);
            }

        });

        dayStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction().addToBackStack("aa");
                CalendarFragment cf = new CalendarFragment();
                ft.replace(R.id.calendar_frame, cf, "cf");
                ft.commit();
                calendarFrame.setVisibility(View.VISIBLE);
            }
        });

        timeStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                tabLayout.setVisibility(View.VISIBLE);
                viewPager.setVisibility(View.VISIBLE);
            }
        });

        gameSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game1.setVisibility(View.VISIBLE);
                game2.setVisibility(View.VISIBLE);
            }
        });
    }

    private void initSharedPreferences() {

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = mSharedPreferences.edit();
    }

    public void setDate(String date){

        dayStart.setText(date);
        calendarFrame.setVisibility(View.GONE);
    };

    public void setTime(Time time){
        timeStart.setText(time.getHour() + "시" + time.getMin() + "분" + "에서" + time.getHourE() + "시" + time.getMinE() +"분");
        tabLayout.setVisibility(View.GONE);
        viewPager.setVisibility(View.GONE);

    }

    public void transTab(){
        tabLayout.getTabAt(1).select();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if(requestCode == TAKE_TO_PRAYGRROUND_RESULT) {
                if (data.hasExtra("address")) {
                    mapDataTemp = data.getStringExtra("address");
                    searchGround.setText(mapDataTemp);

                    editor.putString("position" , mapDataTemp);
                    editor.apply();


                }
            }

            if(requestCode == TAKE_TO_DAY_START) {
                mapDataTemp = data.getStringExtra("daystart");
                dayStart.setText(mapDataTemp);

                editor.putString("daystart" , mapDataTemp);
                editor.apply();

            }


            if(requestCode == TAKE_TO_TIME_START) {
                mapDataTemp = data.getStringExtra("timestart");
                timeStart.setText(mapDataTemp);
            }

            if(requestCode == TAKE_TO_TIME_END) {
                mapDataTemp = data.getStringExtra("timeend");
                timeStart.setText(mapDataTemp);
            }
        }
    }


    public void initViews(View v) {
        searchGround = (Button) v.findViewById(R.id.btn_search);
        dayStart = (Button) v.findViewById(R.id.btn_day);
        timeStart = (Button) v.findViewById(R.id.btn_time_s);
        gameSelect = (Button) v.findViewById(R.id.btn_game_select);
        game1 = (ImageView) v.findViewById(R.id.btn_game1);
        game2 = (ImageView) v.findViewById(R.id.btn_game2);
        gameSelectComplete = (Button) v.findViewById(R.id.btn_select_complete);
        calendarFrame = (FrameLayout) v.findViewById(R.id.calendar_frame);
        timePickerS = (TimePicker) v.findViewById(R.id.timepicker_start);
        timePickerE = (TimePicker) v.findViewById(R.id.timepicker_end);
        viewPager = (ViewPager) v.findViewById(R.id.viewpager);
        tabLayout = (TabLayout) v.findViewById(R.id.tablayout);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    //    private void setMargins (View view, int left, int top, int right, int bottom, int start ,int end) {
//        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
//            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
//            p.setMargins(left, top, right, bottom);
//            p.setMarginStart(start);
//            p.setMarginEnd(end);
//
//            view.requestLayout();
//        }
//    }

}
