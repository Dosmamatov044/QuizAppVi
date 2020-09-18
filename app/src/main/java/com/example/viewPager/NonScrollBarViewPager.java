package com.example.viewPager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

 public class NonScrollBarViewPager extends ViewPager {
private boolean isScrollBarEvent=false;

    public NonScrollBarViewPager(@NonNull Context context) {
        super(context);
    }

    public NonScrollBarViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return  isScrollBarEvent && super.onTouchEvent(ev);

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return isScrollBarEvent&& super.onInterceptTouchEvent(ev);
    }
}
