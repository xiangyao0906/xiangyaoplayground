package com.xiangyao.train.utils

import android.net.Uri

import com.xiangyao.train.base.DemoApplication

/**
 * Created by xiangyao on 2017/9/24.
 */

object UriUtils {
    private var uri: Uri? = null
    private var path = Constant.STRINGDEFAULT
    private var resId = Constant.INTDEFAULT

    fun getUri(mode: Int, url: String): Uri? {
        path = url
        return UriTool(mode)
    }

    fun getUri(mode: Int, localResource: Int): Uri? {
        resId = localResource
        return UriTool(mode)
    }

    fun UriTool(mode: Int): Uri? {
        if (mode == Constant.ONLINEPIC && path !== Constant.STRINGDEFAULT) {
            uri = Uri.parse(path)
        } else if (mode == Constant.LOCALRESOURCE && resId != Constant.INTDEFAULT) {
            uri = Uri.parse("res://" + DemoApplication.appContext!!.packageName + "/" + resId)
        }

        return uri
    }


}
