package com.xiangyao.train.base

import android.content.Context
import android.support.design.widget.Snackbar

import com.xiangyao.train.contract.MainActivityContract
import com.xiangyao.train.utils.IToast
import com.xiangyao.train.utils.NetWorkUtils

import rx.Subscription
import rx.subscriptions.CompositeSubscription

/**
 * Created by ming on 2017/9/14.
 */

open class BasePresenter<V : MainActivityContract.View> : BasePresnterIm {

    var mView: V? = null
     var  context: Context? = null
    private var mCompositeSubscription: CompositeSubscription? = null

    override fun checkNetWork(context: Context): Boolean {
        if (!NetWorkUtils.isNetWorkAvailable(context)) {


           IToast.show(context,"没有网络了")
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
