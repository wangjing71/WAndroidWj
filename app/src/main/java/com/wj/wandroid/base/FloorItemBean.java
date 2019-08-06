package com.wj.wandroid.base;

/**
 * author wangjing
 * Date 2019/8/6
 * Description
 */
public class FloorItemBean {
    private String title;
    private int icon;

    public FloorItemBean(String title, int icon) {
        this.title = title;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
