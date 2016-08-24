package com.example.jaehoonjung.practice_interaction.Activity;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by jaehoonjung on 2016. 8. 22..
 */
public class CustomLayoutManager extends LinearLayoutManager {


    private Context mContext;
    private static final float MILLISECONDS_PER_INCH = 80f;


    public CustomLayoutManager(Context context) {
        super(context);
        this.mContext = context;

    }

    public CustomLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
        this.mContext = context;
    }


    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {

        LinearSmoothScroller smoothScroller = new LinearSmoothScroller(mContext) {

                    //Automatically implements this method on instantiation.
                    @Override
                    public PointF computeScrollVectorForPosition
                    (int targetPosition) {

                        return CustomLayoutManager.this.computeScrollVectorForPosition(targetPosition);
                    }
                    @Override
                    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        return MILLISECONDS_PER_INCH / displayMetrics.densityDpi;
                    }
                    @Override
                    public int calculateDyToMakeVisible(View view, int snapPreference) {
                        return super.calculateDyToMakeVisible(view, SNAP_TO_START);
                    }
                };

        smoothScroller.setTargetPosition(position);

        startSmoothScroll(smoothScroller);
    }

}
