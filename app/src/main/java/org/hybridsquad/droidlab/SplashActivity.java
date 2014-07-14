package org.hybridsquad.droidlab;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.viewpagerindicator.CirclePageIndicator;

public class SplashActivity extends ActionBarActivity {

    ViewPager mPager;
    CirclePageIndicator mPagerIndicator;

    FragmentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_guide);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerIndicator = (CirclePageIndicator) findViewById(R.id.indicator);

        mAdapter = new FragmentAdapter(getSupportFragmentManager());
        mAdapter.addItem(new BaseGuideFragment(R.layout.fragment_guide_first));
        mAdapter.addItem(new BaseGuideFragment(R.layout.fragment_guide_second));
        mAdapter.addItem(new BaseGuideFragment(R.layout.fragment_guide_third));
        mAdapter.addItem(new BaseGuideFragment(R.layout.fragment_guide_fourth));
        mAdapter.addItem(new BaseGuideFragment(R.layout.fragment_guide_fifth));
        mAdapter.addItem(new BaseGuideFragment(R.layout.fragment_guide_sixth));
        mPager.setAdapter(mAdapter);

        mPagerIndicator.setViewPager(mPager);
    }
}
