package com.xiangyao.train.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.res.Resources
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.dovar.dtoast.DToast
import com.xiangyao.train.base.DemoApplication
import xiangyao.yizhilu.com.studyjourny.R

//Kotlin通用扩展
//Created by zm on 2019/3/24.


/**
 * 扩展点击事件
 */
fun View.onClick(listener: View.OnClickListener): View {
    setOnClickListener(listener)
    return this
}

/**
 * 扩展点击事件，参数为方法
 */
fun View.onClick(method:() -> Unit): View {
    setOnClickListener{
        method()
    }
    return this
}


/**
 * 扩展View的显示与隐藏
 */
fun View.setVisible(visible: Boolean) {
    this.visibility = if (visible) View.VISIBLE else View.GONE
}


/**
 * 扩展String的copy到系统剪贴板功能
 */
fun String.copy(): Boolean {
    val link = this
    val clipData = ClipData.newPlainText("text", link)
    // 复制
    val cm = DemoApplication.appContext?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    // 将文本内容放到系统剪贴板里。
    cm.setPrimaryClip(clipData)
    return true
}

/**
 * 扩展String的toastShow方法
 * 默认显示
 */
fun String.show() {
    val toast = DToast.make(DemoApplication.appContext)
    val tvText = toast.view.findViewById<TextView>(R.id.tv_content_default)
    tvText?.text = this
    toast.setGravity(Gravity.BOTTOM or Gravity.CENTER, 0, 30).show()
}

/**
 * 扩展String的toastShow方法
 * 居中显示
 */
fun String.showAtCenter() {
    val context = AppManager.instance.currentActivty()?:DemoApplication.appContext
    val toastRoot = View.inflate(context, R.layout.layout_toast_center, null)
    val tvText = toastRoot.findViewById<TextView>(R.id.tv_content)
    tvText?.text = this
    DToast.make(context).setView(toastRoot).setGravity(Gravity.CENTER, 0, 0).show()
}

/**
 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
 */
fun Int.dp2px():Int{
    return (0.5f + this * Resources.getSystem().displayMetrics.density).toInt()
}