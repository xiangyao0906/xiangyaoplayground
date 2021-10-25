package com.xiangyao.train.interceptor

import com.xiangyao.train.listenner.ProgressListener
import com.xiangyao.train.utils.ProgressResponseBody
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by xiangyao on 2017/10/14.
 */
class ProgressDownloadInterceptor(private val mProgressListener: ProgressListener?) : Interceptor {


    /**
     *
     * currentThread not UI Thread
     *
     * */

    override fun intercept(chain: Interceptor.Chain): Response {

        val mResponse: Response? = chain?.proceed(chain?.request())

        return mResponse?.newBuilder()?.body(mResponse.body?.let { mProgressListener?.let { it1 -> ProgressResponseBody(it, it1) } })?.build()!!

    }
}