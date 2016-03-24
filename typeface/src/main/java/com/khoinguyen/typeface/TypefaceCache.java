package com.khoinguyen.typeface;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.HashMap;

public final class TypefaceCache {
    private static String DIR_FONT = "fonts/";
    private static TypefaceCache instance;
    private HashMap<String, Typeface> cacheTypeFace;

    public static TypefaceCache getCache() {
        if(instance == null) {
            instance = new TypefaceCache();
            instance.cacheTypeFace = new HashMap();
        }

        return instance;
    }

    public static void setFontDir(String dir) {
        DIR_FONT = dir;
    }

    public static void initCustomFont(TextView textView, AttributeSet attrs) {
        if(attrs != null && !textView.isInEditMode()) {
            TypedArray a = null;

            try {
                a = textView.getContext().obtainStyledAttributes(attrs, R.styleable.TypefaceTextView);
                String e = a.getString(R.styleable.TypefaceTextView_font);
                setCustomFont(textView, e);
            } catch (Exception var7) {
                var7.printStackTrace();
            } finally {
                if(a != null) {
                    a.recycle();
                }

            }

        }
    }

    public static Typeface setCustomFont(TextView textView, String fontName) {
        if(TextUtils.isEmpty(fontName)) {
            return null;
        } else {
            TypefaceCache cacheFont = getCache();
            Typeface customTypeface = cacheFont.get(fontName);
            if(customTypeface == null) {
                customTypeface = Typeface.createFromAsset(textView.getContext().getAssets(), DIR_FONT + fontName);
                cacheFont.cache(fontName, customTypeface);
            }

            if(customTypeface != null) {
                textView.setTypeface(customTypeface);
            }

            return customTypeface;
        }
    }

    private TypefaceCache() {
    }

    public void cache(String name, Typeface tf) {
        if(tf != null && !TextUtils.isEmpty(name)) {
            this.cacheTypeFace.put(name, tf);
        }

    }

    public Typeface get(String name) {
        return (Typeface)this.cacheTypeFace.get(name);
    }
}
