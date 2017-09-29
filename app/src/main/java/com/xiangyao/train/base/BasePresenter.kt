package com.xiangyao.train.base

import android.content.Context
import com.xiangyao.train.utils.IToast
import com.xiangyao.train.utils.NetWorkUtils

import rx.Subscription
import rx.subscriptions.CompositeSubscription

/**
 *2017年9月23日 11:31:40 author by xiangyao
 */

abstract class BasePresenter<V : BaseViewI<*>> : BasePresnterIm {

    var mView: V? = null
    var context: Context? = null
    private var mCompositeSubscription: CompositeSubscription? = null

    override fun checkNetWork(context: Context): Boolean {
        if (!NetWorkUtils.isNetWorkAvailable(context)) {


            IToast.show(context, "没有网络了")
        }
        return NetWorkUtils.isNetWorkAvailable(context)
    }


    fun attachView(view: V, context: Context) {
        this.mView = view
        this.context = context
    }


    /**
     * 事件订阅
     */
    fun addSubscription(s: Subscription) {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = CompositeSubscription()
        }
        this.mCompositeSubscription!!.add(s)
    }


    override fun unsubcrible() {
        if (this.mCompositeSubscription != null) {
            this.mCompositeSubscription!!.unsubscribe()
        }
        mView = null
        context = null
        this.mCompositeSubscription = null
    }

}
