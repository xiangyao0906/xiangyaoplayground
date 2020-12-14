package com.xiangyao.train.ui.movie.show

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.activity_movie_details.videoView
import kotlinx.android.synthetic.main.activity_welcome.*
import xiangyao.yizhilu.com.studyjourny.R

/**
 *
 * <p>
 * Created by xiangyao on 12/14/20.
 *
 * // 20201214182349
// https://m.maoyan.com/ajax/detailmovie?movieId=1325487
 */

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)



        videoView.setVideoURI(Uri.parse("https://vod.pipi.cn/fec9203cvodtransbj1251246104/9de7676a5285890811166362356/v.f42906.mp4"))
        videoView.start()

    }
}