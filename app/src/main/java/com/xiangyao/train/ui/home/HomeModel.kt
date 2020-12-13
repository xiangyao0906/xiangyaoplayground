package com.xiangyao.train.ui.home

import com.xiangyao.train.api.ApiManager
import com.xiangyao.train.bean.GirlBean
import com.xiangyao.train.data.BannerData
import com.xiangyao.train.data.GirlData
import com.xiangyao.train.data.HomeTagData
import com.xiangyao.train.utils.RxScedulerHelper
import rx.Observable

class HomeModel : HomeContract.Model {
    override fun getGankBanner(): Observable<BannerData> {

        return ApiManager.getApistore()?.gankBanner()?.compose(RxScedulerHelper.io_main())!!
    }

    override fun getGankTag(): Observable<HomeTagData> {
        return ApiManager.getApistore()?.getHomeTag()?.compose(RxScedulerHelper.io_main())!!
    }

    override fun getGirls(page: Int, limit: Int) :Observable<GirlData>{
        return ApiManager.getApistore()?.findSomeGirls(page,limit)?.compose(RxScedulerHelper.io_main())!!
    }


}