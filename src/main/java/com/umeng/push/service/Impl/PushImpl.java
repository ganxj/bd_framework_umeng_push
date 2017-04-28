package com.umeng.push.service.Impl;

import com.umeng.push.entity.*;
import com.umeng.push.entity.eunm.AfterOpenType;
import com.umeng.push.entity.eunm.DisplayType;
import com.umeng.push.entity.eunm.PushType;
import com.umeng.push.service.Push;
import com.umeng.push.umeng.AndroidNotification;
import com.umeng.push.umeng.PushClient;
import com.umeng.push.umeng.android.AndroidBroadcast;
import com.umeng.push.umeng.android.AndroidUnicast;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by gange on 2017/4/27.
 */
public class PushImpl implements Push {

    private String umengUrl;
    private String appkey;
    private String appMasterSecret;
    private PushClient client;

    public PushImpl(String umengUrl, String appkey, String appMasterSecret) {
        this.umengUrl = umengUrl;
        this.appkey = appkey;
        this.appMasterSecret = appMasterSecret;
        client = new PushClient();

    }

    /**
     * 广播发送
     *
     * @param title
     * @param text
     */
    @Override
    public void pushAndroidBroadcast(String title, String text) {
        AndroidBroadcast broadcast = null;
        try {
            broadcast = new AndroidBroadcast(appkey, appMasterSecret);
            broadcast.setTicker(title);
            broadcast.setTitle(title);
            broadcast.setText(text);
            broadcast.goAppAfterOpen();
            broadcast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
            // TODO Set 'production_mode' to 'false' if it's a test device.
            // For how to register a test device, please see the developer doc.
            broadcast.setProductionMode();
            // Set customized fields
//            broadcast.setExtraField("test", "helloworld");
            client.send(broadcast);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void pushAndroidUnicast(String title, String text, String deviceTokens, List<Extra> extras , String activityPath) {
        AndroidUnicast unicast = null;
        try {
            unicast = new AndroidUnicast(appkey, appMasterSecret);
            // TODO Set your device token
            unicast.setDeviceToken(deviceTokens);
            unicast.setTicker(title);
            unicast.setTitle(title);
            unicast.setText(text);
//            unicast.goAppAfterOpen();
            if (activityPath == null || activityPath.equals("")){
                activityPath = "com.xiaohongren.activity.GuideActivity";
            }
            unicast.goActivityAfterOpen(activityPath);
            unicast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
            // TODO Set 'production_mode' to 'false' if it's a test device.
            // For how to register a test device, please see the developer doc.
            unicast.setProductionMode();
            // Set customized fields
            for (Extra e : extras) {
                unicast.setExtraField(e.getKey(), e.getValue());
            }
            client.send(unicast);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送通知
     *
     * @param sign
     */
//    private void sendPush(String sign) {
//        try {
//            HttpResponse<String> response = Unirest.post(umengUrl)
//                    .queryString("sign", sign).asString();
//            String body = response.getBody();
//            System.out.print(body);
//        } catch (UnirestException e) {
//            e.printStackTrace();
//        }
//    }


    /**
     * 只支持广播，单播（通过别名或者device_token推送）
     *
     * @param ticker          标题
     * @param title           标题
     * @param text            内容
     * @param play_vibrate    收到通知是否震动,
     * @param play_lights     收到通知是否闪灯
     * @param play_sound      收到通知是否发出声音
     * @param after_open      点击"通知"的后续行为
     * @param afterUrl        可选 当"after_open"为"go_url"时，必填。
     * @param activityPath    可选 当"after_open"为"go_activity"时，必填。
     * @param extras          可选 用户自定义key-value。只对"通知"
     * @param pushType        必填 消息发送类型 广播，单播等方式
     * @param start_time      可选 定时发送时间，若不填写表示立即发送。
     * @param out_biz_no      可选 开发者对消息的唯一标识，服务器会根据这个标识避免重复发
     * @param deviceTokens    可选 设备唯一表示
     * @param aliasType       可选 当type=customizedcast时，必填，alias的类型,
     * @param alias           可选 当type=customizedcast时, 开发者填写自己的alias。
     * @param displayType     必填 消息类型，值可以为: notification-通知，message-消息
     * @param production_mode 可选 正式/测试模式。测试模式下，只会将消息发给测试设备。
     * @param description     可选 发送消息描述，建议填写。
     * @return
     */

    private AndroidPushBean createBody(String ticker, String title, String text, boolean play_vibrate, boolean play_lights, boolean play_sound, AfterOpenType after_open, String afterUrl, String activityPath, List<Extra> extras, PushType pushType, String start_time, String out_biz_no, String deviceTokens, String aliasType, String alias, DisplayType displayType, boolean production_mode, String description) {
        AndroidPushBean androidPushBean = new AndroidPushBean();
        androidPushBean.setAppkey(appkey);
        androidPushBean.setTimestamp(System.currentTimeMillis());
        androidPushBean.setType(pushType);
        androidPushBean.setDevice_tokens(deviceTokens);
        androidPushBean.setAlias_type(aliasType);
        androidPushBean.setAlias(alias);

        AndroidPayLoad androidPayLoad = new AndroidPayLoad();
        androidPayLoad.setDisplay_type(displayType);
        PushBody pushBody = new PushBody();
        pushBody.setTicker(ticker);
        pushBody.setTitle(title);
        pushBody.setText(text);
        pushBody.setPlay_vibrate(play_vibrate);
        pushBody.setPlay_lights(play_lights);
        pushBody.setPlay_sound(play_sound);
        pushBody.setAfter_open(after_open);
        pushBody.setUrl(afterUrl);
        pushBody.setActivity(activityPath);
        androidPayLoad.setBody(pushBody);
        androidPayLoad.setExtra(extras);
        androidPushBean.setPayload(androidPayLoad);

        Policy policy = new Policy();
        policy.setStart_time(start_time);
        policy.setOut_biz_no(out_biz_no);
        androidPushBean.setPolicy(policy);

        androidPushBean.setProduction_mode(production_mode);
        androidPushBean.setDescription(description);
        return androidPushBean;
    }

    private String md5Sign(String method, String url, String postBody, String appSecret) {
        String sign = null;

        try {
            sign = DigestUtils.md5Hex((method + url + postBody + appSecret).getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return sign;
    }
}
