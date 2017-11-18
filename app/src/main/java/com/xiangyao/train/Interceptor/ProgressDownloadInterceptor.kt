package com.xiangyao.train.Interceptor

import com.xiangyao.train.listenner.ProgressListener
import com.xiangyao.train.utils.ProgressResposeBody
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by xiangyao on 2017/10/14.
 */
class ProgressDownloadInterceptor(private val mProgressLinstener: ProgressListener?) : Interceptor {


    /**
     *
     * currentThread not UI Thread
     *
     * */

    override fun intercept(chain: Interceptor.Chain?): Response {

        var mResponse: Response? = chain?.proceed(chain?.request())

        return mResponse?.newBuilder()?.body(mResponse?.body()?.let { mProgressLinstener?.let { it1 -> ProgressResposeBody(it, it1) } })?.build()!!

    }
}