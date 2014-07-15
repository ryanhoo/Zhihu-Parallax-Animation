package org.hybridsquad.droidlab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created with Android Studio.
 * User: ryan@xisue.com
 * Date: 7/14/14
 * Time: 11:10 PM
 * Desc: ThirdGuideFragment
 */
public class SixthGuideFragment extends BaseGuideFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_guide_sixth, container, false);
    }

    @Override
    public int[] getChildViewIds() {
        return new int[]{};
    }

    @Override
    public int getRootViewId() {
        return R.id.layout_guide_sixth;
    }
}
