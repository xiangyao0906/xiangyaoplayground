package com.xiangyao.downloader

import com.xiangyao.downloader.module.IDownloadFile
import com.xiangyao.downloader.other.DownloadOptions

/**
 * 下载器提供的服务
 * */
interface IDownloadService {

    fun _init(downloadOptions: DownloadOptions)

    fun _download(iDownloadFile: IDownloadFile)

}