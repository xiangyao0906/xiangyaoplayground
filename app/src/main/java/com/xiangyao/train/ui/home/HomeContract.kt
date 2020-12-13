package com.xiangyao.train.ui.home

import com.xiangyao.train.base.BaseViewI
import com.xiangyao.train.bean.BannerBean
import com.xiangyao.train.bean.GirlBean
import com.xiangyao.train.bean.HomeTagBean
import com.xiangyao.train.data.BannerData
import com.xiangyao.train.data.GirlData
import com.xiangyao.train.data.HomeTagData
import rx.Observable

interface HomeContract {

    interface Model{

        fun getGankBanner(): Observable<BannerData>


        fun getGankTag():Observable<HomeTagData>

        fun getGirls(page:Int,limit:Int):Observable<GirlData>
    }

    interface View : BaseViewI<Nothing>{
        fun showBanner(banners: MutableList<BannerBean>)


        fun showHomeTag(tags: MutableList<HomeTagBean>)


        fun showGirls(girls: MutableList<GirlBean>)

    }

    interface Presenter{

        fun getHomeTags()


        fun findSomeGirls(page:Int,limit:Int)

    }
}