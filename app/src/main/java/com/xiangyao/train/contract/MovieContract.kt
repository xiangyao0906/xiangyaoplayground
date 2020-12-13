package com.xiangyao.train.contract

import com.xiangyao.train.base.BaseViewI
import com.xiangyao.train.bean.CityBean
import com.xiangyao.train.data.CityData
import rx.Observable

interface MovieContract {


    interface Model{


        fun getMovieCitys():Observable<CityData>

    }

    interface View : BaseViewI<Nothing> {


        fun showMoviesCitys(arrayList: ArrayList<CityBean>)



    }

    interface Presenter{


        fun getMoviesCitys()


    }
}