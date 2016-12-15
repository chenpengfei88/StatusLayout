package manager;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;

/**
 * Created by chenpengfei on 2016/12/15.
 */
public class RootFrameLayout extends FrameLayout {


    public static final int LAYOUT_LOADING = 1;

    public static final int LAYOUT_CONTENT = 2;

    public static final int LAYOUT_ERROR = 3;

    public static final int LAYOUT_NETWORKERROR = 4;

    public static final int LAYOUT_EMPTYDATA = 5;

    /**
     *  存放布局集合
     */
    private SparseArray<View> layoutSparseArray = new SparseArray();

    /**
     *  网络布局
     */
    private ViewStub netWorkErrorVs;

    /**
     * 空数据布局
     */
    private ViewStub emptyDataVs;

    /**
     * 异常布局
     */
    private ViewStub errorVs;

    public RootFrameLayout(Context context) {
        super(context);
    }

    public RootFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RootFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RootFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void addLayoutResId(Context context, @LayoutRes int layoutResId, int id) {
        View resView = LayoutInflater.from(context).inflate(layoutResId, null);
        layoutSparseArray.put(id, resView);
        addView(resView);
    }

    public void addViewStub(ViewStub viewStub, int id) {
        switch (id) {
            case LAYOUT_NETWORKERROR:
                netWorkErrorVs = viewStub;
                addView(netWorkErrorVs);
                break;
            case LAYOUT_ERROR:
                errorVs = viewStub;
                addView(errorVs);
                break;
            case LAYOUT_EMPTYDATA:
                emptyDataVs = viewStub;
                addView(emptyDataVs);
                break;
        }
    }

    /**
     *  显示loading
     */
    public void showLoading() {
        showHideView(LAYOUT_LOADING);
    }

    /**
     *  显示内容
     */
    public void showContent() {
        showHideView(LAYOUT_CONTENT);
    }

    /**
     *  显示空数据
     */
    public void showEmptyData() {
        inflateLayout(LAYOUT_EMPTYDATA);
        showHideView(LAYOUT_EMPTYDATA);
    }

    /**
     *  显示网络异常
     */
    public void showNetWorkError() {
        inflateLayout(LAYOUT_NETWORKERROR);
        showHideView(LAYOUT_NETWORKERROR);
    }

    /**
     *  显示异常
     */
    public void showError() {
        inflateLayout(LAYOUT_ERROR);
        showHideView(LAYOUT_ERROR);
    }

    /**
     *  根据ID显示隐藏布局
     * @param id
     */
    private void showHideView(int id) {
        for(int i = 0; i < layoutSparseArray.size(); i++) {
            int key = layoutSparseArray.keyAt(i);
            View valueView = layoutSparseArray.valueAt(i);
            if(id == key) {
                valueView.setVisibility(View.VISIBLE);
            } else {
                valueView.setVisibility(View.GONE);
            }
        }
    }

    private void inflateLayout(int id) {
        if(layoutSparseArray.get(id) != null) return;
        switch (id) {
            case LAYOUT_NETWORKERROR:
                if(netWorkErrorVs != null) {
                    View view = netWorkErrorVs.inflate();
                    layoutSparseArray.put(id, view);
                }
                break;
            case LAYOUT_ERROR:
                if(errorVs != null) {
                    View view = errorVs.inflate();
                    layoutSparseArray.put(id, view);
                }
                break;
            case LAYOUT_EMPTYDATA:
                if(emptyDataVs != null) {
                    View view = emptyDataVs.inflate();
                    layoutSparseArray.put(id, view);
                }
                break;
        }
    }
}
