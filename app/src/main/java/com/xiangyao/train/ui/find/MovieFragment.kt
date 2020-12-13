package com.xiangyao.train.ui.find

import com.xiangyao.train.base.BaseFragment
import com.xiangyao.train.base.BaseSubscribe
import com.xiangyao.train.bean.CityBean
import com.xiangyao.train.contract.MovieContract
import com.xiangyao.train.database.CityDaoHelper
import com.xiangyao.train.presenter.MoviePresenter
import com.xiangyao.train.utils.showAtCenter
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_find.*
import xiangyao.yizhilu.com.studyjourny.R

class MovieFragment : BaseFragment<MoviePresenter, Nothing>(), MovieContract.View {

    override fun getLayoutId(): Int = R.layout.fragment_find

    override fun initView() {

        mPresenter.attachView(this, this.requireActivity())
    }

    override fun initData() {

        mPresenter.getMoviesCitys()


        CityDaoHelper.instance.countCites().toString().showAtCenter()


}

override fun getPresenter(): MoviePresenter = MoviePresenter()

override fun showMoviesCitys(arrayList: ArrayList<CityBean>) {

    CityDaoHelper.instance.instertAllCitys(arrayList)


}

override fun showLoadingView() {
}

override fun showNetErrorView() {
}

override fun showEmptyView(msg: String) {
}

override fun showContent() {
}
}