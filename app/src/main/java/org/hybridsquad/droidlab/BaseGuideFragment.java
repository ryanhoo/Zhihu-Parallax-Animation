package org.hybridsquad.droidlab;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created with Android Studio.
 * User: ryan@xisue.com
 * Date: 7/14/14
 * Time: 10:36 PM
 * Desc: BaseGuideFragment
 */
public class BaseGuideFragment extends Fragment {

    private int res;
    public BaseGuideFragment() {
    }

    @SuppressLint("ValidFragment")
    public BaseGuideFragment(int res) {
        this.res = res;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(res, container, false);
    }
}
