package com.xiangyao.train.model

import com.xiangyao.train.api.ApiManager
import com.xiangyao.train.bean.Fuli
import com.xiangyao.train.contract.GankIoActivityContract

import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * @author xiangyao
 * @date 2017/11/30
 */

class GankIoActivityModel : GankIoActivityContract.Model {


    override fun findSomeFuli(): Observable<Fuli> {
        return ApiManager.getApistore()!!.getFuli().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}
