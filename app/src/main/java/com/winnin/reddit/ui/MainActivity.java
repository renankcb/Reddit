package com.winnin.reddit.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;

import com.winnin.reddit.R;
import com.winnin.reddit.RedditApplication;
import com.winnin.reddit.di.component.ActivityComponent;
import com.winnin.reddit.di.component.DaggerActivityComponent;
import com.winnin.reddit.di.module.ActivityModule;
import com.winnin.reddit.ui.adapter.ViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    ActivityComponent component;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        buildDaggerComponent();

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupToolbar();
        setupViewPager();

    }

    private void buildDaggerComponent() {
        component = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .appComponent(((RedditApplication) getApplication()).getComponent())
                .build();
    }

    private void setupToolbar() {
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.darker_gray));
        toolbar.setTitle("/ Android");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }

    private void setupViewPager() {
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), getApplicationContext()));
        tabLayout.setupWithViewPager(viewPager);
    }
}
