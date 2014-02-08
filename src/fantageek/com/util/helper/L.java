package fantageek.com.util.helper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

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

    public static void dd(String format, Object... strings) {
        L.d(TAG, format, strings);
    }

    public static void dd(String s) {
        L.d(TAG, s);
    }

    public static void dd(Object o) {
        L.d(TAG, o);
    }

    public static void d(String tag, String format, Object... strings) {
        if (enable == false)
            return;
        Log.d(tag, String.format(format, strings));
    }

    public static void d(String t, String s) {
        if (enable == false)
            return;
        Log.d(t, s);
    }

    public static void d(String t, Object o) {
        if (enable == false)
            return;
        Log.d(t, o == null ? "null" : objToString(o));
    }

    private static String objToString(Object o) {
        StringBuilder builder = new StringBuilder();
        
        builder.append("{");
        for (Method method : o.getClass().getDeclaredMethods()) {
            if (Modifier.isPublic(method.getModifiers()) && method.getParameterTypes().length == 0
                    && method.getReturnType() != void.class
                    && (method.getName().startsWith("get") || method.getName().startsWith("is"))) {
                Object value = null;
                try {
                    value = method.invoke(o);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                builder.append(method.getName() + "=" + value);
                builder.append(",");
            }
        }
        builder.append("}");

        return builder.toString();
    }
}
