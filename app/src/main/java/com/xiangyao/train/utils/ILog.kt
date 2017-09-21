package com.xiangyao.train.utils


import android.util.Log


object ILog {

    private val TAG = "log268"
    private val isOn = true

    fun i(massage: String) {
        if (isOn) {
            Log.i(TAG, massage)
        }
    }

}
