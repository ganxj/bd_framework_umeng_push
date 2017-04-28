package com.umeng.push.service;


import com.umeng.push.entity.Extra;

import java.util.List;

/**
 * Created by gange on 2017/4/27.
 */
public interface Push {

    void pushAndroidBroadcast(String title, String text);

    void pushAndroidUnicast(String title, String text, String deviceTokens, List<Extra> extras, String activityPath);

}
