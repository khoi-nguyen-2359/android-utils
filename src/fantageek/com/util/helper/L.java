package fantageek.com.util.helper;

import android.util.Log;

/**
 * My logger ultility
 * 
 * @author anhkhoi
 * 
 */
public final class L {
    private static String TAG = "khoi";
    
    private static boolean enable = true;
    
    public static void setEnable(boolean val) {
        enable = val;
    }
    
    public static void setTag(String tag) {
        if (tag != null)
            TAG = tag;
    }
    
    public static void d(String f, Object...strings) {
        L.d(TAG, f, strings);
    }
    
    public static void d(String s) {
        L.d(TAG, s);
    }
    
    public static void d(Object o) {
        L.d(TAG, o);
    }
    
    public static void d(String t, String f, Object...strings) {
        if (enable == false)
            return;
        Log.d(t, String.format(f, strings));
    }
    
    public static void d(String t, String s) {
        if (enable == false)
            return;
        Log.d(t, s);
    }
    
    public static void d(String t, Object o) {
        if (enable == false)
            return;
        Log.d(t, o == null ? "null" : o.toString());
    }
}
