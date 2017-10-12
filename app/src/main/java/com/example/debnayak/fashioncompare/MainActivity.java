package com.example.debnayak.fashioncompare;

import android.support.design.internal.NavigationMenu;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    private ActionBarDrawerToggle actionBarDrawerToggle;

    private Toolbar mToolBar;

    private TextView navigationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        mToolBar = (Toolbar)findViewById(R.id.nav_action);
        setSupportActionBar(mToolBar);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        View headerLayout = navigationView.getHeaderView(0);
        navigationText =(TextView) headerLayout.findViewById(R.id.navigation_header);
        String displayName = (String) getIntent().getExtras().get("account");
        navigationText.setText("Hello "+displayName.substring(0,11));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}
