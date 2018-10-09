package com.example.joongwonkim.somulbo2.timeFragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;

import com.example.joongwonkim.somulbo2.R;
import com.example.joongwonkim.somulbo2.data.Time;
import com.example.joongwonkim.somulbo2.fragmenttofragmentinterface.FragmentDataSendInterface;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimeEndFragment extends Fragment {

    TimePicker timePicker;
    FragmentDataSendInterface mListener;
    Button buttonTimeEnd;
    String selectedHoure;
    String selectedMine;

    public TimeEndFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_time_end, container, false);

        timePicker = (TimePicker)view.findViewById(R.id.timepicker_end);

        selectedHoure = timePicker.getCurrentHour().toString();
        selectedMine = timePicker.getCurrentMinute().toString();



        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                Integer aaa = hourOfDay;

                selectedHoure = aaa.toString();

            }
        });
        buttonTimeEnd = view.findViewById(R.id.btn_time_end);



        buttonTimeEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedHoure = timePicker.getCurrentHour().toString();
                selectedMine = timePicker.getCurrentMinute().toString();


                mListener.myStartTimeEnd(selectedHoure , selectedMine);

            }
        });

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


        mListener  = (FragmentDataSendInterface)context;



    }

}
