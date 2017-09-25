package com.xiangyao.train.contract

import com.xiangyao.train.base.BaseViewI
import com.xiangyao.train.bean.Movie

/**
 * Created by xiangyao on 2017/9/23.
 */

interface MainActivityContract {



    interface View :BaseViewI<Movie>

    interface Presenter {
        fun getData(start: String, count: String)
    }
}
