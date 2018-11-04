package com.rha.app.rha.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.rha.app.rha.R;
import com.rha.app.rha.view.adapters.ViewPagerAdapter;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class IntroActivity extends Activity {
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    private int[] txtHeaders = {R.string.action_headers1,R.string.action_headers2,R.string.action_headers3,
            R.string.action_headers4,R.string.action_headers5};
    private int[] txtHeadersDesc1 = {R.string.action_headers1_desc1,R.string.action_headers2_desc1,R.string.action_headers3_desc1
    ,R.string.action_headers4_desc1,R.string.action_headers5_desc1};
    private int[] txtHeadersDesc2 = {R.string.action_headers1_desc2,R.string.action_headers2_desc2,R.string.action_headers3_desc2
            ,R.string.action_headers4_desc2,R.string.action_headers5_desc2};
    private int[] txtHeadersDesc3 = {R.string.action_headers1_desc3,R.string.action_headers2_desc3,R.string.action_headers3_desc3
            ,R.string.action_headers4_desc3,R.string.action_headers5_desc3};
    private int[] txtHeadersDesc4 = {R.string.action_headers1_desc4,R.string.action_headers2_desc4,R.string.action_headers4_desc4
            ,R.string.action_headers4_desc4,R.string.action_headers5_desc4};
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_intro);

        viewPager = (ViewPager)findViewById(R.id.pager);

        viewPagerAdapter = new ViewPagerAdapter(IntroActivity.this,txtHeaders,txtHeadersDesc1,
                txtHeadersDesc2,txtHeadersDesc3,txtHeadersDesc4);

        viewPager.setAdapter(viewPagerAdapter);

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    int pageCount = txtHeaders.length;
                    if (currentPage == 0) {
                        viewPager.setCurrentItem(pageCount - 1, false);
                    } else if (currentPage == pageCount - 1) {
                        Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(i);
                        finish();
                        //  viewPager.setCurrentItem(0, false);
                    }
                }
            }
        });
//        final Handler handler = new Handler();
//        final Runnable update = new Runnable() {
//            @Override
//            public void run() {
//                if (currentPage == NUM_PAGES) {
//                    currentPage = 0;
//                }
//                viewPager.setCurrentItem(currentPage++, true);
//            }
//        };
//        Timer swipeTimer = new Timer();
//        swipeTimer.schedule(new TimerTask() {
//
//            @Override
//            public void run() {
//                handler.post(update);
//            }
//        }, 3000, 3000);

        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }
}