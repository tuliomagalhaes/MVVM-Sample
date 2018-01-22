package com.tuliohdev.mvvmsample.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

/**
 * Created by tulio on 16/01/2018.
 */

public class ResourcesManager {

    Context mContext;

    public String getString(int stringRes) {
        return mContext.getResources().getString(stringRes);
    }

    public Drawable getDrawable(int drawableRes) {
        return ContextCompat.getDrawable(mContext, drawableRes);
    }

    public float getDimension(int dimensionRes) {
        return mContext.getResources().getDimension(dimensionRes);
    }
}
