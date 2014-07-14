package org.hybridsquad.droidlab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Android Studio.
 * User: ryan@xisue.com
 * Date: 7/14/14
 * Time: 10:40 PM
 * Desc: FragmentAdapter
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments = new ArrayList<Fragment>();

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addItem(Fragment fragment) {
        fragments.add(fragment);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }
}
