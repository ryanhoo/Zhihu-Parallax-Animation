package org.hybridsquad.droidlab;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends ActionBarActivity {

    final float PARALLAX_COEFFICIENT = 15f;
    final float DISTANCE_COEFFICIENT = 0.8f;

    ViewPager mPager;
    CirclePageIndicator mPagerIndicator;

    FragmentAdapter mAdapter;

    List<int[]> mLayers = new ArrayList<int[]>();

    private void addGuide(BaseGuideFragment fragment) {
        mAdapter.addItem(fragment);
        mLayers.add(fragment.getChildViewIds());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_guide);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerIndicator = (CirclePageIndicator) findViewById(R.id.indicator);

        mAdapter = new FragmentAdapter(getSupportFragmentManager());
        addGuide(new FirstGuideFragment());
        addGuide(new SecondGuideFragment());
        addGuide(new ThirdGuideFragment());
        addGuide(new FourthGuideFragment());
        addGuide(new FifthGuideFragment());
        addGuide(new SixthGuideFragment());

        mPager.setAdapter(mAdapter);

        mPagerIndicator.setViewPager(mPager);

        mPager.setPageTransformer(true, new ParallaxTransformer(PARALLAX_COEFFICIENT, DISTANCE_COEFFICIENT));
    }

    class ParallaxTransformer implements ViewPager.PageTransformer {

        float parallaxCoefficient;
        float distanceCoefficient;

        public ParallaxTransformer(float parallaxCoefficient, float distanceCoefficient) {
            this.parallaxCoefficient = parallaxCoefficient;
            this.distanceCoefficient = distanceCoefficient;
        }

        @TargetApi(Build.VERSION_CODES.HONEYCOMB)
        @Override
        public void transformPage(View page, float position) {
            float coefficient = page.getWidth() * parallaxCoefficient;

            for (int[] layer : mLayers) {
                for (int id : layer) {
                    View view = page.findViewById(id);
                    if (view != null) {
                        view.setTranslationX(coefficient * position);
                    }
                    coefficient *= distanceCoefficient;
                }
            }
        }
    }
}
