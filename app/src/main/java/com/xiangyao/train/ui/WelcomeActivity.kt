package com.xiangyao.train.ui

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.xiangyao.train.utils.AssetsUtil
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

//        initView()


        ARouter.getInstance()
                .build(RouteConstant.MAINACTIVITY)
                .withString("title", "欢迎回家")
                .navigation()
    }

    private fun initView() {
        val videoPath=AssetsUtil.getAssetsCacheFile(this,"split_video.mp4")
        //加载 /res/raw下的视频进行播放。注意MediaPlayer支持的格式，一般要求后台传输压缩过得MP4视频。
        videoView.setVideoURI(Uri.parse(videoPath))

        videoView.setOnPreparedListener { mp ->
            mp.start()
            mp.isLooping = false
        }
        videoView.setOnCompletionListener {
            videoView.suspend() //释放所有配置信息和内存.
            ARouter.getInstance()
                    .build(RouteConstant.MAINACTIVITY)
                    .withString("title", "欢迎回家")
                    .navigation()
            finish()
        }
    }


}
