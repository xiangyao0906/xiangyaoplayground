package com.xiangyao.train.contract

import com.xiangyao.train.base.BaseViewI

/**
 * Created by xiangyao on 2017/10/31.
 */

interface LogInContract {

    interface View : BaseViewI<Any>

    interface Presenter {
        fun longIn(name: String, pwd: String)
    }
}
