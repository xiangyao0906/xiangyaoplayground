package com.xiangyao.train.utils

import android.content.Context
import android.widget.Toast

/**
 * Created by xiangyao on 2017/11/16.
 */
object IToast {
    private var toast: Toast? = null

    fun show(context: Context, message: String) {
        if (toast == null) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
        } else {
            toast!!.setText(message)
        }
        toast!!.show()
    }
}