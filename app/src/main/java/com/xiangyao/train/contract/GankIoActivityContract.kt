package com.xiangyao.train.contract

import com.xiangyao.train.base.BaseViewI
import com.xiangyao.train.bean.Fuli
import rx.Observable

/**
 * Created by xiangyao on 2017/11/30.
 */

interface GankIoActivityContract {

    interface Model {
        fun findSomeFuli(): Observable<Fuli>
    }

    interface View : BaseViewI<Fuli>

    interface Presenter {

        fun findSomeFuli()
    }
}
