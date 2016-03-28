package com.khoinguyen.recyclerview;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class SimpleDividerItemDec extends ItemDecoration {
    private Drawable mDivider;
    private int orientation;
    private int itemOffset;

    /**
     *
     * @param divider
     * @param orientation use RecyclerView's orientation constants
     * @param itemOffset This offset is space between an item and a divider or between an item with nothing (start of first item or end of last item or there's no given divider)
     */
    public SimpleDividerItemDec(Drawable divider, int orientation, int itemOffset) {
        this.mDivider = divider;
        this.orientation = orientation;
        this.itemOffset = itemOffset;
    }

    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, State state) {
        int childPosition = parent.getChildAdapterPosition(view);
        int left = 0, top = 0, right = 0, bottom = 0;
        if(this.orientation == RecyclerView.VERTICAL) {
            bottom = itemOffset;
        } else if(this.orientation == RecyclerView.HORIZONTAL) {
            right = itemOffset;
        }

        if(this.orientation == RecyclerView.VERTICAL) {
            top = (this.mDivider != null && childPosition != 0?this.mDivider.getIntrinsicHeight():0) + itemOffset;
        } else if(this.orientation == RecyclerView.HORIZONTAL) {
            left = (this.mDivider != null && childPosition != 0?this.mDivider.getIntrinsicWidth():0) + itemOffset;
        }

        outRect.set(left, top, right, bottom);
    }

    public void onDrawOver(Canvas c, RecyclerView parent, State state) {
        if(this.mDivider != null) {
            int originLeft = parent.getPaddingLeft();
            int originRight = parent.getWidth() - parent.getPaddingRight();
            int originTop = parent.getPaddingTop();
            int originBottom = parent.getHeight() - parent.getPaddingBottom();
            int left = originLeft;
            int top = originTop;
            int right = originRight;
            int bottom = originBottom;
            int childCount = parent.getChildCount();

            for(int i = 0; i < childCount - 1; ++i) {
                View child = parent.getChildAt(i);
                LayoutParams params = (LayoutParams)child.getLayoutParams();
                if (orientation == RecyclerView.HORIZONTAL) {
                    left = child.getRight() + params.rightMargin + itemOffset;
                    right = left + this.mDivider.getIntrinsicWidth();
                    top = (originBottom - originTop - mDivider.getIntrinsicHeight()) / 2;
                    if (top < originTop) {
                        top = originTop;
                    }
                    bottom = top + this.mDivider.getIntrinsicHeight();
                    if (bottom > originBottom) {
                        bottom = originBottom;
                    }
                } else if (orientation == RecyclerView.VERTICAL) {
                    left = (originRight - originLeft - this.mDivider.getIntrinsicWidth()) / 2;
                    if (left < originLeft) {
                        left = originLeft;
                    }
                    right = left + this.mDivider.getIntrinsicWidth();
                    if (right > originRight) {
                        right = originRight;
                    }

                    top = child.getBottom() + params.bottomMargin + itemOffset;
                    bottom = top + this.mDivider.getIntrinsicHeight();
                }

                this.mDivider.setBounds(left, top, right, bottom);
                this.mDivider.draw(c);
            }

        }
    }
}
