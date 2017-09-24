package com.xiangyao.train.presenter

import android.util.Log
import com.xiangyao.train.base.BasePresenter
import com.xiangyao.train.bean.Movie
import com.xiangyao.train.contract.MainActivityContract
import com.xiangyao.train.model.MainActivityModel
import com.xiangyao.train.utils.ILog
import rx.Subscriber

/**
 * Created by xiangyao on 2017/9/23.
 */

class MainActivityPresenter : BasePresenter<MainActivityContract.View>(), MainActivityContract.Presenter {



    companion object {

        var modle: MainActivityModel = MainActivityModel()
    }

    override fun getData(start: String, count: String) {
        ILog.i("获取数据")
        context?.let { checkNetWork(it) }
        addSubscription(modle.getData(start, count).subscribe(object : Subscriber<Movie>() {
            override fun onCompleted() {
                mView?.setAdapter()
            }

            override fun onError(e: Throwable) {
                Log.i("wulalalal","onError"+e.message)
                mView?.showDataError(e.message!!)

            }

            override fun onNext(listM_base: Movie) {
                Log.i("wulalalal","onNext")
                /*
                * 在可以对返回内容做进一步判断
                *
                * **/
                mView?.showDataSuccess(listM_base)

            }
        }))

    }



}
