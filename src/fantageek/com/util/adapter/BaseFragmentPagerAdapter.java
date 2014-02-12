package fantageek.com.util.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class BaseFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private Fragment[] arrFragment;

    public BaseFragmentPagerAdapter(FragmentManager fm, Fragment[] fragments) {
        super(fm);
        this.arrFragment = fragments;
        if (fragments == null)
            arrFragment = new Fragment[0];
    }

    @Override
    public Fragment getItem(int pos) {
        return arrFragment[pos];
    }

    @Override
    public int getCount() {
        return arrFragment.length;
    }
}
