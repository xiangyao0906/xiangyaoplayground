package com.xiangyao.train.api

import com.xiangyao.train.bean.Movie
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import rx.Observable
import java.util.*

/**
 * Created by xiangyao on 2017/9/23.
 */

interface Apistore {
    /*
* api 統一管理類
* **/

    @Headers("xiangyao:douban")
    @GET("v2/movie/top250?")
    fun getMovie(@Query("start") star:String, @Query("count") count:String): Observable<Movie>
}
