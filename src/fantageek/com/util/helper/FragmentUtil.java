package fantageek.com.util.helper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public final class FragmentUtil {
    public static int replace(FragmentActivity fa, int id, Fragment f, int animEnter, int animExit) {
        FragmentManager fm = fa.getSupportFragmentManager();
        return fm.beginTransaction().replace(id, f).setCustomAnimations(animEnter, animExit).commit();
    }
}
