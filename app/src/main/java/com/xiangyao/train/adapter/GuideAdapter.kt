package com.xiangyao.train.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import xiangyao.yizhilu.com.studyjourny.R

/**
 * Created by xiangyao on 2017/11/16.
 */
class GuideAdapter(layoutResId: Int, activates: MutableList<Class<*>>?) : BaseQuickAdapter<Class<*>, BaseViewHolder>(layoutResId, activates) {

    override fun convert(holder: BaseViewHolder, item: Class<*>) {
        holder.setText(R.id.activity_name, item.simpleName)
    }
}