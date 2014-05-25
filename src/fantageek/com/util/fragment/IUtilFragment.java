package fantageek.com.util.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public interface IUtilFragment {
    void readArguments(Bundle args);
    void onRestoreState(Bundle state);
    View findViewById(int resId);
    void setupRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
    void initChildViews();
}
