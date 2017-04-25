package com.fe.statuslayout;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.fe.statuslayout.adapter.MyAdapter;
import com.free.statuslayout.manager.StatusLayoutManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenpengfei on 2017/4/25.
 */
public class OneStepActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        statusLayoutManager.showLoading();
        initView();
    }

    @Override
    protected void initStatusLayout() {
        statusLayoutManager = StatusLayoutManager.newBuilder(this)
                .contentView(R.layout.activity_content)
                .emptyDataView(R.layout.activity_emptydata)
                .errorView(R.layout.activity_error)
                .loadingView(R.layout.activity_loading)
                .netWorkErrorView(R.layout.activity_networkerror).build();
    }

    private void initView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(this, getMessageList()));
    }

    private List<Message> getMessageList() {
        List<Message> messageList = new ArrayList<>(11);
        messageList.add(new Message("队长别开枪，是我"));
        messageList.add(new Message("是——你小子", 2));
        messageList.add(new Message("是你老子我"));
        messageList.add(new Message("啊！是你把敌人引到这儿来的？ ", 2));
        messageList.add(new Message("恩……嘿嘿……队长。（嬉皮笑脸）呃黄军让 我给您带个话儿（边说边把朱引得背对观众）只要 你能够投降黄军"));
        messageList.add(new Message("哎！等等！我怎么成了背对观众了", 2));
        messageList.add(new Message("我怎么知道"));
        messageList.add(new Message("你位置站错了吧！", 2));
        messageList.add(new Message("你说怎么站"));
        messageList.add(new Message("你这么站！ ", 2));
        messageList.add(new Message("我干吗这么站"));
        messageList.add(new Message("（不耐烦）你就这么站！", 2));
        messageList.add(new Message("（陈侧站，脸偏向观众。朱把他的脸拨正，陈    再偏。如此反复三次）哎我这——我这么站着怎么 能成啊！"));
        messageList.add(new Message("怎么不成啊", 2));
        messageList.add(new Message("观众只能看到我侧脸啊"));
        messageList.add(new Message("这就对了，你是配角！", 2));
        messageList.add(new Message("（无言以对）哎配角就只配露-半张脸啊！哪有    这个道理嘛！"));
        messageList.add(new Message("哎呀。你可以把这半张脸的戏挪到那半脸上去  嘛。", 2));
        messageList.add(new Message("（指着另外半边脸）那我这半张脸怎么办？"));
        messageList.add(new Message("不要了！", 2));
        messageList.add(new Message("都放这面儿。"));
        messageList.add(new Message("恩。", 2));
        messageList.add(new Message("这可就是二皮脸了。"));
        messageList.add(new Message("你演的就是二皮脸嘛！不能抢戏！对不对。你这个地方要始终保持我的正面给观众。。", 2));
        messageList.add(new Message("好！行！我就保证你的正面给观众！。"));
        return messageList;
    }

}
