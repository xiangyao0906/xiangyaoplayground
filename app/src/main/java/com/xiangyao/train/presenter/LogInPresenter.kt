package com.xiangyao.train.presenter

import com.xiangyao.train.base.BasePresenter
import com.xiangyao.train.base.BasePresenterI
import com.xiangyao.train.contract.LogInContract

/**
 * Created by xiangyao on 2017/10/31.
 */

class LogInPresenter : BasePresenter<LogInContract.View>(), LogInContract.Presenter {
    override fun longIn(name: String, pwd: String) {

    }
}
