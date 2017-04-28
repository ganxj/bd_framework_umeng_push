package com.umeng.push.entity;


import com.umeng.push.entity.eunm.PushType;

/**
 * Created by gange on 2017/4/27.
 */
public class AndroidPushBean {
    // 必填 应用唯一标识
    private String appkey;

    // 必填 时间戳，10位或者13位均可，时间戳有效期为10分钟
    private Long timestamp;

    // 必填 消息发送类型,其值可以为:
    private PushType type;

    // 可选 设备唯一表示
    private String device_tokens;

    // 可选 当type=customizedcast时，必填，alias的类型,
    private String alias_type;

    // 可选 当type=customizedcast时, 开发者填写自己的alias。
    private String alias;

    // 可选 当type=filecast时，file内容为多条device_token,
    private String file_id;

    // 可选 终端用户筛选条件,如用户标签、地域、应用版本以及渠道等,
    private String filter;

    private AndroidPayLoad payload;

    private Policy policy;

    // 可选 正式/测试模式。测试模式下，只会将消息发给测试设备。
    private Boolean production_mode;

    // 可选 发送消息描述，建议填写。
    private String description;

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public PushType getType() {
        return type;
    }

    public void setType(PushType type) {
        this.type = type;
    }

    public String getDevice_tokens() {
        return device_tokens;
    }

    public void setDevice_tokens(String device_tokens) {
        this.device_tokens = device_tokens;
    }

    public String getAlias_type() {
        return alias_type;
    }

    public void setAlias_type(String alias_type) {
        this.alias_type = alias_type;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getFile_id() {
        return file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public AndroidPayLoad getPayload() {
        return payload;
    }

    public void setPayload(AndroidPayLoad payload) {
        this.payload = payload;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public Boolean getProduction_mode() {
        return production_mode;
    }

    public void setProduction_mode(Boolean production_mode) {
        this.production_mode = production_mode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
