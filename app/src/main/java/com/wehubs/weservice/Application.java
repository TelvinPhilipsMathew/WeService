package com.wehubs.weservice;

import android.content.Context;

import com.facebook.FacebookSdk;

/**
 * Created by suyati on 21/3/16.
 */
public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
