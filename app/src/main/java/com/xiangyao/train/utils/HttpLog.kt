package com.xiangyao.train.utils


import android.util.Log
import com.orhanobut.logger.Logger

import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by ZQ on 2017/9/13.
 */

class HttpLog : HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
        Logger.i( message)
    }
}

