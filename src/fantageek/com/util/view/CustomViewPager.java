package fantageek.com.util.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class CustomViewPager extends ViewPager {

    private boolean swipeable = true;
    
    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    public void setSwipeable(boolean value) {
        swipeable = value;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return swipeable ? super.onInterceptTouchEvent(ev) : false;
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return swipeable ? super.onTouchEvent(ev) : false;
    }
}
