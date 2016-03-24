package com.khoinguyen.typeface;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

public class TypefaceButton extends Button {
    public TypefaceButton(Context context) {
        super(context);
    }

    public TypefaceButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypefaceCache.initCustomFont(this, attrs);
    }

    public TypefaceButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypefaceCache.initCustomFont(this, attrs);
    }
}
