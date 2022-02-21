package com.example.firebasepracticw;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class LoginAdapter extends FragmentPagerAdapter {
private Context context;
int totTab;

    public LoginAdapter(@NonNull FragmentManager fm,Context context ,int totTab) {
        super(fm);
        this.context = context;
        this.totTab=totTab;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Login_frag loginfrag=new Login_frag();
                return loginfrag;
            case 1:
                Signup_frag signfrag=new Signup_frag();
                return signfrag;
        default:
        return null;
        }
    }

    @Override
    public int getCount() {
        return totTab;
    }
}
