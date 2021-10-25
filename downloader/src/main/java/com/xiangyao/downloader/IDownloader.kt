package com.xiangyao.downloader

import com.xiangyao.downloader.module.IDownloadFile
import com.xiangyao.downloader.other.DownloadOptions

class IDownloader : IDownloadService {

    override fun _init(downloadOptions: DownloadOptions) {
    }


    override fun _download(iDownloadFile: IDownloadFile) {

    }

    public fun init(downloadOptions: DownloadOptions) {
        _init(downloadOptions)
    }

    fun downLoad(name:String="",tagetPath:String=""){}

}