package com.xiangyao.train.base

import rx.Subscriber

abstract class BaseSubscribe<T> : Subscriber<T>() {

    override fun onCompleted() {
    }

    override fun onError(e: Throwable?) {
        _onError(e)
    }

    override fun onNext(t: T) {
        _onNext(t)

    }

    abstract fun _onNext(t: T)

    abstract fun _onError(e: Throwable?)
}