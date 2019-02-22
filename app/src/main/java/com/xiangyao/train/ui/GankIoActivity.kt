package com.xiangyao.train.ui

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.android.mvp.base.BaseActivity
import com.xiangyao.train.adapter.GankIoAdapter
import com.xiangyao.train.bean.Fuli
import com.xiangyao.train.contract.GankIoActivityContract
import com.xiangyao.train.presenter.GankIoActivityPresenter
import com.xiangyao.train.utils.RouteConstant
import kotlinx.android.synthetic.main.activity_gank_io.*
import xiangyao.yizhilu.com.studyjourny.R



@Route(path = RouteConstant.GANKIOACTIVITY)
class GankIoActivity : BaseActivity<GankIoActivityPresenter, Fuli>(), GankIoActivityContract.View {

    lateinit var fuli: Fuli

    override fun setAdapter() {
        meizi_recycleview.layoutManager = LinearLayoutManager(this)
        meizi_recycleview.adapter = GankIoAdapter(R.layout.gankio_item, fuli.results!!)

    }

    /**
     * 点击重试要做的操作
     */
    override fun reloadActivity() {
    }

    /**
     * 注入要替换的View
     */
    override fun injectTarget(): View = rootview

    /**
     * Base基本类
     */
    override fun getLayoutId(): Int = R.layout.activity_gank_io

    /**
     * 设置toolbar
     */
    override fun initToolbar() {

    }

    /**
     * 设置initView
     */
    override fun initView() {
        mPresenter.attachView(this, this)
    }

    override fun initData() {
        mPresenter.findSomeFuli()
    }

    /**
     * 获取Presenter
     */
    override fun getPresenter(): GankIoActivityPresenter {
        return GankIoActivityPresenter()
    }

    override fun showDataSuccess(datas: Fuli) {
        fuli = datas
    }

}
