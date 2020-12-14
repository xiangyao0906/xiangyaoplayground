package com.xiangyao.train.base

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract  class BaseFragment <T : BasePresnterIm, V> : Fragment(), BaseViewI<V> {
    open lateinit var mPresenter: T


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        mPresenter = getPresenter()

        initView()


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }


    /**
     * Base基本类
     */
    abstract fun getLayoutId(): Int
    /**
     * 设置initView
     */
    protected abstract fun initView()

    protected abstract fun initData()

    /**
     * 获取Presenter
     */
    abstract fun getPresenter(): T


    override fun onDestroyView() {
        super.onDestroyView()
        mPresenter.unsubcrible()
    }

    override fun showDataError(errorMessage: String) {
        showNetErrorView()
    }

    override fun showDataSuccess(datas: V) {
        showContent()
    }

    fun startActivity(targetActivityClass: Class<*>) {
        val intent = Intent(this.requireActivity(), targetActivityClass)
        startActivity(intent)
        //        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    fun startActivity(targetActivityClass: Class<*>, bundle: Bundle) {
        val intent = Intent(this.requireActivity(), targetActivityClass)
        intent.putExtras(bundle)
        startActivity(intent)
    }


}