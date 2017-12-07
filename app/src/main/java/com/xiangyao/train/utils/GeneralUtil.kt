package com.xiangyao.train.utils

import android.os.Environment
import android.text.TextUtils

/**
 * Created by xiangyao on 2017/12/07.
 */
object GeneralUtil {
    /**
     * 检查内存卡是否存在
     *
     * */
    fun isExitsSDcard(): Boolean {
        if (TextUtils.equals(Environment.getExternalStorageState(), Environment.MEDIA_MOUNTED)) {
            return true
        }
        return false
    }



}