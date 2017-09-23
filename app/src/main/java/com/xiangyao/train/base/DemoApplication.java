package com.xiangyao.train.base;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import com.zhy.autolayout.config.AutoLayoutConifg;

import java.util.Stack;

/**
 * description: app
 * autour: xiangyao
 * date: 2017/9/4 0004 下午 4:41
 * update: 2017/9/4 0004
 * version:
 */
public class DemoApplication extends Application {
    private static DemoApplication demoApplication;
    private ProgressDialog mDialog;
    public static Context mContext;
    public Stack<Activity> store;


    //分包支持
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        demoApplication = this;
        store = new Stack<>();
        //屏幕适配
        registerActivityLifecycleCallbacks(new SwitchBackgroundCallbacks());
        AutoLayoutConifg.getInstance().useDeviceSize();
    }


    public static DemoApplication getAppContext() {
        return demoApplication;
    }
    /**
     * 获取当前的Activity
     *
     * @return
     */
    public Activity getCurActivity() {
        return store.lastElement();
    }


    private class SwitchBackgroundCallbacks implements Application.ActivityLifecycleCallbacks {

        @Override
        public void onActivityCreated(Activity activity, Bundle bundle) {
            store.add(activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            store.remove(activity);
        }
    }
}
