package com.example.gym_application.Activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.gym_application.BuildConfig;
import com.example.gym_application.Fragments.HomeFragment;
import com.example.gym_application.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // index to identify current nav menu item
    public static int navItemIndex = 0;                                         // this variable toolbar title
    // tags used to attach the fragments
//    private static final String TAG_HOME = "home";                              // home toolbar titile variable isilize
    private static final String TAG_EDIT_PROFILE = "edit profile";              // edit profile title toolbar variable isilize
    private static final String TAG_ATTENDENCE_SHEET = "attendenc sheet";       // attendence titile toolbar variable isilize
//    public static String CURRENT_TAG = TAG_HOME;                                // by defult home title set toolbar variable isilize

    public Boolean Status = true;


    // toolbar titles respected to selected nav menu item
    private String[] activityTitles;                                            // activity toolbar title set id
    private DrawerLayout drawer;                                                // drawer variable isilize
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        toolbar.setNavigationIcon(R.drawable.play);
        toolbar.setTitle("Gym");
        toolbar.setTitleTextColor(Color.WHITE);
        drawer = findViewById(R.id.draver);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,             // toogle button add adn drawer open clase set
                R.string.open, R.string.close);
//        toggle.setDrawerIndicatorEnabled(false);
//        toggle.setHomeAsUpIndicator(R.drawable.togle_icon);


        // load toolbar titles from string resources
        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);                   // work for set select activity title set toolbar




        drawer.addDrawerListener(toggle);                                                                   // drawer toggle lissner
        toggle.syncState();
        if (savedInstanceState == null) {                                                                   // this function toolbar title set
            navItemIndex = 0;
//            CURRENT_TAG = TAG_HOME;
            Status = true;
            loadHomeFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_view);
        }
    }

    private void loadHomeFragment() {
        // selecting appropriate nav menu item

        // set toolbar title
        setToolbarTitle();
    }

    private void setToolbarTitle() {
        getSupportActionBar().setTitle(activityTitles[navItemIndex]);                   // set title toolbar function
    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {                           // navigation fragment selected and click for again going for again fragment
        switch (item.getItemId()) {
            case  R.id.home_item :                                                              // home fragment transection function
                navItemIndex = 0;
//                CURRENT_TAG = TAG_HOME;
                Status = true;
                Toast.makeText(this, "Home Fragment", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,

                        new HomeFragment()).commit();

                break;

            case R.id.rate_item:                                                             // edit profile fragment transection function
//                navItemIndex = 1;
//                CURRENT_TAG = TAG_EDIT_PROFILE;
                Status  = false;
//                Toast.makeText(this, "Edit Profile Fragment", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://play.google.com/store/apps/details?id=homeworkout.gym.fitness.weightloss.noequipment&hl=en&gl=US")));
                break;


            case R.id.moreapp_item:                                                             // edit profile fragment transection function
//                navItemIndex = 1;
//                CURRENT_TAG = TAG_EDIT_PROFILE;
                Status  = false;
//                Toast.makeText(this, "Edit Profile Fragment", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://play.google.com/apps?hl=en&gl=US")));
                break;

            case R.id.share_item:                                                             // edit profile fragment transection function
//                navItemIndex = 1;
//                CURRENT_TAG = TAG_EDIT_PROFILE;
                Status  = false;
//                Toast.makeText(this, "Edit Profile Fragment", Toast.LENGTH_SHORT).show();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "Hey check out my app at: https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;

            case R.id.policy_item:                                                             // edit profile fragment transection function
//                navItemIndex = 1;
//                CURRENT_TAG = TAG_EDIT_PROFILE;
                Status  = false;
//                Toast.makeText(this, "Edit Profile Fragment", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://policymaker.io/privacy-policy/?gclid=Cj0KCQiAqdP9BRDVARIsAGSZ8AnpTBoierh3YC5-svXRRj8bI7dJkpe9hl0yK7fujBdx_D6yo5IghvUaAvdmEALw_wcB")));
                break;



//
//            case R.id.Attendence_item:                                                          // attendence fragment transection function
//                navItemIndex = 2;
//                CURRENT_TAG = TAG_ATTENDENCE_SHEET;
//                Status  = false;
//
//                Intent intent = new Intent(MainActivity.this,Attendence.class);
//                startActivity(intent);
//
////                getSupportFragmentManager().beginTransaction().replace(R.id.frame,
////                new Attendence_Fragment()).commit();

        }
        drawer.closeDrawer(GravityCompat.START);                                                 // drawer colser function
        return true;
    }


    @Override
    public void onBackPressed() {                                                               // this function drawer close and open auto work
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
//        else if (Status==true){
////
////            new AlertDialog.Builder(this)
////                        .setTitle("Reallly Exists?")
////                        .setMessage("Are you sure you want to exit?")
////                        .setNegativeButton(R.string.no, null)
////                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
////
////                            public void onClick(DialogInterface arg0, int arg1) {
////                                MainActivity.super.onBackPressed();
////                            }
////                        }).create().show();
////
////        }else {
////            Toast.makeText(this, "Home Fragment", Toast.LENGTH_SHORT).show();
////                getSupportFragmentManager().beginTransaction().replace(R.id.frame,
////
////                        new Home_Fragment()).commit();
//////
////        }





        else {
            if (Status==false) {                                                                       // this function back work for home fragment

                Toast.makeText(this, "Home Fragment", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,

                        new HomeFragment()).commit();
                Status = true;
            }
            else                                                                                        // this function work a when click back so apply a dilog
            {
                new AlertDialog.Builder(this)
                        .setTitle("Reallly Exists?")
                        .setMessage("Are you sure you want to exit?")
                        .setNegativeButton(R.string.no, null)
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface arg0, int arg1) {
                                MainActivity.super.onBackPressed();
                            }
                        }).create().show();
            }
        }
    }
}