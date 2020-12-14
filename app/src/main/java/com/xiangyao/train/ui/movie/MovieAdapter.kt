package com.xiangyao.train.ui.movie

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.xiangyao.train.bean.MovieBean
import com.xiangyao.train.utils.GlideUtils
import kotlinx.android.synthetic.main.onshow_movie_item_layout.view.*
import xiangyao.yizhilu.com.studyjourny.R

class MovieAdapter(movies: ArrayList<MovieBean>) : BaseQuickAdapter<MovieBean, BaseViewHolder>(R.layout.onshow_movie_item_layout, movies) {
    override fun convert(holder: BaseViewHolder, item: MovieBean) {


        holder.itemView.apply {
            GlideUtils.loadImage(holder.itemView.context, item.img.replace("/w.h", ""), movieIv)

            movieName.text = item.nm

            scoreTv.text = "${item.sc}"

            startTv.text = item.star

            onShowInfoTv.text = item.showInfo


        }
    }
}