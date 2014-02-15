package fantageek.com.util.helper;

import android.content.Context;
import android.net.ConnectivityManager;

public final class ConfigurationUtil {

    /**
     * Check if there is any active network
     * @param context
     * @return
     */
    public static boolean isConnectionActive(Context context) {
        ConnectivityManager conMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return conMgr.getActiveNetworkInfo() != null;
    }
}
