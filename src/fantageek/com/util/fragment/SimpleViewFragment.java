package fantageek.com.util.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * This fragment show loading/waiting view for indeterminate tasks or for hiding the content behind
 * @author anhkhoi
 *
 */
public class SimpleViewFragment extends Fragment {
	
	public static final String KEY_ROOT_VIEW_RES_ID = "KEY_ROOT_VIEW_RES_ID";

    public static SimpleViewFragment instantiate(int resIdRootView) {
		SimpleViewFragment f = new SimpleViewFragment();
		f.resIdRootView = resIdRootView;
		return f;
	}
	
	public static SimpleViewFragment instantiate(View rootView) {
		SimpleViewFragment f = new SimpleViewFragment();
		f.rootView = rootView;
		return f;
	}
	
	protected int resIdRootView = -1;
	protected View rootView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    restoreInstanceState(savedInstanceState);
	}
	
	private void restoreInstanceState(Bundle state) {
	    if (state == null)
	        return;
	    
	    resIdRootView = state.getInt(KEY_ROOT_VIEW_RES_ID, -1);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (resIdRootView != -1)
			rootView = inflater.inflate(resIdRootView, container, false);
		
		return rootView;
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
	    super.onSaveInstanceState(outState);
	    
	    outState.putInt(KEY_ROOT_VIEW_RES_ID, resIdRootView);
	}
}
