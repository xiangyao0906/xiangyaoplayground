package com.xiangyao.train.utils

import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by xiangyao on 2017/12/07.
 * 切换线程的工具
 */

object RxScedulerHelper {

    fun <T> io_main(): Observable.Transformer<T, T> {
        return Observable.Transformer { t: Observable<T> ->
            t.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }

}
