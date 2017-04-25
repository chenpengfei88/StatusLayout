package com.fe.statuslayout.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fe.statuslayout.Message;
import com.fe.statuslayout.R;
import java.util.List;

/**
 * Created by chenpengfei on 2016/10/27.
 */
public class MyAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<Message> mMessageList = null;
    private Activity mActivity;

    public MyAdapter(Activity activity, List<Message> messageList) {
        mActivity = activity;
        mMessageList = messageList;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == 1) {
            return new LeftViewHolder(View.inflate(mActivity, R.layout.activity_item_left, null));
        } else {
            return new RightViewHolder(View.inflate(mActivity, R.layout.activity_item_right, null));
        }
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mMessageList.get(position).getType();
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Message message = mMessageList.get(position);
        if(holder instanceof LeftViewHolder) {
            LeftViewHolder leftViewHolder = (LeftViewHolder) holder;
            leftViewHolder.tv.setText(message.getContent());
        }
        if(holder instanceof RightViewHolder) {
            RightViewHolder rightViewHolder = (RightViewHolder) holder;
            rightViewHolder.tv.setText(message.getContent());
        }
    }

    class LeftViewHolder extends BaseViewHolder {

        TextView tv;

        public LeftViewHolder(View view) {
            super(view);
            tv = (TextView) findViewById(R.id.textview_content);
        }
    }

    class RightViewHolder extends BaseViewHolder {

        TextView tv;

        public RightViewHolder(View view) {
            super(view);
            tv = (TextView) findViewById(R.id.textview_content);
        }
    }
}
