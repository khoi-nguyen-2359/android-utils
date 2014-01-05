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
public class FrontViewFragment extends Fragment {
	
	public static FrontViewFragment instantiate(int resIdRootView) {
		FrontViewFragment f = new FrontViewFragment();
		f.resIdRootView = resIdRootView;
		return f;
	}
	
	protected int resIdRootView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(resIdRootView, container, false);
		return rootView;
	}
}
