package com.example.jaehoonjung.practice_interaction.Activity;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by jaehoonjung on 2016. 8. 23..
 */
public class CustomRecyclerView extends RecyclerView {

    Context mContext;
    MagazineAdapter mAdapter;
    CustomLayoutManager mCustomLayoutManager;

    public CustomRecyclerView(Context context) {
        super(context);
        this.mContext = context;
    }

    public CustomRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
        this.mAdapter = (MagazineAdapter) adapter;
    }

    @Override
    public void setLayoutManager(LayoutManager layout) {
        super.setLayoutManager(layout);
        this.mCustomLayoutManager = (CustomLayoutManager) layout;
    }

    @Override
    public void onScrolled(int dx, int dy) {

        super.onScrolled(dx, dy);

        int hidingItemCount = mCustomLayoutManager.findFirstVisibleItemPosition();

        int hideHeight = mCustomLayoutManager.getChildAt(0).getTop() / 2;

        MagazineAdapter.ViewHolder hidingItemViewHolder =
                (MagazineAdapter.ViewHolder) findViewHolderForLayoutPosition(mCustomLayoutManager.findFirstVisibleItemPosition()+1);
        hidingItemViewHolder.itemLayout.getLayoutParams().height = mAdapter.minHeight - hideHeight;
        hidingItemViewHolder.itemLayout.requestLayout();

        mAdapter.setLastFullSizePosition(mCustomLayoutManager.findFirstCompletelyVisibleItemPosition() - 1);

        if(hidingItemCount == 0){
            mAdapter.setLastFullSizePosition(0);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        gestureDetector.onTouchEvent(e);
        return super.onTouchEvent(e);
    }

    GestureDetector gestureDetector = new GestureDetector(mContext, new GestureDetector.OnGestureListener() {
        @Override
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        @Override
        public void onShowPress(MotionEvent motionEvent) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {

            return false;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {

        }

        @Override
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            if(v1 > 300){
                if(mCustomLayoutManager.findFirstCompletelyVisibleItemPosition() != 0)
                    smoothScrollToPosition(mCustomLayoutManager.findFirstCompletelyVisibleItemPosition() - 1);
                else
                    smoothScrollToPosition(0);
            }else if(v1 < -300){
                smoothScrollToPosition(mCustomLayoutManager.findFirstVisibleItemPosition() + 1);
            }



            return false;
        }
    });;
}
