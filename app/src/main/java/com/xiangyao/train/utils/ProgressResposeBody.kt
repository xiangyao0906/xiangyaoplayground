package com.xiangyao.train.utils

import com.xiangyao.train.listenner.ProgressListener

import java.io.IOException

import okhttp3.MediaType
import okhttp3.ResponseBody
import okio.Buffer
import okio.BufferedSource
import okio.ForwardingSource
import okio.Okio

/**
 * Created by xiangyao on 2017/10/14.
 *
 *
 * 用拦截器监听OKhttp下载文件的速度
 */

class ProgressResposeBody(private val responseBody: ResponseBody, private val progressListener: ProgressListener) : ResponseBody() {

    override fun contentType(): MediaType? {
        return responseBody.contentType()
    }

    override fun contentLength(): Long {
        return responseBody.contentLength()
    }

    override fun source(): BufferedSource {
        return Okio.buffer(object : ForwardingSource(responseBody.source()) {
            /**
             * 文件总的大小
             */
            internal var totalSize = 0L
            /**
             * 已经下载的大小
             */
            internal var sum = 0L

            @Throws(IOException::class)
            override fun read(sink: Buffer, byteCount: Long): Long {
                if (totalSize == 0 as Long) {
                    totalSize = contentLength()
                }

                val len = super.read(sink, byteCount)

                sum += if (len == -1 as Long) 0 else len
                /**

                 * 这里把文件写入本地

                 */

                val progress = (sum * 1.0 / totalSize * 100).toInt()

                if (len == -1 as Long) {
                    progressListener.onDone(totalSize.toInt())
                } else
                    progressListener.onProgress(progress)

                return sum
            }
        })
    }

}
