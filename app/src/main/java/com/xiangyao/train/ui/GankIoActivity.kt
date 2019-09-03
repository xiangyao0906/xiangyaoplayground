package com.xiangyao.train.ui

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.android.mvp.base.BaseActivity
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.xiangyao.train.adapter.GankIoAdapter
import com.xiangyao.train.bean.Fuli
import com.xiangyao.train.contract.GankIoActivityContract
import com.xiangyao.train.presenter.GankIoActivityPresenter
import com.xiangyao.train.utils.FileSaveUtils
import com.xiangyao.train.utils.RouteConstant
import io.reactivex.ObservableOnSubscribe
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_gank_io.*
import xiangyao.yizhilu.com.studyjourny.R


@Route(path = RouteConstant.GANKIOACTIVITY)
class GankIoActivity : BaseActivity<GankIoActivityPresenter, Fuli>(), GankIoActivityContract.View {

    lateinit var fuli: Fuli

    override fun setAdapter() {

        meizi_recycleview.layoutManager = LinearLayoutManager(this)
        meizi_recycleview.adapter = GankIoAdapter(R.layout.gankio_item, fuli.results!!)

        meizi_recycleview.addOnItemTouchListener(object : OnItemChildClickListener() {
            override fun onSimpleItemChildClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
                saveToAlbum(view!!)
            }
        })

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

    @SuppressLint("CheckResult")
    private fun saveToAlbum(view: View) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))
        view.layout(0, 0, view.measuredWidth, view.measuredHeight)
        view.buildDrawingCache()


        io.reactivex.Observable.create<Bitmap> {
            ObservableOnSubscribe<Bitmap> { emitter ->
                val bitmap1 = view.drawingCache
                emitter.onNext(bitmap1)
            }
        }.map { t -> FileSaveUtils.saveImageToGallery(this@GankIoActivity, t, "share_code") }
                .subscribeOn(Schedulers.io())
                .observeOn(io.reactivex.android.schedulers.AndroidSchedulers.mainThread())
                .subscribe { boolean -> Toast.makeText(this@GankIoActivity, "保存成功", Toast.LENGTH_LONG).show() }


    }
}
