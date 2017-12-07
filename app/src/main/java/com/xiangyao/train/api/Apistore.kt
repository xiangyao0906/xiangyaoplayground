package com.xiangyao.train.api

import com.xiangyao.train.bean.Fuli
import com.xiangyao.train.bean.Movie
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query
import rx.Observable

/**
 * Created by xiangyao on 2017/9/23.
 */

interface Apistore {
    /**
     * api 統一管理類
     * **/


    @Headers("xiangyao:douban")
    @GET("v2/movie/top250?")
    fun getMovie(@Query("start") star: String, @Query("count") count: String): Observable<Movie>


    @Headers("xiangyao:gankio")
    @GET("api/data/%E7%A6%8F%E5%88%A9/10/1")
    fun getFuli(): Observable<Fuli>

}
