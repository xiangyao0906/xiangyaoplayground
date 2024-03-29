package com.xiangyao.train.interceptor

import com.xiangyao.train.utils.HttpConfig
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by xiangyao on 2017/11/06.
 */
class DupliBaseUrlInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response: Response
        //获取request
        val request = chain.request()
        //获取request的创建者builder
        val builder = request.newBuilder()
        //从request中获取headers，通过给定的键url_name
        val headerValues = request.headers(HttpConfig.HEADER_KEY)
        if (headerValues.isNotEmpty()) {
            //如果有这个header，先将配置的header删除，因此header仅用作app和okhttp之间使用
            builder.removeHeader(HttpConfig.HEADER_KEY)

            //匹配获得新的BaseUrl
            val headerValue = headerValues[0]
            /**
             * 这里拦截到对应的header
             * 重新设置新的域名
             */
            val newBaseUrl: HttpUrl? = when {
                HttpConfig.DOUBAN == headerValue ->HttpConfig.BASEURL.toHttpUrlOrNull()
                HttpConfig.CIBA == headerValue -> HttpConfig.CIBABASEURL.toHttpUrlOrNull()
                HttpConfig.GANKIO == (headerValue) -> HttpConfig.GANKIOBASEURL.toHttpUrlOrNull()
                HttpConfig.MAOMOVIE == (headerValue) -> HttpConfig.MAOMOVIEBASEURL.toHttpUrlOrNull()
                else -> //默认主域名
                    HttpConfig.BASEURL.toHttpUrlOrNull()
            }
            //从request中获取原有的HttpUrl实例oldHttpUrl
            val oldHttpUrl = request.url
            //重建新的HttpUrl，修改需要修改的url部分
            val newFullUrl = oldHttpUrl
                    .newBuilder()
                    .scheme(newBaseUrl!!.scheme)
                    .host(newBaseUrl.host)
                    .port(newBaseUrl.port)
                    .build()

            //重建这个request，通过builder.url(newFullUrl).build()；
            //然后返回一个response至此结束修改
            response = chain.proceed(builder.url(newFullUrl).build())
        } else {
            response = chain.proceed(request)
        }
        return response
    }
}