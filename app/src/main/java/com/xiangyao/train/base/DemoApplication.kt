package com.xiangyao.train.base

import android.app.Activity
import android.app.Application
import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.orhanobut.logger.Logger
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.zhy.autolayout.config.AutoLayoutConifg
import java.util.*

/**
 * description: app
 * autour: xiangyao
 * date: 2017/9/4 0004 下午 4:41
 * update: 2017/9/4 0004
 * version:
 */
class DemoApplication : Application() {
    private val mDialog: ProgressDialog? = null
    var store: Stack<Activity>? = null


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
        Logger.t("xiangyao")

        ARouter.openLog()   // 打印日志
        ARouter.openDebug()  // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(this) // 尽可能早，推荐在Application中初始化
    }

    //static 代码段可以防止内存泄露
    init {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout ->
            ClassicsHeader(
                    context
            )
        }
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout ->
            ClassicsFooter(
                    context
            ).setDrawableSize(20f)
        }
    }


    private inner class SwitchBackgroundCallbacks : Application.ActivityLifecycleCallbacks {

        override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
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
        lateinit var appContext: DemoApplication
    }
}
