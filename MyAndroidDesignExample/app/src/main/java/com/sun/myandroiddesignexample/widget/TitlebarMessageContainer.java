package com.sun.myandroiddesignexample.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.sun.myandroiddesignexample.R;

/**
 * Created by sunxiaoling on 16/4/12.
 */
public class TitlebarMessageContainer extends RelativeLayout {
    private static final String TAG = TitlebarMessageContainer.class.getSimpleName();
    public static final int ANIMATION_DURATION = 800;

    private ObjectAnimator mOpenMainAppbarLayoutAnimator;
    private ObjectAnimator mCloseMainAppbarLayoutAnimator;
    private ObjectAnimator mOpenTripInfoAppbarLayoutAnimator;
    private ObjectAnimator mCloseTripInfoAppbarLayoutAnimator;

    private Animation mOpenAnimation;
    private Animation mCloseAnimation;

    private View root;
    private AppBarLayout appBarLayoutMain;
    private AppBarLayout appBarLayoutTripInfo;

    public TitlebarMessageContainer(Context context) {
        super(context);
        init();
    }

    public TitlebarMessageContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TitlebarMessageContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        root = LayoutInflater.from(getContext()).inflate(R.layout.title_bar_container, this);
        appBarLayoutMain = (AppBarLayout) root.findViewById(R.id.appbar_layout_main);
        appBarLayoutTripInfo = (AppBarLayout) root.findViewById(R.id.appbar_layout_trip_info);
//        root.setVisibility(VISIBLE);

//        createAnimation();
    }

    private void createAnimation() {
        mOpenAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.open_title_bar_container_animation);
        mCloseAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.close_title_bar_container_animation);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        createAnimator4MainAppbarLayout();
        createAnimator4TripInfoAppbarLayout();
    }

    private void createAnimator4MainAppbarLayout() {
        int height = appBarLayoutMain.getHeight();
        Log.i(TAG, "appBarLayoutMain height: " + height);

//        mOpenMainAppbarLayoutAnimator = ObjectAnimator.ofFloat(root, "Y", 0, height);
//        mOpenMainAppbarLayoutAnimator.setDuration(ANIMATION_DURATION);
//        mCloseMainAppbarLayoutAnimator = ObjectAnimator.ofFloat(root, "Y", height, 0);
//        mCloseMainAppbarLayoutAnimator.setDuration(ANIMATION_DURATION);

//        mOpenMainAppbarLayoutAnimator = ObjectAnimator.ofInt(appBarLayoutMain, "ScrollY", height, 0);
        mOpenMainAppbarLayoutAnimator = ObjectAnimator.ofFloat(appBarLayoutMain, "Y", -height, 0f);
        mOpenMainAppbarLayoutAnimator.setDuration(ANIMATION_DURATION);
        mOpenMainAppbarLayoutAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                appBarLayoutMain.setVisibility(VISIBLE);
            }
        });

//        mCloseMainAppbarLayoutAnimator = ObjectAnimator.ofInt(appBarLayoutMain, "ScrollY", 0, height);
        mCloseMainAppbarLayoutAnimator = ObjectAnimator.ofFloat(appBarLayoutMain, "Y", 0f, -height);
        mCloseMainAppbarLayoutAnimator.setDuration(ANIMATION_DURATION);
        mCloseMainAppbarLayoutAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                appBarLayoutMain.setVisibility(GONE);
            }
        });
    }

    private void createAnimator4TripInfoAppbarLayout() {
        int height = appBarLayoutTripInfo.getHeight();
        Log.i(TAG, "appBarLayoutTripInfo height: " + height);

//        mOpenTripInfoAppbarLayoutAnimator = ObjectAnimator.ofInt(appBarLayoutTripInfo, "ScrollY", height, 0);
        mOpenTripInfoAppbarLayoutAnimator = ObjectAnimator.ofFloat(appBarLayoutTripInfo, "Y", -height, 0f);
        mOpenTripInfoAppbarLayoutAnimator.setDuration(ANIMATION_DURATION);
        mOpenTripInfoAppbarLayoutAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                appBarLayoutTripInfo.setVisibility(VISIBLE);
            }
        });

//        mCloseTripInfoAppbarLayoutAnimator = ObjectAnimator.ofInt(appBarLayoutTripInfo, "ScrollY", 0, height);
        mCloseTripInfoAppbarLayoutAnimator = ObjectAnimator.ofFloat(appBarLayoutTripInfo, "Y", 0f, -height);
        mCloseTripInfoAppbarLayoutAnimator.setDuration(ANIMATION_DURATION);
        mCloseTripInfoAppbarLayoutAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                appBarLayoutTripInfo.setVisibility(GONE);
            }
        });
    }

    public void openTripInfoView() {
//        mOpenMainAppbarLayoutAnimator.start();
//        root.startAnimation(mOpenAnimation);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(mOpenTripInfoAppbarLayoutAnimator, mCloseMainAppbarLayoutAnimator);
        animatorSet.start();
    }

    public void closeTripInfoView() {
//        mCloseMainAppbarLayoutAnimator.start();
//        root.startAnimation(mCloseAnimation);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(mCloseTripInfoAppbarLayoutAnimator, mOpenMainAppbarLayoutAnimator);
        animatorSet.start();
    }

    public boolean isTripInfoViewShown() {
        return appBarLayoutTripInfo.isShown();
    }

    public boolean isMainAppbarLayoutShown() {
        return appBarLayoutMain.isShown();
    }

    @Override
    public void setScrollY(int value) {
        Log.d(TAG, "setScrollY: " + value);
        super.setScrollY(value);
    }

    @Override
    public void setY(float y) {
        Log.d(TAG, "setY: " + y);
        super.setY(y);
    }
}
