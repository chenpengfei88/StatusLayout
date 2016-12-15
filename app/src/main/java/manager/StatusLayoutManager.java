package manager;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

/**
 * Created by chenpengfei on 2016/12/15.
 */
public class StatusLayoutManager {

    private final Context context;
    private final ViewStub netWorkErrorVs;
    private final ViewStub emptyDataVs;
    private final ViewStub errorVs;
    private final int loadingLayoutResId;
    private final int contentLayoutResId;

    private RootFrameLayout rootFrameLayout;

    public StatusLayoutManager(Builder builder) {
        this.context = builder.context;
        this.loadingLayoutResId = builder.loadingLayoutResId;
        this.netWorkErrorVs = builder.netWorkErrorVs;
        this.emptyDataVs = builder.emptyDataVs;
        this.errorVs = builder.errorVs;
        this.contentLayoutResId = builder.contentLayoutResId;

        rootFrameLayout = new RootFrameLayout(this.context);
        rootFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        addAllLayoutToRootLayout();
    }

    private void addAllLayoutToRootLayout() {
        if(this.contentLayoutResId != 0) rootFrameLayout.addLayoutResId(context, contentLayoutResId, RootFrameLayout.LAYOUT_CONTENT);
        if(this.loadingLayoutResId != 0) rootFrameLayout.addLayoutResId(context, loadingLayoutResId, RootFrameLayout.LAYOUT_LOADING);

        if(this.emptyDataVs != null) rootFrameLayout.addViewStub(emptyDataVs, RootFrameLayout.LAYOUT_EMPTYDATA);
        if(this.errorVs != null) rootFrameLayout.addViewStub(errorVs, RootFrameLayout.LAYOUT_ERROR);
        if(this.netWorkErrorVs != null) rootFrameLayout.addViewStub(netWorkErrorVs, RootFrameLayout.LAYOUT_NETWORKERROR);
    }

    /**
     *  显示loading
     */
    public void showLoading() {
        rootFrameLayout.showLoading();
    }

    /**
     *  显示内容
     */
    public void showContent() {
        rootFrameLayout.showContent();
    }

    /**
     *  显示空数据
     */
    public void showEmptyData() {
        rootFrameLayout.showEmptyData();
    }

    /**
     *  显示网络异常
     */
    public void showNetWorkError() {
        rootFrameLayout.showNetWorkError();
    }

    /**
     *  显示异常
     */
    public void showError() {
        rootFrameLayout.showError();
    }

    /**
     *  得到root 布局
     */
    public View getRootLayout() {
        return rootFrameLayout;
    }


    public static final class Builder {

        private Context context;
        private int loadingLayoutResId;
        private int contentLayoutResId;
        private ViewStub netWorkErrorVs;
        private ViewStub emptyDataVs;
        private ViewStub errorVs;


        public Builder(Context context) {
            this.context = context;
        }

        public Builder loadingView(@LayoutRes int loadingLayoutResId) {
            this.loadingLayoutResId = loadingLayoutResId;
            return this;
        }

        public Builder netWorkErrorView(@LayoutRes int newWorkErrorId) {
            netWorkErrorVs = new ViewStub(context);
            netWorkErrorVs.setLayoutResource(newWorkErrorId);
            return this;
        }

        public Builder emptyDataView(@LayoutRes int noDataViewId) {
            emptyDataVs = new ViewStub(context);
            emptyDataVs.setLayoutResource(noDataViewId);
            return this;
        }

        public Builder errorView(@LayoutRes int errorViewId) {
            errorVs = new ViewStub(context);
            errorVs.setLayoutResource(errorViewId);
            return this;
        }

        public Builder contentView(@LayoutRes int contentLayoutResId) {
            this.contentLayoutResId = contentLayoutResId;
            return this;
        }

        public StatusLayoutManager build() {
            return new StatusLayoutManager(this);
        }
    }

    public static Builder newBuilder(Context context) {
       return new Builder(context);
    }
}
