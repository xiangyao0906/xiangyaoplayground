package com.xiangyao.train.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xiangyao.train.bean.GirlBean
import com.xiangyao.train.utils.DateUtil
import com.xiangyao.train.utils.GlideUtils
import com.xiangyao.train.utils.TimeFormatUtils
import kotlinx.android.synthetic.main.grils_item_layout.view.*
import xiangyao.yizhilu.com.studyjourny.R
import java.util.*
import kotlin.collections.ArrayList

class GrilsAdapter(grils: ArrayList<GirlBean>) : BaseQuickAdapter<GirlBean, BaseViewHolder>(R.layout.grils_item_layout, grils) {
    override fun convert(holder: BaseViewHolder, item: GirlBean) {

        holder.itemView.apply {
            authorName.text = item.author

            if (TimeFormatUtils.inOneWeek(DateUtil.str2Date(item.createdAt, DateUtil.FORMAT_YMDHMS)
                            ?: Date())) {
                time.text = TimeFormatUtils.timeCount(DateUtil.str2Date(item.createdAt, DateUtil.FORMAT_YMDHMS)
                        ?: Date())
            } else {
                time.text = DateUtil.getTime(DateUtil.str2Date(item.createdAt, DateUtil.FORMAT_YMDHMS)?.time
                        ?: 0L, DateUtil.FORMAT_YMD_CN)
            }

            GlideUtils.loadCircleImage(holder.itemView.context, item.images[0], avatar, R.drawable.ic_state_login)

            GlideUtils.loadRoundImage(holder.itemView.context, item.images[0], grilIv, R.drawable.ic_state_login, 6)
        }
    }
}