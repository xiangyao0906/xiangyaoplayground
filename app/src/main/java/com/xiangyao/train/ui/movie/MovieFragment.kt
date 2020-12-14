package com.xiangyao.train.ui.movie

import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.xiangyao.train.base.BaseFragment
import com.xiangyao.train.bean.CityBean
import com.xiangyao.train.contract.MovieContract
import com.xiangyao.train.database.CityDaoHelper
import com.xiangyao.train.presenter.MoviePresenter
import com.xiangyao.train.ui.movie.show.OnShowFragment
import kotlinx.android.synthetic.main.fragment_find.*
import xiangyao.yizhilu.com.studyjourny.R

class MovieFragment : BaseFragment<MoviePresenter, Nothing>(), MovieContract.View {

    //titles
    private val pageTitles by lazy {
        arrayListOf("正在热映", "影院", "即将上映")
    }

    //fragments
    private val fragments by lazy {
        arrayListOf(
                OnShowFragment(),
                OnShowFragment(),
                OnShowFragment()
        )
    }

    override fun getLayoutId(): Int = R.layout.fragment_find

    override fun initView() {

        mPresenter.attachView(this, this.requireActivity())
    }

    override fun initData() {


        mPresenter.getMoviesCitys()
        setTab()
        initViewPager()


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

    private fun initViewPager() {
        viewPager.adapter = object : FragmentPagerAdapter(
                childFragmentManager,
                BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        ) {
            override fun getItem(position: Int): Fragment = fragments[position]

            override fun getCount(): Int = fragments.size

        }

        tabLayout.setupWithViewPager(viewPager)

        viewPager.offscreenPageLimit = 2

        tabLayout.removeAllTabs()

        setTab()

    }



    private fun setTab() {
        pageTitles.forEach { label ->
            val tab: TabLayout.Tab = tabLayout.newTab()
            tab.let {
                it.setCustomView(R.layout.tab_item_layout)

                it.customView?.let { view ->
                    //設置標題
                    view.findViewById<TextView>(R.id.tvLabel).text = label
                    //设置底部线条
                    view.findViewById<ImageView>(R.id.tabLine)
                            .setBackgroundResource(R.drawable.movie_tab_home)
                }

            }
            tabLayout.addTab(tab)
        }
    }
}