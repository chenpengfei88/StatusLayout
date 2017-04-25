package com.fe.statuslayout;

import android.content.Context;
import android.widget.Button;

import com.free.statuslayout.manager.AbsLayout;

/**
 * Created by chenpengfei on 2017/4/25.
 */
public class EmptyDataLayout extends AbsLayout {

    public EmptyDataLayout(Context context) {
        initLayout(R.layout.activity_layout_emptydata, context);
    }

    @Override
    protected void setData(Object... objects) {
        if (mContentView == null) return;
        Button button = (Button) mContentView.findViewById(R.id.button_content);
        button.setText((String) objects[0]);
    }
}
