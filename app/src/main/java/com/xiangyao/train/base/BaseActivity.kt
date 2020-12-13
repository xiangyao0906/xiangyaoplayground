package com.xiangyao.train.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import androidx.fragment.app.FragmentActivity
import com.xiangyao.train.utils.AppManager
import com.xiangyao.train.utils.KeyBoardUtils


abstract class BaseActivity<T : BasePresnterIm, V> : FragmentActivity(), BaseViewI<V> {

    private var TAG: String? = null

    open lateinit var mPresenter: T

    var context: Context? = null


    private var application: DemoApplication? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        context = this

        AppManager.instance.addActivity(this)
        TAG = this.javaClass.simpleName

        mPresenter = getPresenter()

        initView()
        initToolbar()
        initData()
        application = DemoApplication()


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
    abstract fun getPresenter(): T


    override fun onDestroy() {
        super.onDestroy()
        application = null
        mPresenter.unsubcrible()
    }

    override fun showDataError(errorMessage: String) {
        showNetErrorView()
    }

    override fun showDataSuccess(datas: V) {
        showContent()
    }

    /**
     * 加载失败的View
     */
    override fun showNetErrorView() {

    }

    override fun showLoadingView() {
    }

    /**
     * 加载不到数据的View
     */
    override fun showEmptyView(msg: String) {
    }

    private var isContentAlready: Boolean = false

    override fun showContent() {
    }


    /**
     * 点击空白处影藏输入法
     */
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        // TODO Auto-generated method stub
        if (ev.action == MotionEvent.ACTION_DOWN) {
            val view = currentFocus
            if (view != null) {
                if (KeyBoardUtils.isShouldHideKeyboard(view, ev)) {
                    KeyBoardUtils.hideSoftInput(view.windowToken,
                            applicationContext)
                }
            }

        }
        return super.dispatchTouchEvent(ev)
    }


    fun startActivity(targetActivityClass: Class<*>) {
        val intent = Intent(this, targetActivityClass)
        startActivity(intent)
        //        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    fun startActivity(targetActivityClass: Class<*>, bundle: Bundle) {
        val intent = Intent(this, targetActivityClass)
        intent.putExtras(bundle)
        startActivity(intent)
    }

}
