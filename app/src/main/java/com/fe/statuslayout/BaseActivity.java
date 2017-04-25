package com.fe.statuslayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.LinearLayout;
import com.free.statuslayout.manager.StatusLayoutManager;

/**
 * Created by chenpengfei on 2017/3/14.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected StatusLayoutManager statusLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        initStatusLayout();

        LinearLayout mainLl = (LinearLayout) findViewById(R.id.main_rl);
        mainLl.addView(statusLayoutManager.getRootLayout());

        initToolBar();
    }


    protected abstract void initStatusLayout();

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.tb_bar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle("StatusLayout");
        toolbar.inflateMenu(R.menu.base_toolbar_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.action_content) {
                    statusLayoutManager.showContent();
                }
                if(item.getItemId() == R.id.action_emptyData) {
                    showEmptyData();
                }
                if(item.getItemId() == R.id.action_error) {
                    showError();
                }
                if(item.getItemId() == R.id.action_networkError) {
                    statusLayoutManager.showNetWorkError();
                }
                if(item.getItemId() == R.id.action_loading) {
                    statusLayoutManager.showLoading();
                }
                return true;
            }
        });
    }

    protected void showEmptyData() {
        statusLayoutManager.showEmptyData();
    }

    protected void showError() {
        statusLayoutManager.showError();
    }
}
