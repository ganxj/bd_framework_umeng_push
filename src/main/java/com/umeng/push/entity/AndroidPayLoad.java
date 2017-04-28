package com.umeng.push.entity;


import com.umeng.push.entity.eunm.DisplayType;

import java.util.List;

/**
 * Created by gange on 2017/4/27.
 */
public class AndroidPayLoad {

    private DisplayType display_type;

    private PushBody body;

    private List<Extra> extra;

    public DisplayType getDisplay_type() {
        return display_type;
    }

    public void setDisplay_type(DisplayType display_type) {
        this.display_type = display_type;
    }

    public PushBody getBody() {
        return body;
    }

    public void setBody(PushBody body) {
        this.body = body;
    }

    public List<Extra> getExtra() {
        return extra;
    }

    public void setExtra(List<Extra> extra) {
        this.extra = extra;
    }
}
