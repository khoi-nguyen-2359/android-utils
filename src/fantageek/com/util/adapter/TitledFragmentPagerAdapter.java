package fantageek.com.util.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TitledFragmentPagerAdapter extends FragmentPagerAdapter {
    public static interface TitledFragment {
        String getTitle();
        Fragment getTitledFragment();
    }

    private TitledFragment[] arrFragment;

    public TitledFragmentPagerAdapter(FragmentManager fm, TitledFragment[] fragments) {
        super(fm);
        this.arrFragment = fragments;
        if (arrFragment == null)
            arrFragment = new TitledFragment[0];
    }

    @Override
    public Fragment getItem(int pos) {
        return arrFragment[pos].getTitledFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return arrFragment[position].getTitle();
    }

    @Override
    public int getCount() {
        return arrFragment.length;
    }
}