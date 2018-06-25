package com.bigstark.similarfacebook;

import android.app.Application;

public class SimilarFBApplication extends Application {

    private static SimilarFBApplication instance;

    public static SimilarFBApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
