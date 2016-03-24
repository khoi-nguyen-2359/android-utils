package com.khoinguyen.typeface;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class TypefaceEditText extends EditText {
    public TypefaceEditText(Context context) {
        super(context);
    }

    public TypefaceEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypefaceCache.initCustomFont(this, attrs);
    }

    public TypefaceEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypefaceCache.initCustomFont(this, attrs);
    }
}
