package com.lvbo.template;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.lvbo.template.network.OkHttpsFactory;
import com.squareup.leakcanary.LeakCanary;

import io.fabric.sdk.android.Fabric;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by lvbo on 16/9/1.
 */
public class MyApplication extends Application {
    ArrayList<Activity> list = new ArrayList<Activity>();

    private Tracker mTracker;

    private static MyApplication applicationContext;
    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());//收集crash信息
        applicationContext=this;
        //内存泄漏检测工具
        LeakCanary.install(this);

        //这句主要是为了支持https的图片
//        Glide.get(this).register(GlideUrl.class, InputStream.class, new OkHttpsFactory());

        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(applicationContext);


    }

    public static MyApplication getInstance(){
        return applicationContext;
    }

    /**
     * Gets the default {@link Tracker} for this {@link Application}.
     * @return tracker
     */
    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
//            mTracker = analytics.newTracker(R.xml.global_tracker);
            mTracker = analytics.newTracker("UA-86025748-1");//需要改成相应项目的id
        }
        return mTracker;
    }



    /**
     * Activity关闭时，删除Activity列表中的Activity对象*/
    public void removeActivity(Activity a){
        list.remove(a);
    }

    /**
     * 向Activity列表中添加Activity对象*/
    public void addActivity(Activity a){
        list.add(a);
    }

    /**
     * 关闭Activity列表中的所有Activity*/
    public void finishActivity(){
        for (Activity activity : list) {
            if (null != activity) {
                activity.finish();
            }
        }

        //杀死该应用进程
        android.os.Process.killProcess(android.os.Process.myPid());


    }

}
