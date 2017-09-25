package com.android.mvp.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.view.*
import android.widget.FrameLayout
import android.widget.Toast
import com.xiangyao.train.base.BasePresnterIm
import com.xiangyao.train.base.BaseViewI
import com.xiangyao.train.base.DemoApplication
import com.xiangyao.train.utils.GeneralUtil
import com.xiangyao.train.utils.KeyBoardUtils
import com.xiangyao.train.utils.NetWorkUtils
import com.xiangyao.train.utils.PageStateManager
import xiangyao.yizhilu.com.studyjourny.R


abstract class BaseActivity<T : BasePresnterIm, V> : Activity(), BaseViewI<V> {

    private var TAG: String? = null

    var mPresenter: T? = null

    var context: Context? = null

    private var pageStateManager: PageStateManager? = null

    private var application: DemoApplication? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        context = this


        TAG = this.javaClass.simpleName

        if (null != getPresenter()) {
            mPresenter = getPresenter()
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP)
            setTranslucentStatus(resources.getColor(R.color.colorPrimaryDark))


        initView()
        initToolbar()
        initData()
        application = DemoApplication()


    }


    /**
     * 设置状态栏背景状态
     *
     *
     * 4.4以上，5.0以下
     */
    fun setTranslucentStatus(color: Int) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val win = window
            val winParams = win.attributes
            val bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            winParams.flags = winParams.flags or bits
            win.attributes = winParams
        }
    }


    /**
     * Base基本类
     */
    abstract fun getLayoutId(): Int

    /**
     * 设置toolbar
     */
    protected abstract fun initToolbar()

    /**
     * 设置initView
     */
    protected abstract fun initView()

    protected abstract fun initData()

    /**
     * 获取Presenter
     */
    abstract fun getPresenter(): T?


    /**
     * 显示加载弹框
     */

    override fun showProgress() {

    }

    override fun onDestroy() {
        super.onDestroy()
        application = null
        if (mPresenter != null) {
            mPresenter!!.unsubcrible()
        }
    }


    /**
     * 隐藏加载弹框
     */
    override fun hideProgress() {
    }


    override fun onReload() {

    }

    override fun showDataError(errorMessage: String) {
        hideProgress()
        showNetErrorView()
    }

    override fun showDataSuccess(datas: V) {
        showContent()
        hideProgress()
    }

    /**
     * 加载中的的View
     */
    fun showLoadingView(container: View?) {
        if (container != null) {
            pageStateManager = PageStateManager(container)
            pageStateManager!!.showLoading()
        }
    }

    /**
     * 加载失败的View
     */
    override fun showNetErrorView() {

        if (pageStateManager != null && !isContentAlready) {
            pageStateManager!!.showError()
            pageStateManager!!.setOnRetryClickListener({
                if (NetWorkUtils.isNetWorkAvailable(this@BaseActivity)) {
                    pageStateManager!!.showLoading()
                    onReload()
                } else {
                    Toast.makeText(this@BaseActivity, "网丢啦:-(", Toast.LENGTH_SHORT).show()
                }
            })
        }

    }

    /**
     * 加载不到数据的View
     */
    override fun showEmptyView(msg: String) {
        if (pageStateManager != null) {
            pageStateManager!!.showEmpty()
        }
    }

    private var isContentAlready: Boolean = false

    override fun showContent() {
        if (pageStateManager != null) {
            pageStateManager!!.showContent()
            isContentAlready = true
        }
    }


    val loadingTargetView: View?
        get() = null


    /**
     * 沉浸式状态栏：着色
     */
    fun titlestatusbar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            val window = window
            val mContentView = findViewById<View>(Window.ID_ANDROID_CONTENT) as ViewGroup

            //First translucent status bar.
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            val statusBarHeight = getStatusBarHeight(applicationContext)

            val mChildView = mContentView.getChildAt(0)
            if (mChildView != null) {
                val lp = mChildView.layoutParams as FrameLayout.LayoutParams
                //如果已经为 ChildView 设置过了 marginTop, 再次调用时直接跳过
                if (lp != null && lp.topMargin < statusBarHeight && lp.height != statusBarHeight) {
                    //不预留系统空间
                    ViewCompat.setFitsSystemWindows(mChildView, false)
                    lp.topMargin += statusBarHeight
                    mChildView.layoutParams = lp
                }
            }

            var statusBarView: View? = mContentView.getChildAt(0)
            if (statusBarView != null && statusBarView.layoutParams != null && statusBarView.layoutParams.height == statusBarHeight) {
                //避免重复调用时多次添加 View
                statusBarView.setBackgroundColor(resources.getColor(R.color.colorAccent))
                return
            }
            statusBarView = View(applicationContext)
            val lp = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, statusBarHeight)
            statusBarView.setBackgroundColor(resources.getColor(R.color.colorAccent))

            //向 ContentView 中添加假 View
            mContentView.addView(statusBarView, 0, lp)
        }
    }


    /**
     * 点击空白处影藏输入法
     */
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        // TODO Auto-generated method stub
        if (ev.action == MotionEvent.ACTION_DOWN) {
            val view = currentFocus
            if (GeneralUtil.isHideInput(view, ev)) {
                KeyBoardUtils.HideSoftInput(view!!.windowToken,
                        applicationContext)
            }

        }
        return super.dispatchTouchEvent(ev)
    }


    companion object {

        fun getStatusBarHeight(context: Context): Int {
            var result = 0
            val resourceId = context.resources.getIdentifier("status_bar_height", "dimen",
                    "android")
            if (resourceId > 0) {
                result = context.resources.getDimensionPixelSize(resourceId)
            }
            return result
        }
    }

    fun openActivity(targetActivityClass: Class<*>) {
        val intent = Intent(this, targetActivityClass)
        startActivity(intent)
        //        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    fun openActivity(targetActivityClass: Class<*>, bundle: Bundle) {
        val intent = Intent(this, targetActivityClass)
        intent.putExtras(bundle)
        startActivity(intent)
        //        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    fun openActivityAndCloseThis(targetActivityClass: Class<*>) {
        openActivity(targetActivityClass)
        this.finish()
        //        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    fun openActivityAndCloseThis(targetActivityClass: Class<*>, bundle: Bundle) {
        openActivity(targetActivityClass, bundle)
        this.finish()
        //        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }


}
