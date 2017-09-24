package com.xiangyao.train.contract

import com.xiangyao.train.base.BaseView
import com.xiangyao.train.bean.Movie

/**
 * Created by xiangyao on 2017/9/23.
 */

interface MainActivityContract {



    interface View :BaseView<Movie>{



        fun closeProgress()
    }

    interface Presenter  {
        fun getData(start: String, count: String)
    }
}
