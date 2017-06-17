package ru.virand.universityjournal;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TextView;

import static java.security.AccessController.getContext;

public class TimetableActivity2 extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ScrollView tt1Sv;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);




//(((LinearLayout)((LinearLayout)mTabLayout.getChildAt(0)).getChildAt(wantedTabIndex)).getChildAt(1));

    //    ViewPager vp = (ViewPager) findViewById(R.id.container);
     //   LinearLayout ll = (LinearLayout) vp.getChildAt(0);

        //fillScrollView(tt1Sv);


      //  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
      //  fab.setOnClickListener(new View.OnClickListener() {
      //      @Override
      //      public void onClick(View view) {


               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
               //         .setAction("Action", null).show();
       //     }
       // });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_timetable_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public static void fillScrollView(ScrollView sv){




        }

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);




            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = null;
            TextView textView;

            switch(getArguments().getInt(ARG_SECTION_NUMBER)){
                case 1:

                            /*
                <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="Понедельник"
                android:textSize="20dp"
                android:background="#3AF"/>

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="horizontal">


                <TextView
                    android:layout_width="0dp"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:text="8:20\n9:50"/>

                <TextView
                    android:layout_width="0dp"
                    android:layout_height="wrap_content"
                    android:layout_weight="4"
                    android:text="Методология программной инженерии"/>

            </LinearLayout>
         */

                    rootView = inflater.inflate(R.layout.tt_1, container, false);
                    ScrollView sv = (ScrollView) rootView.findViewById(R.id.tt1Sv);
                    String[] daysOfTheWeek = new String[]{"Понедельник","Вторник","Среда","Четверг","Пятница","Суббота"};
                    String[] lessonTime = new String[]{"8:20\n9:50","10:00\n11:30","11:40\n13:10","13:30\n15:00","15:20\n16:50","17:00\n18:30"};


                    LinearLayout mainLL = new LinearLayout(getContext());

                    LinearLayout.LayoutParams mainLLParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

                    mainLL.setLayoutParams(mainLLParams);
                    mainLLParams.height=LinearLayout.LayoutParams.WRAP_CONTENT;
                    mainLLParams.width=LinearLayout.LayoutParams.MATCH_PARENT;
                    mainLL.setOrientation(LinearLayout.VERTICAL);
                    sv.addView(mainLL);

                    ViewGroup.LayoutParams tvDayOfTheWeekParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


                    for(String d: daysOfTheWeek)
                    {
                        TextView tvDayOfTheWeek = new TextView(getContext());
                        tvDayOfTheWeek.setLayoutParams(tvDayOfTheWeekParams);
                        tvDayOfTheWeek.setText(d);
                        tvDayOfTheWeek.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                        mainLL.addView(tvDayOfTheWeek);


                        for (String l : lessonTime)
                        {
                            LinearLayout llLesson = new LinearLayout(getContext());
                            llLesson.setLayoutParams(mainLLParams);
                            TextView tvTime = new TextView(getContext());
                            tvTime.setLayoutParams(new TableLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 4f));
                            tvTime.setText(l);
                            TextView tvLessonName = new TextView(getContext());
                            tvLessonName.setLayoutParams(new TableLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
                            tvLessonName.setText("Методология программной инженерии\nКлименков Сергей Викторович\nКронверкский пр., д. 49 лит. А 324");
                            llLesson.addView(tvTime);
                            llLesson.addView(tvLessonName);
                            mainLL.addView(llLesson);
                            View line = new View(getContext());
                            line.setLayoutParams(new LinearLayout.LayoutParams(
                                    LinearLayout.LayoutParams.MATCH_PARENT,
                                    5
                            ));
                            line.setBackgroundColor(Color.parseColor("#B3B3B3"));
                            mainLL.addView(line);
                        }


                        //ViewGroup.LayoutParams tvTimeParams= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


                    }

                    /*
                    ViewGroup.LayoutParams lParamsButtons = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    Button btnChangeTT = new Button(getContext());
                    btnChangeTT.setLayoutParams(lParamsButtons);
                    btnChangeTT.setText("Изменить расписание");
                   // btnChangeTT.setId(4);

                    TextView tvTest = new TextView(getContext());
                    tvTest.setLayoutParams(tvDayOfTheWeekParams);
                    tvTest.setText("TEST");
                    mainLL.addView(tvTest);

                    Button btnClearTT = new Button(getContext());
                    btnClearTT.setLayoutParams(lParamsButtons);
                    btnClearTT.setText("Очистить расписание");

                    mainLL.addView(btnChangeTT);
                    mainLL.addView(btnClearTT);
                    */

                    break;
                case 2:
                    rootView = inflater.inflate(R.layout.tt_2, container, false);

                    sv = (ScrollView) rootView.findViewById(R.id.tt2Sv);
                    daysOfTheWeek = new String[]{"Понедельник","Вторник","Среда","Четверг","Пятница","Суббота"};
                    lessonTime = new String[]{"8:20\n9:50","10:00\n11:30","11:40\n13:10","13:30\n15:00","15:20\n16:50","17:00\n18:30"};


                    mainLL = new LinearLayout(getContext());

                     mainLLParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

                    mainLL.setLayoutParams(mainLLParams);
                    mainLLParams.height=LinearLayout.LayoutParams.WRAP_CONTENT;
                    mainLLParams.width=LinearLayout.LayoutParams.MATCH_PARENT;
                    mainLL.setOrientation(LinearLayout.VERTICAL);
                    sv.addView(mainLL);

                    tvDayOfTheWeekParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


                    for(String d: daysOfTheWeek)
                    {
                        TextView tvDayOfTheWeek = new TextView(getContext());
                        tvDayOfTheWeek.setLayoutParams(tvDayOfTheWeekParams);
                        tvDayOfTheWeek.setText(d);
                        tvDayOfTheWeek.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                        mainLL.addView(tvDayOfTheWeek);


                        for (String l : lessonTime)
                        {
                            LinearLayout llLesson = new LinearLayout(getContext());
                            llLesson.setLayoutParams(mainLLParams);
                            TextView tvTime = new TextView(getContext());
                            tvTime.setLayoutParams(new TableLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 4f));
                            tvTime.setText(l);
                            TextView tvLessonName = new TextView(getContext());
                            tvLessonName.setLayoutParams(new TableLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
                            tvLessonName.setText("Методология программной инженерии\nКлименков Сергей Викторович\nКронверкский пр., д. 49 лит. А 324");
                            llLesson.addView(tvTime);
                            llLesson.addView(tvLessonName);
                            mainLL.addView(llLesson);
                            View line = new View(getContext());
                            line.setLayoutParams(new LinearLayout.LayoutParams(
                                    LinearLayout.LayoutParams.MATCH_PARENT,
                                    5
                            ));
                            line.setBackgroundColor(Color.parseColor("#B3B3B3"));
                            mainLL.addView(line);
                        }


                        //ViewGroup.LayoutParams tvTimeParams= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


                    }
                    break;
            }

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "ЧЕТНАЯ НЕДЕЛЯ";
                case 1:
                    return "НЕЧЕТНАЯ НЕДЕЛЯ";
            }
            return null;
        }
    }
}
