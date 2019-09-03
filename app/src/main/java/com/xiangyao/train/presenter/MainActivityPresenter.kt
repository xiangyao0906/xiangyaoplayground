package com.xiangyao.train.presenter

import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import com.xiangyao.train.base.BasePresenter
import com.xiangyao.train.bean.Movie
import com.xiangyao.train.contract.MainActivityContract
import com.xiangyao.train.model.MainActivityModel
import rx.Subscriber

/**
 * Created by xiangyao on 2017/9/23.
 */

class MainActivityPresenter(re: RecyclerView) : BasePresenter<MainActivityContract.View>(), MainActivityContract.Presenter {

    companion object {
        var modle: MainActivityModel = MainActivityModel()

    }

    override fun getData(start: String, count: String, type: String) {
        mView?.showLoadingView()
        mContext?.let { checkNetWork(it) }
        addSubscription(modle.getData(start, count).subscribe(object : Subscriber<Movie>() {
            override fun onCompleted() {

                if (type.equals("onLoadMoreRequested")) {
                    mView?.loadMore()
                } else {
                    mView?.setAdapter()
                }

            }



            override fun onError(e: Throwable) {
                Log.i("wulalalal", "onError" + e.message)
                mView?.showDataError(e.message!!)

            }

            override fun onNext(listM_base: Movie) {
                mView?.showContent()
                Log.i("wulalalal", "onNext")
                /*
                * 在可以对返回内容做进一步判断
                *
                * **/
                mView?.showDataSuccess(listM_base)

            }
        }))

    }



}
