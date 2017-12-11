package com.xiangyao.train.utils

import android.app.Activity
import android.content.Context
import android.os.IBinder
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText


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

    /**
     * 判断软键盘是否隐藏
     * 没有具体的api
     * */
    fun isShouldHideKeyboard(v: View, event: MotionEvent): Boolean {
        if (v is EditText) {
            var l = intArrayOf(0, 0)
            v.getLocationInWindow(l)
            val left: Int = l[0]
            val top: Int = l[1]
            val bottom: Int = top + v.height
            val right: Int = left + v.width
            return !(event.x > left && event.x < right && event.y > top && event.y < bottom)
        }
        return false
    }

}