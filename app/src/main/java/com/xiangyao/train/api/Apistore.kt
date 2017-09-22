package com.xiangyao.train.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.QueryMap
import xiangyao.yizhilu.com.studyjourny.ui.Movie

/**
 * Created by Administrator on 2017/09/22.
 */

interface Apistore {
/*
* api 統一管理類
* **/

    @Headers("xiangyao:douban")
    @GET("v2/movie/top250?")
    fun getMovie(@QueryMap params: Map<String, String>): Call<Movie>

}


