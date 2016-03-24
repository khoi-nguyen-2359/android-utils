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

    public SimpleDividerItemDec(Drawable divider, int orientation, int itemOffset) {
        this.mDivider = divider;
        this.orientation = orientation;
        this.itemOffset = itemOffset;
    }

    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, State state) {
        int childPosition = parent.getChildAdapterPosition(view);
        int left = 0;
        int top = 0;
        int right = 0;
        int bottom = 0;
        if(this.orientation == 1) {
            bottom = this.itemOffset;
        } else if(this.orientation == 0) {
            right = this.itemOffset;
        }

        if(this.orientation == 1) {
            top = (this.mDivider != null && childPosition != 0?this.mDivider.getIntrinsicHeight():0) + this.itemOffset;
        } else if(this.orientation == 0) {
            left = (this.mDivider != null && childPosition != 0?this.mDivider.getIntrinsicWidth():0) + this.itemOffset;
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
                if(this.orientation != 1) {
                    if(this.orientation == 0) {
                        left = child.getRight() + params.rightMargin + this.itemOffset;
                        right = left + this.mDivider.getIntrinsicWidth();
                        top = originTop;
                        bottom = this.mDivider.getIntrinsicHeight();
                        if(bottom <= 0 || bottom > originBottom) {
                            bottom = originBottom;
                        }
                    }
                } else {
                    left = originLeft;
                    right = this.mDivider.getIntrinsicWidth();
                    if(right <= 0 || right > originRight) {
                        right = originRight;
                    }

                    top = child.getBottom() + params.bottomMargin + this.itemOffset;
                    bottom = top + this.mDivider.getIntrinsicHeight();
                }

                this.mDivider.setBounds(left, top, right, bottom);
                this.mDivider.draw(c);
            }

        }
    }
}
