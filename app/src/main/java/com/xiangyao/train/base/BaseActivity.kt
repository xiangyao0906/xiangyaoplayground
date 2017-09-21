package xiangyao.yizhilu.com.studyjourny.base

import android.app.Activity
import android.os.Bundle


abstract class BaseActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getContenView()

    }

    abstract fun getContenView(): Int

    abstract fun  iniData()

    abstract fun addOlicListener()

}
