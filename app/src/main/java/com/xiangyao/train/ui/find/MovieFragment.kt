package com.xiangyao.train.ui.find

import androidx.recyclerview.widget.LinearLayoutManager
import com.xiangyao.train.base.BaseFragment
import com.xiangyao.train.bean.CityBean
import com.xiangyao.train.bean.MovieBean
import com.xiangyao.train.contract.MovieContract
import com.xiangyao.train.database.CityDaoHelper
import com.xiangyao.train.presenter.MoviePresenter
import kotlinx.android.synthetic.main.fragment_find.*
import xiangyao.yizhilu.com.studyjourny.R

class MovieFragment : BaseFragment<MoviePresenter, Nothing>(), MovieContract.View {

    override fun getLayoutId(): Int = R.layout.fragment_find
    lateinit var movieAdapter: MovieAdapter

    override fun initView() {

        mPresenter.attachView(this, this.requireActivity())
    }

    override fun initData() {


        mPresenter.getMoviesCitys()

        movieAdapter= MovieAdapter(arrayListOf())


        movieRv.layoutManager=LinearLayoutManager(this.requireActivity())

        movieRv.adapter=movieAdapter

        mPresenter.getOnShowMovies()
    }

    override fun getPresenter(): MoviePresenter = MoviePresenter()

    override fun showMoviesCitys(arrayList: ArrayList<CityBean>) {

        CityDaoHelper.instance.instertAllCitys(arrayList)


    }

    override fun showOnShowMovies(movieData: ArrayList<MovieBean>) {
        movieAdapter.data=movieData
        movieAdapter.notifyDataSetChanged()

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