package com.xiangyao.train.utils

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

/**
 * Activity管理器
 * <p>
 * Created by zm on 2019/3/24.
 */
class AppManager private constructor() {
    private val activityStack: Stack<Activity> = Stack()

    companion object {
        val instance: AppManager by lazy(LazyThreadSafetyMode.SYNCHRONIZED){ AppManager() }
    }

    /**
     * Activity入栈
     */
    fun addActivity(activity: Activity) {
        activityStack.add(activity)
    }

    /**
     * Activity出栈
     */
    fun finishActivity(activity: Activity) {
        activity.finish()
        activityStack.remove(activity)
    }

    /**
     * Activity出栈
     */
    fun finishActivity(cls: Class<*>) {
        activityStack.forEach { 
            if (it.javaClass == cls) {
                it.finish()
                activityStack.remove(it)
            }
        }
    }

    /**
     * 获取当前栈顶
     */
    fun currentActivty(): Activity?{
        return activityStack.lastElement()
    }

    /**
     * 清理栈
     */
    fun finishAllActivity() {
        activityStack.forEach {activity ->
            activity.finish()
        }
        activityStack.clear()
    }

    /**
     * 退出应用
     */
    fun exitApp(context: Context) {
        finishAllActivity()
        val activityManager: ActivityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)
        android.os.Process.killProcess(android.os.Process.myPid())
        System.exit(0)
    }
}