package com.xiangyao.train.rollback

import com.xiangyao.train.api.Apistore
import com.xiangyao.train.utils.HttpConfig
import com.xiangyao.train.utils.HttpLog
import okhttp3.HttpUrl
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
    private var apistore: Apistore? = null
    private val TIME_OUT: Long = 5000


    fun getApistore(): Apistore? {
        synchronized(ApiManager::class.java) {
            if (apistore == null) {
                val logging = HttpLoggingInterceptor(HttpLog())
                logging.level = HttpLoggingInterceptor.Level.BODY
                val okHttpClient = OkHttpClient.Builder()
                        .connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                        //添加应用拦截器
                        .addInterceptor { chain ->
                            //获取request
                            val request = chain.request()
                            //获取request的创建者builder
                            val builder = request.newBuilder()
                            //从request中获取headers，通过给定的键url_name
                            val headerValues = request.headers(HttpConfig.HEADER_KEY)
                            if (headerValues != null && headerValues.size > 0) {
                                //如果有这个header，先将配置的header删除，因此header仅用作app和okhttp之间使用
                                builder.removeHeader(HttpConfig.HEADER_KEY)

                                //匹配获得新的BaseUrl
                                val headerValue = headerValues[0]
                                val newBaseUrl: HttpUrl?

                                /**
                                 *
                                 * 这里拦截到对应的header
                                 * 重新设置新的域名
                                 */

                                /**
                                 *
                                 * 这里拦截到对应的header
                                 * 重新设置新的域名
                                 */

                                newBaseUrl = if (HttpConfig.DOUBAN == headerValue) {
                                    HttpUrl.parse(HttpConfig.BASEURL)
                                } else {
                                    //默认主域名
                                    HttpUrl.parse(HttpConfig.BASEURL)
                                }

                                //从request中获取原有的HttpUrl实例oldHttpUrl


                                val oldHttpUrl = request.url()
                                //重建新的HttpUrl，修改需要修改的url部分
                                val newFullUrl = oldHttpUrl
                                        .newBuilder()
                                        .scheme(newBaseUrl!!.scheme())
                                        .host(newBaseUrl.host())
                                        .port(newBaseUrl.port())
                                        .build()

                                //重建这个request，通过builder.url(newFullUrl).build()；
                                //然后返回一个response至此结束修改
                                chain.proceed(builder.url(newFullUrl).build())
                            } else {
                                chain.proceed(request)
                            }
                        }
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
                apistore = retrofit.create(Apistore::class.java)
            }
        }
        return apistore
    }
}
