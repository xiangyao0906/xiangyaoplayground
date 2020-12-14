package com.xiangyao.train.contract

import com.xiangyao.train.base.BaseViewI
import com.xiangyao.train.bean.CityBean
import com.xiangyao.train.bean.MovieBean
import com.xiangyao.train.data.CityData
import com.xiangyao.train.data.MovieData
import rx.Observable

interface MovieContract {


    interface Model{


        fun getMovieCitys():Observable<CityData>
        
        fun getOnShowMovies():Observable<MovieData>

    }

    interface View : BaseViewI<Nothing> {


        fun showMoviesCitys(arrayList: ArrayList<CityBean>)

        fun showOnShowMovies(movieData: ArrayList<MovieBean>)



    }

    interface Presenter{


        fun getMoviesCitys()
        
        fun getOnShowMovies()


    }
}