package com.khoinguyen.typeface;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class TypefaceTextView extends TextView {
    public TypefaceTextView(Context context) {
        super(context);
    }

    public TypefaceTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypefaceCache.initCustomFont(this, attrs);
    }

    public TypefaceTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypefaceCache.initCustomFont(this, attrs);
    }
}
