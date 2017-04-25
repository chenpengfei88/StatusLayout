package com.free.statuslayout.manager;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewStub;

/**
 * Created by chenpengfei on 2017/4/25.
 */
public abstract class AbsLayout {

    protected ViewStub mLayoutVs;

    protected View mContentView;

    protected void initLayout(@LayoutRes int layoutResId, Context context) {
        mLayoutVs = new ViewStub(context);
        mLayoutVs.setLayoutResource(layoutResId);
    }

    protected ViewStub getLayoutVs() {
        return mLayoutVs;
    }

    protected void setView(View contentView) {
        mContentView = contentView;
    }

    protected abstract void setData(Object... objects);
}
