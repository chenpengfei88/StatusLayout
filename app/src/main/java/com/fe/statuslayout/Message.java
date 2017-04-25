package com.fe.statuslayout;

/**
 * Created by chenpengfei on 2016/10/27.
 */
public class Message {

    private String content;

    private int type;

    public Message(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public Message(String content) {
        this(content, 1);
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


}
