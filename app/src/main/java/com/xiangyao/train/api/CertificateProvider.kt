package com.xiangyao.train.api

import com.xiangyao.train.base.DemoApplication
import java.io.InputStream

/**
 * 根据URL的地址来判断证书的加载
 * <p>
 * Created by zm on 2019-06-27.
 */
object CertificateProvider {

    fun getCertificateStreams(baseUrl: String): Array<InputStream>? {
        val cerName: String = if (baseUrl.startsWith("")) "" else ""
        return if (cerName.isNotEmpty()) arrayOf(DemoApplication.appContext.assets.open(cerName)) else null
    }

}