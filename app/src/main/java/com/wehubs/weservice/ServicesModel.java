package com.wehubs.weservice;

/**
 * Created by suyati on 1/4/16.
 */
public class  ServicesModel {

    private String title;

    public ServicesModel(String title, int drawable) {
        this.title=title;
        this.drawable=drawable;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private int drawable;


}

