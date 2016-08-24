package com.example.jaehoonjung.practice_interaction.Activity;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jaehoonjung.practice_interaction.R;

/**
 * Created by jaehoonjung on 2016. 8. 23..
 */
public class FadingRelativeLayout extends RelativeLayout {

    public FadingRelativeLayout(Context context) {
        super(context);
    }

    public FadingRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FadingRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    int minHeight, maxHeight;
    boolean isSetSize = false;

    static float minValue = 0.6f;
    static float maxValue = 1f;

    public static float getMinValue(){
        return minValue;
    }
    public static float getMaxValue(){
        return maxValue;
    }

    public void setHeightRange(int minHeight, int maxHeight){
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        isSetSize = true;
    }

    @Override
    public void requestLayout() {
        super.requestLayout();
        setChangeRatio();
    }

    public void setChangeRatio(){
        float scaleUpValue = (((getMeasuredHeight() - minHeight) * (maxValue - minValue)) / (maxHeight - minHeight)) + minValue;
        float scaleDownValue = ((getMeasuredHeight() - minHeight) * ((minValue - maxValue) / (maxHeight - minHeight))) + maxValue;

        if(findViewById(R.id.titleTextView) != null){
            ((TextView)findViewById(R.id.titleTextView)).setTextScaleX(scaleUpValue);
            ((TextView)findViewById(R.id.titleTextView)).setScaleY(scaleUpValue);
        }

        if(findViewById(R.id.coverView) != null)
            findViewById(R.id.coverView).setAlpha(scaleDownValue);

    }

}
