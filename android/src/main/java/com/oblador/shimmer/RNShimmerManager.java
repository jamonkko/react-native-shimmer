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
        // Not supported
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
        // Not supported
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
        view.setShimmerAnimationDelay(value);
        view.invalidate();
    }

    @ReactProp(name = "tilt", defaultInt = 0)
    public void setTilt(RNShimmeringView view, int value) {
        view.setShimmerAngle(value);
        view.invalidate();
    }

    @ReactProp(name = "speed", defaultInt = 230)
    public void setSpeed(RNShimmeringView view, int value) {
        // Not supported
    }

    @ReactProp(name = "invert", defaultBoolean = false)
    public void setInvert(RNShimmeringView view, boolean value) {
        // Not supported
    }

    @ReactProp(name = "echo", defaultBoolean = true)
    public void setShimColor(RNShimmeringView view, boolean enabled) {
        view.enableShimmerEcho(enabled);
        view.invalidate();
    }

}
