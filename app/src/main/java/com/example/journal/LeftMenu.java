package com.example.journal;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LeftMenu extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private boolean bookmarkSet = false;

    private NavigationView myNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_left_menu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_about_us, R.id.nav_contact, R.id.nav_share)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        initAll();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        String email = user.getEmail();
        String toPut = email.substring(email.indexOf(" ") + 1, email.indexOf("."));
        toPut = toPut.substring(0, 1).toUpperCase() + toPut.substring(1);

        String finalToPut = toPut;
        myNavigationView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                myNavigationView.removeOnLayoutChangeListener(this);

                TextView userName;
                TextView userEmail;

                userName = myNavigationView.findViewById(R.id.idUserName);
                userEmail = myNavigationView.findViewById(R.id.idUserEmail);

                userName.setText(finalToPut);
                userEmail.setText(email);
            }
        });

    }

    public void initAll(){
        myNavigationView = findViewById(R.id.nav_view);
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    public void onDrawerClick(View view) {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        if (!drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.openDrawer(GravityCompat.START);
        } else {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    public void onBookmarkClick(View view) {
        ImageView imgBkm = findViewById(R.id.idTripBookmark);
        if(!bookmarkSet) {
            imgBkm.setImageResource(R.drawable.heart_fill);
            bookmarkSet = true;
        }
            else {
                bookmarkSet = false;
            imgBkm.setImageResource(R.drawable.heart_empty);

        }
    }
}
