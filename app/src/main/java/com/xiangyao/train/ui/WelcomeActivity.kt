package xiangyao.yizhilu.com.studyjourny.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import android.view.animation.AccelerateDecelerateInterpolator
import com.alibaba.android.arouter.launcher.ARouter
import com.pawegio.kandroid.startActivity
import com.xiangyao.train.ui.Main2Activity
import com.xiangyao.train.utils.RouteConstant
import kotlinx.android.synthetic.main.activity_welcome.*
import xiangyao.yizhilu.com.studyjourny.R


class WelcomeActivity : AppCompatActivity() {

    /*
    *   引用自  https://github.com/geftimov
    * **/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val window = window
        //隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        //隐藏状态栏
        //定义全屏参数
        val flag = WindowManager.LayoutParams.FLAG_FULLSCREEN
        //设置当前窗体为全屏显示
        window.setFlags(flag, flag)

        setContentView(R.layout.activity_welcome)
    }

    override fun onResume() {
        super.onResume()

        pathView.pathAnimator
                .delay(100)
                .duration(1500)
                .interpolator(AccelerateDecelerateInterpolator())
                .listenerEnd {

                    ARouter.getInstance()
                            .build(RouteConstant.GUIDEACTIVITY)
                            .withString("title","欢迎回家")
                            .navigation()


//                    startActivity(Intent(this,Main2Activity::class.java))

                    finish()
                }
                .start()
    }

}
