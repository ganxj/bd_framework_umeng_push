package com.umeng.push.entity;

/**
 * Created by gange on 2017/4/27.
 */
public class Policy {
    // 可选 定时发送时间，若不填写表示立即发送。
    private String start_time;

    // 可选 消息过期时间,其值不可小于发送时间或者
    private String expire_time;

    // 可选 发送限速，每秒发送的最大条数。
    private String max_send_num;

    // 可选 开发者对消息的唯一标识，服务器会根据这个标识避免重复发送。
    private String out_biz_no;

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(String expire_time) {
        this.expire_time = expire_time;
    }

    public String getMax_send_num() {
        return max_send_num;
    }

    public void setMax_send_num(String max_send_num) {
        this.max_send_num = max_send_num;
    }

    public String getOut_biz_no() {
        return out_biz_no;
    }

    public void setOut_biz_no(String out_biz_no) {
        this.out_biz_no = out_biz_no;
    }
}
