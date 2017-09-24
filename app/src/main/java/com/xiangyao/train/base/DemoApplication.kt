package com.xiangyao.train.base

import android.app.Activity
import android.app.Application
import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import com.facebook.drawee.backends.pipeline.Fresco

import com.orhanobut.logger.Logger
import com.zhy.autolayout.config.AutoLayoutConifg

import java.util.Stack

/**
 * description: app
 * autour: xiangyao
 * date: 2017/9/4 0004 下午 4:41
 * update: 2017/9/4 0004
 * version:
 */
class DemoApplication : Application() {
    private val mDialog: ProgressDialog? = null
    var store: Stack<Activity> ?= null


    //分包支持
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
        store = Stack<Activity>()
        //屏幕适配
        registerActivityLifecycleCallbacks(SwitchBackgroundCallbacks())
        AutoLayoutConifg.getInstance().useDeviceSize()
        Logger.init("xiangyao")
    }

    /**
     * 获取当前的Activity

     * @return
     */
    val curActivity: Activity
        get() = store!!.lastElement()


    private inner class SwitchBackgroundCallbacks : Application.ActivityLifecycleCallbacks {

        override fun onActivityCreated(activity: Activity, bundle: Bundle) {
            store!!.add(activity)
        }

        override fun onActivityStarted(activity: Activity) {

        }

        override fun onActivityResumed(activity: Activity) {

        }

        override fun onActivityPaused(activity: Activity) {

        }

        override fun onActivityStopped(activity: Activity) {

        }

        override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle) {

        }

        override fun onActivityDestroyed(activity: Activity) {
            store!!.remove(activity)
        }
    }

    companion object {
        var appContext: DemoApplication? = null
        var mContext: Context? = null
    }
}
