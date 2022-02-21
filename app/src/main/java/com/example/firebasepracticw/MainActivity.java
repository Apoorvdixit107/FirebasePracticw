package com.example.firebasepracticw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    TabLayout tab;
    ViewPager view;
    FloatingActionButton fab;
    float v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab=findViewById(R.id.tablayout);
        view=findViewById(R.id.viewpager);
        fab=findViewById(R.id.fab);
tab.addTab(tab.newTab().setText("Login"));
        tab.addTab(tab.newTab().setText("SignUp"));
        tab.setTabGravity(tab.GRAVITY_FILL);
        final LoginAdapter adapter = new LoginAdapter(getSupportFragmentManager(),this,tab.getTabCount());
        view.setAdapter(adapter);
        view.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
        fab.setTranslationY(300);
fab.setAlpha(v);
fab.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
         database=FirebaseDatabase.getInstance();
         myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
        myRef.setValue("All is Well");
        myRef.addValueEventListener( new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               String value= snapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}