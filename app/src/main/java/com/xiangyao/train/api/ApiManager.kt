package com.xiangyao.train.api

import com.xiangyao.train.Interceptor.DupliBaseUrlInterceptor
import com.xiangyao.train.utils.HttpConfig
import com.xiangyao.train.utils.HttpLog
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Administrator on 2017/09/22.
 */

object ApiManager {
    private var apistore: ApiStore? = null
    private val TIME_OUT: Long = 5000

    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    fun getApistore(): ApiStore? {
        synchronized(ApiManager::class.java) {
            if (apistore == null) {
                val logging = HttpLoggingInterceptor(HttpLog())
                logging.level = HttpLoggingInterceptor.Level.BODY
                val sslParams = SSL.getSslSocketFactory(CertificateProvider.getCertificateStreams(HttpConfig.BASEURL), null, null)
                val okHttpClient = OkHttpClient.Builder()
                        .connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                        .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                        .hostnameVerifier { _, _ -> true }
                        //添加应用拦截器
                        .addInterceptor(DupliBaseUrlInterceptor())

                        //添加拦截器到OkHttp
                        .addInterceptor(logging)
                        .build()
                //创建retrofit实例对象
                val retrofit = Retrofit.Builder()
                        .baseUrl(HttpConfig.BASEURL)      //设置服务器主机,以"/"结尾
                        .addConverterFactory(GsonConverterFactory.create())     //配置gson解析器
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .client(okHttpClient)
                        .build()
                apistore = retrofit.create(ApiStore::class.java)
            }
        }
        return apistore
    }
}
