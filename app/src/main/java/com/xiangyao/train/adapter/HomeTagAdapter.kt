package com.xiangyao.train.adapter

import android.annotation.SuppressLint
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xiangyao.train.bean.HomeTagBean
import kotlinx.android.synthetic.main.home_tag_item_layout.view.*
import xiangyao.yizhilu.com.studyjourny.R

/**
 * Created by xiangyao on 2017/11/30.
 */
class HomeTagAdapter(result: MutableList<HomeTagBean>) : BaseQuickAdapter<HomeTagBean, BaseViewHolder>(R.layout.home_tag_item_layout, result) {

    @SuppressLint("SetTextI18n")
    override fun convert(holder: BaseViewHolder, item: HomeTagBean) {

        holder.itemView.apply {
//            Glide.with(holder.itemView.context).load(item.coverImageUrl).into(tagBg)
//
            tagText.text="# ${item.type}"
        }

    }
}