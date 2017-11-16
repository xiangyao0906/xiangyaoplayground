package xiangyao.yizhilu.com.studyjourny.ui

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.android.mvp.base.BaseActivity
import com.xiangyao.train.adapter.MovieAdapter
import com.xiangyao.train.bean.Movie
import com.xiangyao.train.contract.MainActivityContract
import com.xiangyao.train.presenter.MainActivityPresenter
import com.xiangyao.train.utils.Constant
import com.xiangyao.train.utils.ILog
import kotlinx.android.synthetic.main.activity_main.*
import xiangyao.yizhilu.com.studyjourny.R

@Route(path = "/ui/MainActivity")
class MainActivity : BaseActivity<MainActivityPresenter, Movie>(), MainActivityContract.View {
    /**
     * 注入要替换的View
     */
    override fun injectTarget(): View {
        return findViewById(R.id.movie_refresh)
    }

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


        ILog.i("集合的大小" + datas.subjects?.size.toString())
    }

    override fun showDataSuccess(datas: Movie) {
        this.datas = datas
    }

    override fun showDataError(errorMessage: String) {
        super.showDataError(errorMessage)
        showNetErrorView()
    }


    override fun getPresenter(): MainActivityPresenter {
        return MainActivityPresenter(movie_refresh, movie_list)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initToolbar() {
    }

    override fun initView() {
        mPresenter.attachView(this, this)
    }

    override fun initData() {
        mPresenter.getData("0", "0")
    }


}
