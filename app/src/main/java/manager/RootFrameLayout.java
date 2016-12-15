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
        if(layoutSparseArray.get(LAYOUT_LOADING) != null)
            showHideViewById(LAYOUT_LOADING);
    }

    /**
     *  显示内容
     */
    public void showContent() {
        if(layoutSparseArray.get(LAYOUT_CONTENT) != null)
            showHideViewById(LAYOUT_CONTENT);
    }

    /**
     *  显示空数据
     */
    public void showEmptyData() {
        if(inflateLayout(LAYOUT_EMPTYDATA))
            showHideViewById(LAYOUT_EMPTYDATA);
    }

    /**
     *  显示网络异常
     */
    public void showNetWorkError() {
        if(inflateLayout(LAYOUT_NETWORKERROR))
            showHideViewById(LAYOUT_NETWORKERROR);
    }

    /**
     *  显示异常
     */
    public void showError() {
        if(inflateLayout(LAYOUT_ERROR))
            showHideViewById(LAYOUT_ERROR);
    }

    /**
     *  根据ID显示隐藏布局
     * @param id
     */
    private void showHideViewById(int id) {
        for(int i = 0; i < layoutSparseArray.size(); i++) {
            View valueView = layoutSparseArray.valueAt(i);
            valueView.setVisibility(id == layoutSparseArray.keyAt(i) ? View.VISIBLE : View.GONE);
        }
    }

    private boolean inflateLayout(int id) {
        boolean isShow = true;
        if(layoutSparseArray.get(id) != null) return isShow;
        switch (id) {
            case LAYOUT_NETWORKERROR:
                if(netWorkErrorVs != null) {
                    View view = netWorkErrorVs.inflate();
                    layoutSparseArray.put(id, view);
                    isShow = true;
                } else {
                    isShow = false;
                }
                break;
            case LAYOUT_ERROR:
                if(errorVs != null) {
                    View view = errorVs.inflate();
                    layoutSparseArray.put(id, view);
                    isShow = true;
                } else {
                    isShow = false;
                }
                break;
            case LAYOUT_EMPTYDATA:
                if(emptyDataVs != null) {
                    View view = emptyDataVs.inflate();
                    layoutSparseArray.put(id, view);
                    isShow = true;
                } else {
                    isShow = false;
                }
                break;
        }
        return isShow;
    }
}
