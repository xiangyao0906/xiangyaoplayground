package com.xiangyao.train.model


import com.xiangyao.train.api.ApiManager
import com.xiangyao.train.bean.Movie
import com.xiangyao.train.utils.RxScedulerHelper
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by xiangyao on 2017/9/23.
 */

class MainActivityModel {

    fun getData(start: String, count: String): Observable<Movie> {
        return ApiManager.getApistore()!!.getMovie(start, count)
                .compose(RxScedulerHelper.io_main())
    }


}
