package com.hhzmy.recyclerview;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by johpo on 2016/11/10 0010.
 */
public   abstract class ItemDecoration {
 /*   public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        onDraw(c, parent);
    }*/


  /*  public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        onDrawOver(c, parent);
    }*/



    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        getItemOffsets(outRect, ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition(),
                parent);
    }

    @Deprecated
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
        outRect.set(0, 0, 0, 0);
    }
}