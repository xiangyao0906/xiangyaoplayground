package com.xiangyao.train.ui

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.xiangyao.train.base.BaseActivity
import com.xiangyao.train.bean.Movie
import com.xiangyao.train.contract.MainActivityContract
import com.xiangyao.train.presenter.MainActivityPresenter
import com.xiangyao.train.ui.find.MovieFragment
import com.xiangyao.train.ui.home.HomeFragment
import com.xiangyao.train.ui.message.MessageFragment
import com.xiangyao.train.utils.RouteConstant
import kotlinx.android.synthetic.main.activity_main.*
import xiangyao.yizhilu.com.studyjourny.R

@Route(path = RouteConstant.MAINACTIVITY)
class MainActivity : BaseActivity<MainActivityPresenter, Movie>(), MainActivityContract.View {
    //未选中icon
    private val normalIcon = intArrayOf(R.mipmap.index, R.mipmap.find, R.mipmap.message, R.mipmap.me)
    private val tabText = arrayOf("首页", "发现", "消息", "我的")
    //选中时icon
    private val selectIcon = intArrayOf(R.mipmap.index1, R.mipmap.find1, R.mipmap.message1, R.mipmap.me1)

    private val fragments: ArrayList<Fragment> = ArrayList()


    override fun getPresenter(): MainActivityPresenter = MainActivityPresenter()

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initToolbar() {
    }

    override fun initView() {
        mPresenter.attachView(this, this)

    }

    override fun initData() {

        fragments.add(HomeFragment())
        fragments.add(MovieFragment())
        fragments.add(MessageFragment())
        fragments.add(MessageFragment())

        navigationBar.titleItems(tabText)
                .normalIconItems(normalIcon)
                .selectIconItems(selectIcon)
                .fragmentList(fragments)
                .fragmentManager(supportFragmentManager)
                .canScroll(false)
                .build()
    }


}
