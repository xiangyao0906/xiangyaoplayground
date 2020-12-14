package com.xiangyao.train.presenter

import com.xiangyao.train.base.BasePresenter
import com.xiangyao.train.base.BaseSubscribe
import com.xiangyao.train.bean.MovieBean
import com.xiangyao.train.contract.MovieOnShowContract
import com.xiangyao.train.data.MovieData
import com.xiangyao.train.model.MovieOnShowModel

class MovieOnShowPresenter : BasePresenter<MovieOnShowContract.View>(), MovieOnShowContract.Presenter {
    companion object {
        var model = MovieOnShowModel()
    }

    override fun getOnShowMovies() {
        addSubscription(

                model.getOnShowMovies().subscribe(object : BaseSubscribe<MovieData>() {
                    override fun _onNext(t: MovieData) {
                        mView?.showOnShowMovies(t.movieList as ArrayList<MovieBean>)
                    }

                    override fun _onError(e: Throwable?) {
                    }
                })
        )
    }
}