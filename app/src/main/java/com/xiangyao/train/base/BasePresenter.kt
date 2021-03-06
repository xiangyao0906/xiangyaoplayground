package com.xiangyao.train.base

import android.content.Context
import com.xiangyao.train.utils.NetWorkUtils
import com.xiangyao.train.utils.showAtCenter
import rx.Subscription
import rx.subscriptions.CompositeSubscription


/**
 *2017年9月23日 11:31:40 author by xiangyao
 */

abstract class BasePresenter<V : BaseViewI<*>> : BasePresnterIm {

    var mView: V? = null
    var mContext: Context? = null
    private var mCompositeSubscription: CompositeSubscription? = null

    override fun checkNetWork(context: Context): Boolean {
        if (!NetWorkUtils.isNetWorkAvailable(context)) {


            "没有网络了".showAtCenter()
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
