package com.rha.app.rha.view.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.widget.FrameLayout;

import com.rha.app.rha.R;
import com.rha.app.rha.utility.Constants;
import com.rha.app.rha.utility.FragmentExecutor;
import com.rha.app.rha.view.fragment.HomeFragment;


public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private FrameLayout frameLayout;
    private NavigationView navigationView;
    private static final String TAG = HomeActivity.class.getSimpleName();
    private ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        Constants.initializeToolBar(this, toolbar, getResources().getString(R.string.app_name), null);
        initNavigationView();
    }


    protected void initNavigationView() {

        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        initNavigationHeaderView();

    }


    private void initNavigationHeaderView() {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        try{
            int id = item.getItemId();
            Fragment fragment = null;
            fragment = new HomeFragment();
            if (id == R.id.makeMoney) {
                fragment = new HomeFragment();
              //  fragment = HomeFragment.getInstanace();
//            Intent i = new Intent(getApplicationContext(), RaiseRequestActivity.class);
//            startActivity(i);
                // Handle the camera action
            } else if (id == R.id.share_app) {
             //   fragment = ProfileFrgm.getInstance();
            } else if (id == R.id.feedback) {

            } else if (id == R.id.rate_app) {

            }

            FragmentExecutor.addFragment(getSupportFragmentManager(), R.id.frame_layout, fragment, TAG, false);
            toolbar.setTitle(item.getTitle());
            drawerLayout.closeDrawer(GravityCompat.START);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return true;
    }


}
