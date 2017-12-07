package com.xiangyao.train.utils


import android.util.Log
import okhttp3.logging.HttpLoggingInterceptor


class HttpLog : HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
        Log.i("xiangyao", message)
    }
}

