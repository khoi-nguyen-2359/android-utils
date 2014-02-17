package fantageek.com.util.fragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author anhkhoi
 * 
 */
public class UtilBaseDlgFragment extends DialogFragment {

    public static final String KEY_ROOT_VIEW_RES_ID = "KEY_ROOT_VIEW_RES_ID";

    public static UtilBaseDlgFragment instantiate(int resIdRootView) {
        UtilBaseDlgFragment f = new UtilBaseDlgFragment();
        f.resIdRootView = resIdRootView;
        return f;
    }

    public static UtilBaseDlgFragment instantiate(View rootView) {
        UtilBaseDlgFragment f = new UtilBaseDlgFragment();
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
    
    protected View findViewById(int id) {
        if (rootView == null)
            return null;
        
        return rootView.findViewById(id);
    }

    protected void setupRootView() {
    }

    protected void initViews() {
    }
}
