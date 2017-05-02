# StatusLayout （让你的布局飞起来）
### 版本 V1.0

 ![image](https://github.com/chenpengfei88/StatusLayout/blob/master/app/src/main/res/drawable/hao.gif)
 
#### 引用
 ```
allprojects {
	repositories {
		...
	       maven { url 'https://jitpack.io' }
	     }
	}
 
compile 'com.github.chenpengfei88:StatusLayout:1.0'
 ```


#### 使用
 ```
 StatusLayoutManager statusLayoutManager = StatusLayoutManager.newBuilder(this)
                .contentView(getContentView())
                .emptyDataView(R.layout.activity_emptydata)
                .errorView(R.layout.activity_error)
                .loadingView(R.layout.activity_loading)
                .netWorkErrorView(R.layout.activity_networkerror)
                .retryViewId(R.id.button_try)
                .onShowHideViewListener(new OnShowHideViewListener() {
                    @Override
                    public void onShowView(View view, int id) {
                    }

                    @Override
                    public void onHideView(View view, int id) {
                    }
                }).onRetryListener(new OnRetryListener() {
                    @Override
                    public void onRetry() {
                        statusLayoutManager.showLoading();

                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        statusLayoutManager.showContent();
                                    }
                                });
                            }
                        }).start();

                    }
                }).build();

        mainLinearLayout.addView(statusLayoutManager.getRootLayout(), 1);
 ```

#### 方法

 StatusLayoutManager提供了一系列的方法来显示不同布局View之间的切换
 
  ```
   statusLayoutManager.showLoading();  显示loading加载view
   statusLayoutManager.showContent();  显示你的内容view
   statusLayoutManager.showEmptyData();  显示空数据view
   statusLayoutManager.showEmptyData(R.mipmap.empty_nodata, "暂时没有数据");
   statusLayoutManager.showError();  显示error view
   statusLayoutManager.showError(R.mipmap.empty_nodata, "服务器异常");
   statusLayoutManager.showNetWorkError();   显示网络异常view
   
  ```
  
  #### 源码逻辑解析
http://www.jianshu.com/p/9d53893b3eda
