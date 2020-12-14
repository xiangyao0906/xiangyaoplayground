
package com.xiangyao.train.utils

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream

object AssetsUtil {
    /**
     * 获取assets目录下的图片
     * @param context 上下文
     * @param fileName  文件名
     * @return  Bitmap图片
     */
    fun getImageFromAssetsFile(context: Context, fileName: String): Bitmap? {
        var bitmap: Bitmap? = null
        val assetManager: AssetManager = context.assets
        try {
            val inputStream: InputStream = assetManager.open(fileName)
            bitmap = BitmapFactory.decodeStream(inputStream)
            inputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return bitmap
    }

    /**
     * 获取assets目录下的单个文件
     * 这种方式只能用于webview加载
     * 读取文件夹，直接取路径是不行的
     * @param context 上下文
     * @param fileName  文件夹名
     * @return File
     */
    fun getFileFromAssetsFile(context: Context?, fileName: String): File {
        val path = "file:///android_asset/$fileName"
        return File(path)
    }


    fun getAssetsCacheFile(context: Context, fileName: String): String {
        val cacheFile = File(context.cacheDir, fileName)
        try {
            val inputStream: InputStream = context.assets.open(fileName)
            try {
                val outputStream = FileOutputStream(cacheFile)
                try {
                    val buf = ByteArray(1024)
                    var len: Int
                    while (inputStream.read(buf).also { len = it } > 0) {
                        outputStream.run { write(buf, 0, len) }
                    }
                } finally {
                    outputStream.close()
                }
            } finally {
                inputStream.close()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return cacheFile.absolutePath
    }

    /**
     * 获取assets目录下所有文件
     * @param context  上下文
     * @param path  文件地址
     * @return files[] 文件列表
     */
    fun getFilesFromAssets(context: Context, path: String): Array<String>? {
        val assetManager: AssetManager = context.assets
        var files: Array<String>? = null
        try {
            files = assetManager.list(path)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return files
    }

    /**
     * 将assets下的文件放到sd指定目录下
     * @param context     上下文
     * @param assetsPath  assets下的路径
     */
    fun putAssetsToSDCard(context: Context, assetsPath: String) {
        putAssetsToSDCard(context, assetsPath, context.getExternalFilesDir(null)?.absolutePath?:"")
    }

    /**
     * 将assets下的文件放到sd指定目录下
     * @param context      上下文
     * @param assetsPath   assets下的路径
     * @param sdCardPath   sd卡的路径
     */
    fun putAssetsToSDCard(context: Context, assetsPath: String, sdCardPath: String) {
        var originalSDCardPath = sdCardPath
        val assetManager: AssetManager = context.assets
        try {
            val files: Array<String> = assetManager.list(assetsPath)?: arrayOf()
            if (files.isEmpty()) {
                // 说明assetsPath为空,或者assetsPath是一个文件
                val inputStream: InputStream = assetManager.open(assetsPath)
                val mByte = ByteArray(1024)
                var bt = 0
                val file = File(originalSDCardPath + File.separator
                        .toString() + assetsPath.substring(assetsPath.lastIndexOf('/')))
                if (!file.exists()) {
                    // 创建文件
                    file.createNewFile()
                } else {
                    //已经存在直接退出
                    return
                }

                // 写入流
                val fos = FileOutputStream(file)
                // assets为文件,从文件中读取流
                while (inputStream.read(mByte).also { bt = it } != -1) {
                    // 写入流到文件中
                    fos.write(mByte, 0, bt)
                }

                // 刷新缓冲区
                fos.flush()
                // 关闭读取流
                inputStream.close()
                // 关闭写入流
                fos.close()
            } else {
                // 当mString长度大于0,说明其为文件夹
                originalSDCardPath = originalSDCardPath + File.separator.toString() + assetsPath
                val file = File(originalSDCardPath)
                if (!file.exists()) {
                    // 在sd下创建目录
                    file.mkdirs()
                }

                // 进行递归
                for (stringFile in files) {
                    putAssetsToSDCard(context, assetsPath + File.separator
                            .toString() + stringFile, originalSDCardPath)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}