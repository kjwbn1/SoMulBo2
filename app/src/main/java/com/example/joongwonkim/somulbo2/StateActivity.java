package com.example.joongwonkim.somulbo2;





import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;


import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.joongwonkim.somulbo2.data.Time;
import com.example.joongwonkim.somulbo2.dbconnection.DownLoadTask;
import com.example.joongwonkim.somulbo2.fragments.CalendarFragment;
import com.example.joongwonkim.somulbo2.fragments.ChangePasswordDialog;
import com.example.joongwonkim.somulbo2.fragments.ProfileFragment;
import com.example.joongwonkim.somulbo2.fragments.StateFragment;
import com.example.joongwonkim.somulbo2.fragmenttofragmentinterface.FragmentDataSendInterface;
import com.example.joongwonkim.somulbo2.helper.BottomNavigationViewHelper;
import com.example.joongwonkim.somulbo2.view.CalendarPickerView;


public class StateActivity extends AppCompatActivity implements ChangePasswordDialog.Listener , CalendarFragment.onSetDateListener , FragmentDataSendInterface {

    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    TextView checkInTextS;
    TextView checkInTextE;
    BottomNavigationView bottomNavigationView;
    Button selectedLuggage;
    Toolbar toolbar;
    boolean a;
    boolean b;
    boolean c;
    boolean d;
    StateFragment stateFragment;
    ProfileFragment profileFragment;

    String temp;


    Time timeS;
    Time timeE;

    Time time;


    private static Boolean isClicked = false;

    int requestCode = 0;

    private static final int TAKE_TO_SELECTED_LUGGAGE = 1;
    private static final int TAKE_TO_CALENDARVIEW_RESULT = 0;
    private static final int TAKE_TO_PRAYGRROUND_RESULT = 0;
//    private int dotscount;
//    private ImageView[] dots;

    ProfileFragment mProfileFragment;
    DownLoadTask downLoadTask;

    private static long sayBackPress;

    public static final String TAG = StateActivity.class.getSimpleName();

    View contact;
    View home;
    View more;
    View search;
    Button playGround;
    Bundle bundle;
    StateFragment sf;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_state_setting);
        contact = findViewById(R.id.action_contact);
        home = findViewById(R.id.action_home);
        search = findViewById(R.id.action_search);
        more = findViewById(R.id.action_more);


        time = new Time();





        LoadFragmentState();
        initView();












//        DateConnection dateConnection = new DateConnection();




//        setListener();

//        MapViewFragmentNaver mapViewFragmentNaver = new MapViewFragmentNaver();
//
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//
//        transaction.replace(R.id.fragment_container,mapViewFragmentNaver);
//        transaction.addToBackStack(null);
//        transaction.commit();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){

                    case R.id.action_contact:

                        loadFragmentProfile();

                        a = true;
                        b = false;
                        c = false;
                        d = false;

                        if(a){
                            contact.setClickable(false);
                            home.setClickable(true);
                            search.setClickable(true);
                            more.setClickable(true);

                        } else {
                            contact.setClickable(true);
                        }

                        return true;

                    case R.id.action_home:

                        LoadFragmentState();


                        a = false;
                        b = true;
                        c = false;
                        d = false;

                        if(b){
                            contact.setClickable(true);
                            home.setClickable(false);
                            search.setClickable(true);
                            more.setClickable(true);

                        } else {
                            home.setClickable(true);
                        }


                        return true;

                    case R.id.action_search:

                        a = false;
                        b = false;
                        c = true;
                        d = false;

                        if(c){

                            contact.setClickable(true);
                            home.setClickable(true);
                            search.setClickable(false);
                            more.setClickable(true);

                        } else {
                            search.setClickable(true);
                        }

                        return true;



                    case R.id.action_more:

                        a = false;
                        b = false;
                        c = false;
                        d = true;

                        if(d){
                            contact.setClickable(true);
                            home.setClickable(true);
                            search.setClickable(true);
                            more.setClickable(false);
                        } else {
                            contact.setClickable(true);
                        }

                        return true;

                }
                return false;
            }
        });
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);



    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if(requestCode == TAKE_TO_PRAYGRROUND_RESULT) {
                if (data.hasExtra("address")) {
                    temp = data.getStringExtra("address");
                    bundle = new Bundle();
                    bundle.putString("address", temp);
                    LoadFragmentState();
                }
            }
        }
    }



    private void LoadFragmentState() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        stateFragment = new StateFragment();
        stateFragment.setArguments(bundle);
        ft.replace(R.id.fragmentFrame, stateFragment , StateFragment.TAG);
        ft.commit();
    }



    private void loadFragmentProfile() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        profileFragment = new ProfileFragment();
        ft.replace(R.id.fragmentFrame,profileFragment,mProfileFragment.TAG);
        ft.commit();

    }



    private void showSnackBarMessage(String message) {

        Snackbar.make(findViewById(R.id.activity_profile),message,Snackbar.LENGTH_SHORT).show();

    }





    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        bottomNavigationView.setSelectedItemId(R.id.action_home);


    }

//    private void setListener() {
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//                for(int i = 0; i< dotscount; i++){
//                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
//                }
//
//                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//
//    }

    private void initView() {

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_home);

        //        viewPager = (ViewPager) findViewById(R.id.viewPager);
//        sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);
//        checkInTextS = (TextView) findViewById(R.id.check_in_text_s);
//        checkInTextE = (TextView) findViewById(R.id.check_in_text_e);
//
//        selectedLuggage = (Button) findViewById(R.id.luggage_select_button);
//        setAdapter();





    }


//    private void setAdapter() {
//        AdViewPagerAdapter viewPagerAdapter = new AdViewPagerAdapter(this);
//        viewPager.setAdapter(viewPagerAdapter);
//        dotscount = viewPagerAdapter.getCount();
//        dotsCreate();
//    }

//    private void dotsCreate() {
//        dots = new ImageView[dotscount];
//
//        for(int i = 0; i < dotscount; i++){
//
//            dots[i] = new ImageView(this);
//            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
//
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
//
//            params.setMargins(8, 0 ,8, 0);
//
//            sliderDotspanel.addView(dots[i],params);
//        }
//
//        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
//
//
//    }



//
//
//    @Override
//    public void onBackPressed() {
//        if (sayBackPress + 2000 > System.currentTimeMillis()){
//            super.onBackPressed();
//        }
//        else{
//            Toast.makeText(StateActivity.this, "Press once again to exit!", Toast.LENGTH_SHORT).show();
//            sayBackPress = System.currentTimeMillis();
//        }
//    }

    @Override
    public void onPasswordChanged() {
        showSnackBarMessage("Password Changed Successfully !");

    }

    @Override
    public void setDate() {


    }

    @Override
    public void setDate(String ss) {
        StateFragment sf = (StateFragment)getSupportFragmentManager().findFragmentByTag(StateFragment.TAG);
        sf.setDate(ss);

    }


    @Override
    public void transferTab() {

        StateFragment sf = (StateFragment)getSupportFragmentManager().findFragmentByTag(StateFragment.TAG);
        sf.transTab();

    }

    @Override
    public void myStartTimeStart(String selectedHour, String selectedMin) {

        time.setHour(selectedHour);
        time.setMin(selectedMin);

    }

    @Override
    public void myStartTimeEnd(String selectedHour, String selectedMin) {


        time.setHoure(selectedHour);
        time.setMine(selectedMin);
        StateFragment sf = (StateFragment)getSupportFragmentManager().findFragmentByTag(StateFragment.TAG);
        sf.setTime(time);

    }

}


