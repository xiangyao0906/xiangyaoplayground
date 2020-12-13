package com.xiangyao.train.api

import com.xiangyao.train.bean.Movie
import com.xiangyao.train.data.BannerData
import com.xiangyao.train.data.CityData
import com.xiangyao.train.data.GirlData
import com.xiangyao.train.data.HomeTagData
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

/**
 * Created by xiangyao on 2017/9/23.
 */

interface ApiStore {
    /**
     * api 統一管理類
     * **/
    @Headers("xiangyao:douban")
    @GET("v2/movie/top250?")
    fun getMovie(@Query("start") star: String, @Query("count") count: String): Observable<Movie>


    @Headers("xiangyao:gankio")
    @GET("api/v2/banners")
    fun gankBanner(): Observable<BannerData>

    @Headers("xiangyao:gankio")
    @GET("api/v2/categories/Article")
    fun getHomeTag(): Observable<HomeTagData>

    @Headers("xiangyao:gankio")
    @GET("api/v2/data/category/Girl/type/Girl/page/{page}/count/{count}")
    fun findSomeGirls(@Path("page") page:Int, @Path("count") count:Int): Observable<GirlData>

    //猫眼电影

    @Headers("xiangyao:maoyan")
    @GET("maoyanApi/dianying/cities.json")
    fun getMovieCitys(): Observable<CityData>
}
