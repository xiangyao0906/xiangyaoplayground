package com.xiangyao.train.utils

import android.content.Context
import android.widget.Toast

/**
 * Created by ming on 2016/12/28 10:01.
 * Explain:
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
