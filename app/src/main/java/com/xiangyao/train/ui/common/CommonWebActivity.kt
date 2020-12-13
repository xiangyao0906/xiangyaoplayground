package com.xiangyao.train.ui.common

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.just.agentweb.AgentWeb
import com.xiangyao.train.utils.RouteConstant
import kotlinx.android.synthetic.main.activity_common_web.*
import xiangyao.yizhilu.com.studyjourny.R


@Route(path = RouteConstant.COMMON_WEB)
class CommonWebActivity : AppCompatActivity() {
    @Autowired
    @JvmField
    var title = ""


    @Autowired
    @JvmField
    var webUrl = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common_web)
        ARouter.getInstance().inject(this)
        titleTv.text=title
        AgentWeb.with(this)
                .setAgentWebParent(webParent, LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go(webUrl)
    }
}