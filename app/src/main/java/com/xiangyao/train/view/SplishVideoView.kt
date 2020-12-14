package com.xiangyao.train.view

import android.content.Context
import android.util.AttributeSet
import android.widget.VideoView

//需重新自定义，他默认适配视频宽高
class SplishVideoView @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : VideoView(context, attrs, defStyleAttr) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = getDefaultSize(0, widthMeasureSpec)
        val height = getDefaultSize(0, heightMeasureSpec)
        setMeasuredDimension(width, height)
    }
}