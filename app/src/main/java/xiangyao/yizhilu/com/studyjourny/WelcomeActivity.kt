package xiangyao.yizhilu.com.studyjourny

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AccelerateDecelerateInterpolator
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    /*
    *   引用自  https://github.com/geftimov
    * **/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

//        guideImage!!.setOnClickListener { startActivity(Intent(this,MainActivity::class.java)) }

//        val pathView = findViewById<PathView>(R.id.pathView)

    }

    override fun onResume() {
        super.onResume()

        pathView.pathAnimator
                .delay(100)
                .duration(1500)
                .interpolator(AccelerateDecelerateInterpolator())
                .listenerEnd {
                    startActivity(Intent(this,MainActivity::class.java))
                    finish()
                }
                .start()
    }

}
