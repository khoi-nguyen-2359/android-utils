package com.khoinguyen.logging;

import android.support.v4.util.LruCache;
import android.util.Log;

public final class L {
    private static LruCache<String, L> instances;
    private static boolean isClassLoggable = true;
    private static String defaultTag = "khoi";
    private boolean loggable;
    private String tag;

    private static LruCache<String, L> getInstances() {
        if(instances == null) {
            instances = new LruCache(50);
        }

        return instances;
    }

    public static L get() {
        return get(defaultTag);
    }

    public static <T> L get(Class<T> clazz) {
        return get(clazz != null?clazz.getSimpleName():"null");
    }

    public static L get(Object object) {
        return get(object!=null?object.toString():"null");
    }

    public static L get(String tag) {
        LruCache<String, L> instances = getInstances();
        L l = instances.get(tag);
        if(l == null) {
            l = new L(tag);
            instances.put(tag, l);
        }

        return l;
    }

    private L(String tag) {
        this.tag = tag;
        this.loggable = true;
    }

    public static void setClassLoggable(boolean loggable) {
        isClassLoggable = loggable;
    }

    public static void setDefaultTag(String tag) {
        defaultTag = tag;
    }

    public void d(String format, Object... args) {
        if(isClassLoggable && this.loggable) {
            try {
                if(args != null && args.length != 0) {
                    Log.d(this.tag, String.format(format, args));
                } else {
                    Log.d(this.tag, format);
                }
            } catch (Exception var4) {
                var4.printStackTrace();
            }

        }
    }

    public boolean isLoggable() {
        return this.loggable;
    }

    public void setLoggable(boolean loggable) {
        this.loggable = loggable;
    }
}
