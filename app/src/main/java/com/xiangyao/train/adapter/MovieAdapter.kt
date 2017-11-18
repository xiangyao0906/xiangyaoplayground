package com.xiangyao.train.adapter

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.xiangyao.train.bean.Movie
import xiangyao.yizhilu.com.studyjourny.R

/**
 * Created by Administrator on 2017/09/30.
 */

class MovieAdapter
/**
 * Same as QuickAdapter#QuickAdapter(Context,int) but with
 * some initialization data.
 *
 * @param layoutResId The layout resource id of each item.
 * @param data        A new list is created out of this one to avoid mutable list
 */
(layoutResId: Int, data:List<Movie.SubjectsEntity>?) : BaseQuickAdapter<Movie.SubjectsEntity, BaseViewHolder>(layoutResId, data) {

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    override fun convert(helper: BaseViewHolder, item: Movie.SubjectsEntity) {
        Glide.with(mContext).load(item?.images?.large)
                .placeholder(R.drawable.ic_launcher_background)
                .crossFade()
                .into(helper.getView(R.id.moview_image))
        /**
         *    holder.movieName.setText(movie.getSubjects().get(position).getTitle());
        holder.diractor.setText(movie.getSubjects().get(position).getDirectors().get(0).getName());
        holder.showtime.setText(movie.getSubjects().get(position).getYear());
         *
         * */

        helper.setText(R.id.movie_name, item?.title)
        helper.setText(R.id.movie_dirctor, item?.directors?.get(0)?.name)
        helper.setText(R.id.showtime, item?.year)

        helper.addOnClickListener(R.id.rootview)

    }
}
