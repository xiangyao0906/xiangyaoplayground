package com.xiangyao.train.utils


import com.orhanobut.logger.Logger


object ILog {

    private val TAG = "xiangyao"
    private val isOn = true

    fun i(massage: String) {
        if (isOn) {
            Logger.i(massage)
        }
    }

}
