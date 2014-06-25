package fantageek.com.util.fragment;

import fantageek.com.util.adapter.TitledFragmentPagerAdapter.TitledFragment;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author anhkhoi
 * 
 */
public class UtilBaseDlgFragment extends DialogFragment implements TitledFragment, IUtilFragment {

    public static final String KEY_ROOT_VIEW_RES_ID = "KEY_ROOT_VIEW_RES_ID";

    public static UtilBaseFragment instantiate(int resIdRootView) {
        UtilBaseFragment f = new UtilBaseFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_ROOT_VIEW_RES_ID, resIdRootView);
        f.setArguments(args);
        return f;
    }

    public static UtilBaseFragment instantiate(View rootView) {
        UtilBaseFragment f = new UtilBaseFragment();
        f.rootView = rootView;
        return f;
    }

    private int resIdRootView = 0;
    protected View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            onRestoreState(savedInstanceState);
        }
        
        if (getArguments() != null) {
            readArguments(getArguments());
        }
        
        setupRootView(inflater, container, savedInstanceState);
        // ultilize the using of UtilBaseFragmetn class
        if (rootView == null)
            rootView = inflater.inflate(resIdRootView, container, false);
        initChildViews();
        setupData(savedInstanceState);
        return rootView;
    }
    
    @Override
    public void readArguments(Bundle args) {
        resIdRootView = args.getInt(KEY_ROOT_VIEW_RES_ID, 0);
    }
    
    @Override
    public View findViewById(int id) {
        if (rootView == null)
            return null;
        
        return rootView.findViewById(id);
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public Fragment getTitledFragment() {
        return this;
    }

    @Override
    public void onRestoreState(Bundle state) {
    }

    @Override
    public void setupRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    }

    @Override
    public void initChildViews() {
    }
    
    @Override
    public Bundle getOrCreateArguments() {
        Bundle args = getArguments();
        if (args == null) {
            args = new Bundle();
            setArguments(args);
        }
        
        return args;
    }

    @Override
    public void setupData(Bundle savedInstanceState) {
    }
}
