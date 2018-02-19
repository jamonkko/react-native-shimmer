package com.oblador.shimmer;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

import static android.graphics.Color.parseColor;

public class RNShimmerManager extends ViewGroupManager<RNShimmeringView> {

    public static final String REACT_CLASS = "RNShimmeringView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public RNShimmeringView createViewInstance(ThemedReactContext context) {
        return new RNShimmeringView(context);
    }

    @ReactProp(name = "animating", defaultBoolean = true)
    public void setAnimating(RNShimmeringView view, boolean value) {
        if (value) {
            view.startShimmerAnimation();
        } else {
            view.stopShimmerAnimation();
        }
    }

    @ReactProp(name = "shimmeringOpacity", defaultFloat = 0.5f)
    public void setShimmeringOpacity(RNShimmeringView view, float value) {
        throw new IllegalArgumentException("'shimmeringOpacity' not supported for Android ShimmerLayout. Use instead the alpha-channel of 'color' to control opacity of shimmer e.g. color: '#FFFFFF33'");
    }

    @ReactProp(name = "intensity", defaultFloat = 0.0f)
    public void setIntensity(RNShimmeringView view, float value) {
        view.setGradientCenterColorWidth(value);
        view.invalidate();
    }

    @ReactProp(name = "shimColor", customType = "Color")
    public void setShimColor(RNShimmeringView view, int color) {
        view.setShimmerColor(color);
        view.invalidate();
    }

    @ReactProp(name = "shimWidth", defaultFloat = 0.5f)
    public void setShimWidth(RNShimmeringView view, float width) {
        view.setMaskWidth(width);
        view.invalidate();
    }

    @ReactProp(name = "shimmeringDirection")
    public void setAnimating(RNShimmeringView view, String value) {
        throw new IllegalArgumentException("'shimmeringDirection' not supported for Android ShimmerLayout");
    }

    @ReactProp(name = "duration", defaultInt = 1000)
    public void setDuration(RNShimmeringView view, int value) {
        view.setShimmerAnimationDuration(value);
        view.invalidate();
    }


    @ReactProp(name = "pauseDuration", defaultInt = 400)
    public void setPauseDuration(RNShimmeringView view, int value) {
        if (value < 0) {
            value = 0;
        }
        view.setShimmerAnimationStartDelay(value);
        view.invalidate();
    }

    @ReactProp(name = "tilt", defaultInt = 0)
    public void setTilt(RNShimmeringView view, int value) {
        view.setShimmerAngle(value);
        view.invalidate();
    }

    @ReactProp(name = "speed", defaultInt = 230)
    public void setSpeed(RNShimmeringView view, int value) {
        throw new IllegalArgumentException("'speed' not supported for Android ShimmerLayout, calculate and use duration instead.");
    }

    @ReactProp(name = "invert", defaultBoolean = false)
    public void setInvert(RNShimmeringView view, boolean value) {
        throw new IllegalArgumentException("'invert' not supported for Android ShimmerLayout, use 'color' instead.");
    }
}
