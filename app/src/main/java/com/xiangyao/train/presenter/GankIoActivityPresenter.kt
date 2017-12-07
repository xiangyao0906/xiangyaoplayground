package com.xiangyao.train.presenter

import com.xiangyao.train.base.BasePresenter
import com.xiangyao.train.bean.Fuli
import com.xiangyao.train.contract.GankIoActivityContract
import com.xiangyao.train.model.GankIoActivityModel
import rx.Subscriber

/**
 *
 * @author xiangyao
 * @date 2017/11/30
 */
// Can be reused
class GankIoActivityPresenter : BasePresenter<GankIoActivityContract.View>(), GankIoActivityContract.Presenter {
    companion object {
        var model = GankIoActivityModel()
    }

    override fun findSomeFuli() {
        mView?.showLoadingView()
        mContext?.let { checkNetWork(it) }

        addSubscription(model.findSomeFuli().subscribe(object : Subscriber<Fuli>() {
            override fun onCompleted() {
                mView?.showContent()
                mView?.setAdapter()
            }

            override fun onNext(t: Fuli?) {

                if (t != null) {
                    mView?.showDataSuccess(t)
                }

            }

            override fun onError(e: Throwable?) {
                mView?.showNetErrorView()
            }
        }))


    }
}
