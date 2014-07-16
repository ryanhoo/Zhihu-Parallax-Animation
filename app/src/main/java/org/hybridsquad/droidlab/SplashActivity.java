package org.hybridsquad.droidlab;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextSwitcher;
import com.viewpagerindicator.CirclePageIndicator;

public class SplashActivity extends ActionBarActivity {

    final float PARALLAX_COEFFICIENT = 1.2f;
    final float DISTANCE_COEFFICIENT = 0.5f;

    TextSwitcher mTextSwitcher;

    ViewPager mPager;
    CirclePageIndicator mPagerIndicator;

    FragmentAdapter mAdapter;

    SparseArray<int[]> mLayoutViewIdsMap = new SparseArray<int[]>();

    String[] mGuideTips;

    private void addGuide(BaseGuideFragment fragment) {
        mAdapter.addItem(fragment);
        mLayoutViewIdsMap.put(fragment.getRootViewId(), fragment.getChildViewIds());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_guide);

        mGuideTips = getResources().getStringArray(R.array.array_guide_tips);

        mTextSwitcher = (TextSwitcher) findViewById(R.id.tip);

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
        mPagerIndicator.setOnPageChangeListener(new MyPageChangeListener());
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
            float scrollXOffset = page.getWidth() * parallaxCoefficient;

            ViewGroup pageViewWrapper = (ViewGroup) page;
            @SuppressWarnings("SuspiciousMethodCalls")
            int[] layer = mLayoutViewIdsMap.get(pageViewWrapper.getChildAt(0).getId());
            for (int id : layer) {
                View view = page.findViewById(id);
                if (view != null) {
                    view.setTranslationX(scrollXOffset * position);
                }
                scrollXOffset *= distanceCoefficient;
            }
        }
    }

    class MyPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            if (mGuideTips != null && mGuideTips.length > position) {
                mTextSwitcher.setText(mGuideTips[position]);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }
}
