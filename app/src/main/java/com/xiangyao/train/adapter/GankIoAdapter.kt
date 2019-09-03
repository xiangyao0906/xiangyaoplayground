package com.xiangyao.train.adapter

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.xiangyao.train.bean.Fuli
import xiangyao.yizhilu.com.studyjourny.R

/**
 * Created by xiangyao on 2017/11/30.
 */
class GankIoAdapter(res: Int, result: List<Fuli.Results>) : BaseQuickAdapter<Fuli.Results, BaseViewHolder>(res, result) {
    override fun convert(helper: BaseViewHolder?, item: Fuli.Results?) {

        Glide.with(mContext).load(item?.url).into(helper?.getView(R.id.meizi))

        helper?.addOnClickListener(R.id.meizi)
    }
}