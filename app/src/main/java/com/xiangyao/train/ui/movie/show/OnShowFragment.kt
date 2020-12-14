package com.xiangyao.train.ui.movie.show


import androidx.recyclerview.widget.LinearLayoutManager
import com.xiangyao.train.base.BaseFragment
import com.xiangyao.train.bean.MovieBean
import com.xiangyao.train.contract.MovieOnShowContract
import com.xiangyao.train.presenter.MovieOnShowPresenter
import com.xiangyao.train.ui.movie.MovieAdapter
import kotlinx.android.synthetic.main.fragment_on_show.*
import xiangyao.yizhilu.com.studyjourny.R

/**
 *
 * <p>正在上映或者预售
 * Created by xiangyao on 12/14/20.
 */
class OnShowFragment : BaseFragment<MovieOnShowPresenter, Nothing>(), MovieOnShowContract.View {
    lateinit var movieAdapter: MovieAdapter


    override fun getLayoutId(): Int = R.layout.fragment_on_show

    override fun initView() {
        mPresenter.attachView(this, this.requireActivity())
    }

    override fun initData() {

        movieAdapter= MovieAdapter(arrayListOf())

        mPresenter.getOnShowMovies()

        movieRv.layoutManager = LinearLayoutManager(this.requireActivity())

        movieRv.adapter = movieAdapter

        movieAdapter.setOnItemClickListener { adapter, view, position ->


            startActivity(MovieDetailsActivity::class.java)
        }

    }

    override fun getPresenter(): MovieOnShowPresenter = MovieOnShowPresenter()

    override fun showOnShowMovies(movieData: ArrayList<MovieBean>) {
        movieAdapter.data = movieData
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