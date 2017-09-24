package com.xiangyao.train.base

import android.view.View

/**
 * Created by ming on 2017/9/14.
 */

interface BaseView<V> {


    /**
     * 数据加载失败
     * tag==1,正常错误，可以只显示toast
     * tag=0,非正常错误，需要考虑显示错误界面
     */
    fun showDataError(errorMessage: String)

    /**
     * 数据加载成功
     */
    fun showDataSuccess(datas: V)

    fun setAdapter()


    /**
     * 显示加载进度
     */
    fun showProgress()

    /**
     * 显示加载进度
     */
    fun hideProgress()

    /**
     * 点击重新加载
     */
    fun onReload()

    /**
     * 显示无网络视图
     */
    fun showNetErrorView()

    /**
     * 没有加载到内容
     */
    fun showEmptyView(msg: String)

    /**
     * 显示内容View
     */
    fun showContent()

}
