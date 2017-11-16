package xiangyao.yizhilu.com.studyjourny.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AccelerateDecelerateInterpolator
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_welcome.*
import xiangyao.yizhilu.com.studyjourny.R

@Route(path = "/ui/WelcomeActivity")
class WelcomeActivity : AppCompatActivity() {

    /*
    *   引用自  https://github.com/geftimov
    * **/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
    }

    override fun onResume() {
        super.onResume()

        pathView.pathAnimator
                .delay(100)
                .duration(1500)
                .interpolator(AccelerateDecelerateInterpolator())
                .listenerEnd {
                    ARouter.getInstance().build("/ui/GuideActivity")
                            .withString("title", "引导页")
                            .navigation()
                    finish()
                }
                .start()
    }

}
