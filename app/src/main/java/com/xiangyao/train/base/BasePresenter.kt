package com.xiangyao.train.base

import android.content.Context
import com.xiangyao.train.utils.IToast
import com.xiangyao.train.utils.NetWorkUtils

import rx.Subscription
import rx.subscriptions.CompositeSubscription

/**
 * Created by ming on 2017/9/14.
 */

abstract class BasePresenter<V : BaseViewI<*>> : BasePresnterIm {

    var mView: V? = null
    var mContext: Context? = null
    private var mCompositeSubscription: CompositeSubscription? = null

    override fun checkNetWork(context: Context): Boolean {
        if (!NetWorkUtils.isNetWorkAvailable(context)) {


            IToast.show(context, "没有网络了")
        }
        return NetWorkUtils.isNetWorkAvailable(context)
    }


    fun attachView(view: V, context: Context) {
        this.mView = view
        this.mContext = context
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
        mContext = null
        this.mCompositeSubscription = null
    }

}
