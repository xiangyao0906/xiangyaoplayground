package com.xiangyao.train.ui.home

import com.xiangyao.train.base.BasePresenter
import com.xiangyao.train.base.BaseSubscribe
import com.xiangyao.train.data.BannerData
import com.xiangyao.train.data.GirlData
import com.xiangyao.train.data.HomeTagData
import com.xiangyao.train.utils.showAtCenter

class HomePresenter : BasePresenter<HomeContract.View>(), HomeContract.Presenter {

    companion object {
        var model = HomeModel()
    }

    fun concactData(){
        getGankBanner()
        getHomeTags()
    }

    private fun getGankBanner() {

        addSubscription(
                model.getGankBanner().subscribe(object : BaseSubscribe<BannerData>() {
                    override fun _onNext(t: BannerData) {
                        mView?.showBanner(t.data)
                    }

                    override fun _onError(e: Throwable?) {
                        mView?.showDataError(e?.message ?: "error")
                    }
                })
        )
    }

    override fun getHomeTags() {

        addSubscription(


                model.getGankTag().subscribe(object : BaseSubscribe<HomeTagData>() {
                    override fun _onNext(t: HomeTagData) {
                        mView?.showHomeTag(t.data)

                    }

                    override fun _onError(e: Throwable?) {

                        e?.message?.showAtCenter()

                    }
                })
        )

    }

    override fun findSomeGirls(page: Int, limit: Int) {

        addSubscription(

                model.getGirls(page, limit).subscribe(object :BaseSubscribe<GirlData>(){
                    override fun _onNext(t: GirlData) {
                        mView?.showGirls(t.data)
                    }

                    override fun _onError(e: Throwable?) {

                        e?.message?.showAtCenter()
                    }
                })
        )
    }
}