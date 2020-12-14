package com.xiangyao.train.model

import com.xiangyao.train.api.ApiManager
import com.xiangyao.train.contract.MovieContract
import com.xiangyao.train.data.CityData
import com.xiangyao.train.data.MovieData
import com.xiangyao.train.utils.RxScedulerHelper
import rx.Observable

class MovieModel:MovieContract.Model {

    override fun getMovieCitys(): Observable<CityData> {

      return  ApiManager.getApistore()?.getMovieCitys()?.compose(RxScedulerHelper.io_main())!!
    }

    override fun getOnShowMovies(): Observable<MovieData> {

        return ApiManager.getApistore()?.getOnShowMovie()?.compose(RxScedulerHelper.io_main())!!
    }
}