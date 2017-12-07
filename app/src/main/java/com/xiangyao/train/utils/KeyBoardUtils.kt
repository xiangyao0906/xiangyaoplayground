package com.xiangyao.train.utils

import android.app.Activity
import android.content.Context
import android.os.IBinder
import android.view.inputmethod.InputMethodManager

/**
 *
 * Created by xiangyao on 2017/12/07.
 */
object KeyBoardUtils {

    /**
     * 关闭键盘
     * @param context
     * */
    fun closeSoftInputKeyboard(context: Context) {

        var imm: InputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow((context as Activity).currentFocus.applicationWindowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }

    /**
     * 显示键盘
     *
     * */

    fun openSoftInputKeyboard(context: Context) {
        var imm: InputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS)
    }

    /**
     * 隐藏软键盘
     * */
    fun hideSoftInput(token: IBinder, context: Context) {
        var imm: InputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS)
    }

}