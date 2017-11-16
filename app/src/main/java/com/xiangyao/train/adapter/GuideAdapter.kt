package com.xiangyao.train.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import xiangyao.yizhilu.com.studyjourny.R

/**
 * Created by xiangyao on 2017/11/16.
 */
class GuideAdapter(layoutResId: Int, activitys: List<Class<*>>?) : BaseQuickAdapter<Class<*>, BaseViewHolder>(layoutResId, activitys) {
    override fun convert(helper: BaseViewHolder, item: Class<*>?) {
        helper.setText(R.id.activity_name, item?.simpleName)
    }
}