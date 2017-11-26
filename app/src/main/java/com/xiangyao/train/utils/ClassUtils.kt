package com.xiangyao.train.utils

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager


/**
 * Created by xiangyao on 2017/11/16.
 */
object ClassUtils {
    private val TAG = "ClassUtils"

    /**
     * 返回AndroidManifest.xml中注册的所有Activity的class
     * @param context                环境
     * @param packageName        包名
     * @param excludeList        排除class列表
     * @return
     */
    fun getActivitiesClass(context: Context, packageName: String, excludeList: List<Class<*>>?): List<Class<*>> {

        val returnClassList = ArrayList<Class<*>>()
        try {
            //Get all activity classes in the AndroidManifest.xml
            val packageInfo = context.packageManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
            if (packageInfo.activities != null) {
                for (ai in packageInfo.activities) {
                    val c: Class<*>
                    try {
                        c = Class.forName(ai.name)
                        // Maybe isAssignableFrom is unnecessary
                        if (Activity::class.java.isAssignableFrom(c)) {
                            returnClassList.add(c)
                        }
                    } catch (e: ClassNotFoundException) {
                        //                                                e.printStackTrace();
                    }

                }

                //Exclude some activity classes
                if (excludeList != null) {
                    returnClassList.removeAll(excludeList)
                }
            }
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }

        return returnClassList
    }
}