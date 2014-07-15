package org.hybridsquad.droidlab;

import android.support.v4.app.Fragment;

/**
 * Created with Android Studio.
 * User: ryan@xisue.com
 * Date: 7/14/14
 * Time: 10:36 PM
 * Desc: BaseGuideFragment
 */
public abstract class BaseGuideFragment extends Fragment {

    public abstract int[] getChildViewIds() ;

    public abstract int getRootViewId();
}
