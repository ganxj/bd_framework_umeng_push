package com.umeng.push.entity;


import com.umeng.push.entity.eunm.AfterOpenType;

/**
 * Created by gange on 2017/4/27.
 */
public class PushBody {
    // 通知展现内容:
    // 必填 通知栏提示文字
    private String ticker;

    // 必填 通知标题
    private String title;

    // 必填 通知文字描述
    private String text;

    // 自定义通知图标:
    // 可选 状态栏图标ID, R.drawable.[smallIcon],
    private String icon;

    // 可选 通知栏拉开后左侧图标ID, R.drawable.[largeIcon].
    private String largeIcon;

    // 可选 通知栏大图标的URL链接。该字段的优先级大于largeIcon。
    private String img;

    // 可选 通知声音，R.raw.[sound].
    private String sound;

    private String builder_id;

    // 通知到达设备后的提醒方式
    // 可选 收到通知是否震动,默认为"true".
    private Boolean play_vibrate;

    // 可选 收到通知是否闪灯,默认为"true"
    private Boolean play_lights;

    // 可选 收到通知是否发出声音,默认为"true"
    private Boolean play_sound;

    // 点击"通知"的后续行为，默认为打开app。
    private AfterOpenType after_open;

    // 可选 当"after_open"为"go_url"时，必填。
    private String url;

    // 可选 当"after_open"为"go_activity"时，必填。
    private String activity;

    // 可选 display_type=message, 或者display_type=notification且"after_open"为"go_custom"时，该字段必填。用户自定义内容, 可以为字符串或者JSON格式。
    private String custom;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLargeIcon() {
        return largeIcon;
    }

    public void setLargeIcon(String largeIcon) {
        this.largeIcon = largeIcon;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getBuilder_id() {
        return builder_id;
    }

    public void setBuilder_id(String builder_id) {
        this.builder_id = builder_id;
    }

    public Boolean getPlay_vibrate() {
        return play_vibrate;
    }

    public void setPlay_vibrate(Boolean play_vibrate) {
        this.play_vibrate = play_vibrate;
    }

    public Boolean getPlay_lights() {
        return play_lights;
    }

    public void setPlay_lights(Boolean play_lights) {
        this.play_lights = play_lights;
    }

    public Boolean getPlay_sound() {
        return play_sound;
    }

    public void setPlay_sound(Boolean play_sound) {
        this.play_sound = play_sound;
    }

    public AfterOpenType getAfter_open() {
        return after_open;
    }

    public void setAfter_open(AfterOpenType after_open) {
        this.after_open = after_open;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }
}
