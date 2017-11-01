package com.xiangyao.train.ui

import android.os.Bundle
import android.view.View
import com.android.mvp.base.BaseActivity
import com.pawegio.kandroid.textWatcher
import com.xiangyao.train.presenter.LogInPresenter
import kotlinx.android.synthetic.main.activity_log_in.*
import xiangyao.yizhilu.com.studyjourny.R

class LogInActivity : BaseActivity<LogInPresenter, Any>() {
    override fun setAdapter() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * 点击重试要做的操作
     */
    override fun reloadActivity() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * 注入要替换的View
     */
    override fun injectTarget(): View {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * Base基本类
     */
    override fun getLayoutId(): Int {
        return R.layout.activity_log_in
    }

    /**
     * 设置toolbar
     */
    override fun initToolbar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * 设置initView
     *
     * kAndroid
     */
    override fun initView() {
        login_account_edt.textWatcher {
            beforeTextChanged { text, start, count, after -> }
            onTextChanged { text, start, before, count -> }
            afterTextChanged { text -> }
        }
    }

    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * 获取Presenter
     */
    override fun getPresenter(): LogInPresenter {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
    }
}
