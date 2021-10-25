package com.xiangyao.train.ui.home

import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.xiangyao.train.bean.BannerBean
import com.youth.banner.adapter.BannerAdapter

class HomeBannerAdapter(banners: ArrayList<BannerBean>) : BannerAdapter<BannerBean, ImageHolder>(banners) {

    //创建ViewHolder，可以用viewType这个字段来区分不同的ViewHolder
    override fun onCreateHolder(parent: ViewGroup, viewType: Int): ImageHolder? {
        val imageView = ImageView(parent.context)
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        val params = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
        imageView.layoutParams = params
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        return ImageHolder(imageView)
    }

    override fun onBindView(holder: ImageHolder, data: BannerBean, position: Int, size: Int) {
        Glide.with(holder.itemView.context).load(data.image).into(holder.imageView)

    }
}