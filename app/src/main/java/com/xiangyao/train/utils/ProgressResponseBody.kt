package com.xiangyao.train.utils

import com.xiangyao.train.listenner.ProgressListener

import java.io.IOException

import okhttp3.MediaType
import okhttp3.ResponseBody
import okio.*

/**
 * Created by xiangyao on 2017/10/14.
 *
 *
 * 用拦截器监听OKhttp下载文件的速度
 */

class ProgressResponseBody(private val responseBody: ResponseBody, private val progressListener: ProgressListener) : ResponseBody() {

    override fun contentType(): MediaType? {
        return responseBody.contentType()
    }

    override fun contentLength(): Long {
        return responseBody.contentLength()
    }

    override fun source(): BufferedSource {
        return object : ForwardingSource(responseBody.source()) {
            /**
             * 文件总的大小
             */
            /**
             * 文件总的大小
             */
            var totalSize = 0L
            /**
             * 已经下载的大小
             */
            /**
             * 已经下载的大小
             */
            var sum = 0L

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

                /**

                 * 这里把文件写入本地

                 */

                val progress = (sum * 1.0 / totalSize * 100).toInt()

                if (len == (-1).toLong()) {
                    progressListener.onDone(totalSize.toInt())
                } else
                    progressListener.onProgress(progress)

                return sum
            }
        }.buffer()
    }

}
