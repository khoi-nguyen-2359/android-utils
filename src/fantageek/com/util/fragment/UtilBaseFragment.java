package fantageek.com.util.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * This fragment show a simple view passed from outside.
 * 
 * @author anhkhoi
 * 
 */
public class UtilBaseFragment extends Fragment {

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        if (savedInstanceState != null) {
            onRestoreState(savedInstanceState);
        }
        
        if (getArguments() != null) {
            readArguments();
        }
    }
    
    protected void readArguments() {
        Bundle args = getArguments();
        if (args == null)
            return;
        
        resIdRootView = args.getInt(KEY_ROOT_VIEW_RES_ID, 0);
    }

    protected void onRestoreState(Bundle savedInstanceState) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setupRootView(inflater, container, savedInstanceState);
        // ultilize the using of UtilBaseFragmetn class
        if (rootView == null)
            rootView = inflater.inflate(resIdRootView, container, false);
        initChildViews();
        return rootView;
    }
    
    protected View findViewById(int id) {
        if (rootView == null)
            return null;
        
        return rootView.findViewById(id);
    }

    protected void setupRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    }

    protected void initChildViews() {
    }
}
