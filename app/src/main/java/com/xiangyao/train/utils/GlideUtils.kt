package com.xiangyao.train.utils

import android.annotation.SuppressLint
import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import xiangyao.yizhilu.com.studyjourny.R


/*
    Glide工具类
 */
object GlideUtils {
    fun loadImage(context: Context, url: String, imageView: ImageView) {
        Glide.with(context).load(url).apply{ RequestOptions().centerCrop()}.into(imageView)
    }

    fun loadImageFitCenter(context: Context, url: String, imageView: ImageView) {
        Glide.with(context).load(url).apply{RequestOptions().fitCenter()}.into(imageView)
    }

    /*
        当fragment或者activity失去焦点或者destroyed的时候，Glide会自动停止加载相关资源，确保资源不会被浪费
     */
    fun loadUrlImage(context: Context, url: String, imageView: ImageView){
        Glide.with(context).load(url).apply { RequestOptions().placeholder(R.color.bg_normal).error(R.color.bg_normal) }.into(imageView)
    }

    /**
     * 加载圆形图片
     */
    fun loadCircleImage(context: Context, url: String, imageView: ImageView, placeholderRes: Int) {
        Glide.with(imageView.context)
            .load(url)
            .apply(RequestOptions.bitmapTransform(CircleCrop()))
            .apply(RequestOptions().placeholder(placeholderRes))
            .into(imageView)
    }
    @SuppressLint("CheckResult")
    fun loadRoundImage(context: Context, url: String, imageView: ImageView, placeholderRes: Int, radios: Int){
        //设置图片圆角角度
        val roundedCorners = RoundedCorners(radios)

        val requestOptions=RequestOptions()
        requestOptions.placeholder(placeholderRes)
        requestOptions.transform(CenterCrop(),roundedCorners)

        val override = RequestOptions.bitmapTransform(roundedCorners)
        Glide.with(context).load(url)
            .apply(requestOptions)
            .into(imageView)
    }
}
