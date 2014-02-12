package fantageek.com.util.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * This fragment show loading/waiting view for indeterminate tasks or for hiding
 * the content behind
 * 
 * @author anhkhoi
 * 
 */
public class UtilBaseFragment extends Fragment {

    public static final String KEY_ROOT_VIEW_RES_ID = "KEY_ROOT_VIEW_RES_ID";

    public static UtilBaseFragment instantiate(int resIdRootView) {
        UtilBaseFragment f = new UtilBaseFragment();
        f.resIdRootView = resIdRootView;
        return f;
    }

    public static UtilBaseFragment instantiate(View rootView) {
        UtilBaseFragment f = new UtilBaseFragment();
        f.rootView = rootView;
        return f;
    }

    protected int resIdRootView = -1;
    protected View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setupRootView();
        // ultilize the using of UtilBaseFragmetn class
        if (rootView == null)
            rootView = inflater.inflate(resIdRootView, container, false);
        initViews();
        return rootView;
    }

    protected void setupRootView() {
    }

    protected void initViews() {
    }
}
