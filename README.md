# StatusLayout
让你的布局飞起来


在我们平时的项目开发当中一般都会有不同的布局View之间的切换，比如：loadingView， contentView， errorView等等，本项目就是用一个管理类来把这些布局view管理封装起来，使view之间的切换更加简洁方便。

# 使用方法
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolBar();

        LinearLayout mainLinearLayout = (LinearLayout) findViewById(R.id.main_rl);
        
        statusLayoutManager = StatusLayoutManager.newBuilder(this)
                .contentView(R.layout.activity_content)
                .emptyDataView(R.layout.activity_emptydata)
                .errorView(R.layout.activity_error)
                .loadingView(R.layout.activity_loading)
                .netWorkErrorView(R.layout.activity_networkerror)
                .build();
                
        mainLinearLayout.addView(statusLayoutManager.getRootLayout(), 1);
        
        statusLayoutManager.showLoading();
    }
    
 这里用到了builder模式，可以自由的添加你需要的布局View，通过statusLayoutManager.getRootLayout()方法可以得到管理这些布局View的根布局，然后把它添加到你Activity中xml文件的根布局当中。
 
 StatusLayoutManager提供了一系列的方法来显示不同布局View之间的切换
 
  
  statusLayoutManager.showLoading();  显示loading加载view
  
  
  statusLayoutManager.showContent();  显示你的内容view
  
  
  statusLayoutManager.showEmptyData();  显示空数据view
  
  
  statusLayoutManager.showError();  显示error view
  
 
   statusLayoutManager.showNetWorkError();   显示网络异常view
