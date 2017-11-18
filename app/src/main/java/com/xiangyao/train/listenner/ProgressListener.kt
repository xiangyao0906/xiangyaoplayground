package com.xiangyao.train.listenner

/**
 * Created by xiangyao on 2017/10/14.
 */

interface ProgressListener {
    fun onProgress(progress: Int)

    fun onDone(totalSize: Int)
}
