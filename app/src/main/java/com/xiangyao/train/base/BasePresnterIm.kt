package com.xiangyao.train.base

import android.content.Context

/**
 * Created by xiangyao on 2017/9/23.
 */

interface BasePresnterIm {

    /**
     * 判断网络连接
     */
    fun checkNetWork(context: Context): Boolean

    fun unsubcrible()
}
