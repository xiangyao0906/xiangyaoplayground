package com.xiangyao.train.presenter

import com.xiangyao.train.base.BasePresenter
import com.xiangyao.train.base.BaseSubscribe
import com.xiangyao.train.bean.CityBean
import com.xiangyao.train.bean.MovieBean
import com.xiangyao.train.contract.MovieContract
import com.xiangyao.train.data.CityData
import com.xiangyao.train.data.MovieData
import com.xiangyao.train.model.MovieModel

class MoviePresenter:BasePresenter<MovieContract.View>(),MovieContract.Presenter {

    companion object {
        var model = MovieModel()
    }

    override fun getMoviesCitys() {

        addSubscription(


                model.getMovieCitys().subscribe(object :BaseSubscribe<CityData>(){
                    override fun _onNext(t: CityData) {
                        mView?.showMoviesCitys(t.cts as ArrayList<CityBean>)
                    }

                    override fun _onError(e: Throwable?) {
                    }
                })

        )
    }

}