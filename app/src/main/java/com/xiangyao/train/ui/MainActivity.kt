package xiangyao.yizhilu.com.studyjourny.ui

import android.support.v7.widget.LinearLayoutManager
import com.android.mvp.base.BaseActivity
import com.xiangyao.train.adapter.MovieAdapter
import com.xiangyao.train.bean.Movie
import com.xiangyao.train.contract.MainActivityContract
import com.xiangyao.train.presenter.MainActivityPresenter
import com.xiangyao.train.ui.Student
import com.xiangyao.train.utils.DateFactory
import com.xiangyao.train.utils.ILog
import kotlinx.android.synthetic.main.activity_main.*
import xiangyao.yizhilu.com.studyjourny.R

class MainActivity : BaseActivity<MainActivityPresenter, Movie>(), MainActivityContract.View {

    private var datas: Movie? = null

    override fun setAdapter() {

        movie_list.layoutManager = LinearLayoutManager(this)
        movie_list.adapter = MovieAdapter(datas, this)
        ILog.i("集合的大小" + datas?.subjects?.size.toString())
    }

    override fun showDataSuccess(datas: Movie) {
        this.datas = datas
    }

    override fun showDataError(errorMessage: String) {
        super.showDataError(errorMessage)
        showNetErrorView()
    }



    override fun getPresenter(): MainActivityPresenter? {
        return MainActivityPresenter()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initToolbar() {
    }

    override fun initView() {
        mPresenter?.attachView(this, this)
    }

    override fun initData() {
        mPresenter?.getData("0", "0")
    }


    private fun haha() {
        var abc: ArrayList<Student> = DateFactory.getInputObject(10)
        for (student: Student in abc) {
            ILog.i(student.name!!)
        }
    }
}
