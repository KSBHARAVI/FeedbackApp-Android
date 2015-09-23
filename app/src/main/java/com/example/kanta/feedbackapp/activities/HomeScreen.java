package com.example.kanta.feedbackapp.activities;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.bozidar.microdroid.base.MicroActivity;
import com.bozidar.microdroid.slidingtab.manager.MicroTabManager;
import com.example.kanta.feedbackapp.R;
import com.example.kanta.feedbackapp.fragments.HomeFragment;
import com.example.kanta.feedbackapp.utils.Constants;

import butterknife.InjectView;

public class HomeScreen extends MicroActivity {

    @InjectView(R.id.nav_view)
    NavigationView navigationView;

    @InjectView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @InjectView(R.id.pagermy)
    ViewPager viewPager;

    @InjectView(R.id.tabLayout)
    TabLayout tabLayout;

    @Override
    public int setupToolbar() {
        return 0;
    }

    @Override
    public int setupLayoutRes() {
        return R.layout.activity_home_screen;
    }

    @Override
    public int setupMenuRes() {
        return 0;
    }

    @Override
    public void init() {
        setupTabs();
        setupDrawerContent();
    }

    /**
     * Setup tabs
     */

    private void setupTabs() {
        MicroTabManager microTabManager = new MicroTabManager(getSupportFragmentManager(), viewPager, tabLayout);
        microTabManager.addTab(HomeFragment.getInstance(Constants.ALL_PROJECTS));
        microTabManager.addTab(HomeFragment.getInstance(Constants.MY_PROJECTS));
        microTabManager.init();
    }

    /**
     * Method for checking clicked items in Navigation Drawer
     */
    private void setupDrawerContent() {
        if(navigationView != null){
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawers();
                    return true;
                }
            });
        }
    }
}
