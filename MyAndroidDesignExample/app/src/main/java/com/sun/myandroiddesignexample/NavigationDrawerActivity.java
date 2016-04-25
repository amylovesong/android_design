package com.sun.myandroiddesignexample;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.sun.myandroiddesignexample.widget.TitlebarMessageContainer;

public class NavigationDrawerActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private TitlebarMessageContainer mTitleBarContainer;
    private Toolbar mToolbar;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

        mTitleBarContainer = (TitlebarMessageContainer) findViewById(R.id.title_bar_layout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mButton = (Button) findViewById(R.id.button_play_animation);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (mTitleBarContainer.isTripInfoViewShown()) {
            mTitleBarContainer.closeTripInfoView();
        } else {
            mTitleBarContainer.openTripInfoView();
        }
    }
}
