package com.xiangyao.train.contract

import com.xiangyao.train.base.BaseViewI
import com.xiangyao.train.bean.MovieBean
import com.xiangyao.train.data.MovieData
import rx.Observable

interface MovieOnShowContract {



    interface Model{

        fun getOnShowMovies(): Observable<MovieData>

    }

    interface View : BaseViewI<Nothing> {

        fun showOnShowMovies(movieData: ArrayList<MovieBean>)



    }

    interface Presenter{


        fun getOnShowMovies()


    }

}