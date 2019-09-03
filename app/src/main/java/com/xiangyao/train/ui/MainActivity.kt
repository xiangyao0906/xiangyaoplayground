package xiangyao.yizhilu.com.studyjourny.ui

import android.graphics.Color
import com.google.android.material.snackbar.Snackbar
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.recyclerview.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.android.mvp.base.BaseActivity
import com.chad.library.adapter.base.BaseQuickAdapter
import com.xiangyao.train.adapter.MovieAdapter
import com.xiangyao.train.bean.Movie
import com.xiangyao.train.contract.MainActivityContract
import com.xiangyao.train.presenter.MainActivityPresenter
import com.xiangyao.train.utils.Constant
import com.xiangyao.train.utils.RouteConstant
import kotlinx.android.synthetic.main.activity_main.*
import xiangyao.yizhilu.com.studyjourny.R

@Route(path = RouteConstant.MAINACTIVITY)
class MainActivity : BaseActivity<MainActivityPresenter, Movie>(), MainActivityContract.View, BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.OnItemChildClickListener {
    override fun onItemChildClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        view?.let { Snackbar.make(it,"当前的位置 $position ", Snackbar.LENGTH_SHORT).show() }
    }

    override fun loadMore() {
        Log.i("xiangyao", "加载更多")
        (movie_list.adapter as MovieAdapter).setNewData(datas.subjects!!)
        (movie_list.adapter as MovieAdapter).notifyDataSetChanged()

    }

    var type: String = "onRefresh"
    var currentcount: Int = 10
    /**
     * Called when a swipe gesture triggers a refresh.
     */
    override fun onRefresh() {
        type = "onRefresh"
        mPresenter.getData("0", "0", type)
        swipeLayout.isRefreshing = false
    }

    override fun onLoadMoreRequested() {
        type = "onLoadMoreRequested"
        currentcount+=10
        mPresenter.getData("0", currentcount.toString(), type)
    }

    /**
     * 注入要替换的View
     */
    override fun injectTarget(): View = findViewById(R.id.swipeLayout)

    /**
     * 点击重试要做的操作
     */
    override fun reloadActivity() {
    }


    private lateinit var datas: Movie

    override fun setAdapter() {

        movie_list.layoutManager = LinearLayoutManager(this)
        movie_list.adapter = MovieAdapter(R.layout.lisview_item, datas.subjects)

        (movie_list.adapter as MovieAdapter).openLoadAnimation(Constant.GLOPBALLANIMA)
        (movie_list.adapter as MovieAdapter).isFirstOnly(false)
        //设置动画从第三条item开始
        (movie_list.adapter as MovieAdapter).setNotDoAnimationCount(3)
        (movie_list.adapter as MovieAdapter).setOnLoadMoreListener(this, movie_list)

        currentcount = (movie_list.adapter as MovieAdapter).data.size

        (movie_list.adapter as MovieAdapter).onItemChildClickListener=this
    }

    override fun showDataSuccess(datas: Movie) {
        this.datas = datas
    }

    override fun showDataError(errorMessage: String) {
        super.showDataError(errorMessage)
        showNetErrorView()
    }


    override fun getPresenter(): MainActivityPresenter =
            MainActivityPresenter(movie_list)

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initToolbar() {
    }

    override fun initView() {
        mPresenter.attachView(this, this)

        swipeLayout.setOnRefreshListener(this)
        swipeLayout.setColorSchemeColors(Color.rgb(47, 223, 189))

    }

    override fun initData() {
        mPresenter.getData("0", currentcount.toString(), "")
    }


}
