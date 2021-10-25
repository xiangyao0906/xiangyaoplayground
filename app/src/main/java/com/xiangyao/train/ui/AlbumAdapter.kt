package com.xiangyao.train.ui

import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xiangyao.train.bean.AlbumPhoto
import com.xiangyao.train.utils.GlideUtils
import kotlinx.android.synthetic.main.album_photo_item_layout.view.*
import xiangyao.yizhilu.com.studyjourny.R
import java.util.*

class AlbumAdapter(photos: ArrayList<AlbumPhoto>) : BaseQuickAdapter<AlbumPhoto, AlbumAdapter.ViewHolder>(R.layout.album_photo_item_layout, photos) {
    class ViewHolder(view: View) : BaseViewHolder(view)

    override fun convert(holder: ViewHolder, item: AlbumPhoto) {

        holder.itemView.apply {

            photoStatues.setBackgroundResource(if (item.isSelected) R.mipmap.choosed_icon else R.mipmap.unchoose_icon)

            GlideUtils.loadRoundImage(this.context, item.path, itemImageView, R.mipmap.ic_launcher, 10)
        }
    }
}