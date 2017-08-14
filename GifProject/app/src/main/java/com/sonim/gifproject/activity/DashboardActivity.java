package com.sonim.gifproject.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.sonim.gifproject.R;
import com.sonim.gifproject.adapter.ViewPagerAdapter;

public class DashboardActivity extends AppCompatActivity {


    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initViews();
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(adapter.getCount() - 1);
    }
    private void initViews() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
    }

    @Override
    public void onBackPressed() {
        if (viewPager != null) {
            if (viewPager.getCurrentItem() == 0)
                viewPager.setCurrentItem(1);
            else
                super.onBackPressed();
        }

    }
}
