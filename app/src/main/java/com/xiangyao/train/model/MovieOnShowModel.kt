package com.xiangyao.train.model

import com.xiangyao.train.api.ApiManager
import com.xiangyao.train.contract.MovieOnShowContract
import com.xiangyao.train.data.MovieData
import com.xiangyao.train.utils.RxScedulerHelper
import rx.Observable

class MovieOnShowModel : MovieOnShowContract.Model {

    override fun getOnShowMovies(): Observable<MovieData> {
        return ApiManager.getApistore()?.getOnShowMovie()?.compose(RxScedulerHelper.io_main())!!
    }
}