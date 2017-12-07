package com.xiangyao.train.base

import android.content.Context

import rx.Subscription

/**
 * Created by Administrator on 2016/9/7 0007.
 */
interface BasePresenterI {
    /**
     * 判断网络连接
     */
    fun checkNetWork(context: Context): Boolean

    fun unsubcrible()


}
