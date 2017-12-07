package com.xiangyao.train.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * Created by ming on 2017/9/15 14:30.
 * Desc:
 */

object NetWorkUtils {

    /**
     * 当前有无网络

     * @return
     */
    fun isNetWorkAvailable(context: Context): Boolean {
        val connectivityManager = context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connectivityManager.activeNetworkInfo
        if (info == null) {
            return false
        } else {
            if (info.isAvailable) {
                return true
            }
        }
        return false
    }
}
