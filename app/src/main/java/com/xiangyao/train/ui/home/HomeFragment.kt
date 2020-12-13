package com.xiangyao.train.ui.home

import androidx.recyclerview.widget.LinearLayoutManager
import cc.shinichi.library.ImagePreview
import cc.shinichi.library.bean.ImageInfo
import com.google.android.material.snackbar.Snackbar
import com.xiangyao.train.adapter.GrilsAdapter
import com.xiangyao.train.adapter.HomeTagAdapter
import com.xiangyao.train.base.BaseFragment
import com.xiangyao.train.bean.BannerBean
import com.xiangyao.train.bean.GirlBean
import com.xiangyao.train.bean.HomeTagBean
import com.xiangyao.train.utils.RefreshLayoutUtil
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.util.LogUtils
import kotlinx.android.synthetic.main.fragment_home.*
import xiangyao.yizhilu.com.studyjourny.R


class HomeFragment : BaseFragment<HomePresenter, Nothing>(), HomeContract.View {

    lateinit var grilsAdapter: GrilsAdapter
    var page = 1
    var limit = 10

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun initView() {

        mPresenter.attachView(this, this.requireActivity())
    }

    override fun initData() {

        mPresenter.concactData()

        mPresenter.findSomeGirls(page, limit)

        smartRefresh.setOnRefreshListener {
            mPresenter.concactData()
            mPresenter.findSomeGirls(page, limit)
        }

        grilsAdapter = GrilsAdapter(arrayListOf())

        grilsAdapter.setOnItemClickListener { adapter, _, position ->
            ImagePreview
                    .getInstance()
                    .setContext(this.requireActivity())
                    .setImage((adapter.data[position] as GirlBean).url)// 图片集合
                    .setShowDownButton(true)// 是否显示下载按钮
                    .setFolderName("BigImageViewDownload")// 设置下载到的文件夹名（保存到根目录）
                    .setZoomTransitionDuration(500)// 设置缩放的动画时长
                    .setEnableDragClose(true)
                    .start()// 开始跳转


        }
    }

    override fun getPresenter(): HomePresenter = HomePresenter()


    override fun showBanner(banners: MutableList<BannerBean>) {

        RefreshLayoutUtil.finishRefreshLayout(smartRefresh)
        val homeBannerAdapter = HomeBannerAdapter(banners as ArrayList<BannerBean>)

        banner.adapter = homeBannerAdapter

        banner.addBannerLifecycleObserver(this) //添加生命周期观察者
                .setIndicator(CircleIndicator(this.requireActivity())) //设置指示器
                .setOnBannerListener { data: Any, position: Int ->
                    Snackbar.make(banner, (data as BannerBean).title, Snackbar.LENGTH_SHORT).show()
                    LogUtils.d("position：$position")
                }


    }


    override fun showHomeTag(tags: MutableList<HomeTagBean>) {

        tagRv.layoutManager = LinearLayoutManager(this.requireActivity(), LinearLayoutManager.HORIZONTAL, false)

        tagRv.adapter = HomeTagAdapter(tags)


    }

    override fun showGirls(girls: MutableList<GirlBean>) {

        grilsAdapter.data = girls

        girlRv.layoutManager = LinearLayoutManager(this.requireActivity())

        girlRv.adapter = grilsAdapter


        RefreshLayoutUtil.finishRefreshLayout(smartRefresh)

    }

    override fun showDataError(errorMessage: String) {
    }

    override fun showDataSuccess(datas: Nothing) {
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