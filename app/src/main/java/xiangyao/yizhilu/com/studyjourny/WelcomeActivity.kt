package xiangyao.yizhilu.com.studyjourny

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        guideImage!!.setOnClickListener { startActivity(Intent(this,MainActivity::class.java)) }
    }
}
