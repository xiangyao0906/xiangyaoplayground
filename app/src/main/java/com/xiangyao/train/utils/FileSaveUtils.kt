package com.xiangyao.train.utils

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by xiangyao on 2019-09-03.
 */
object FileSaveUtils {

    /**
     * 保存图片到指定路径
     *
     * @param context
     * @param bitmap   要保存的图片
     * @param fileName 自定义图片名称
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    fun saveImageToGallery(context: Context, bitmap: Bitmap, fileName: String): Boolean {
        val saveFileName = fileName + "_" + SimpleDateFormat("yyyyMMddHHmmss").format(Date()) + ".png"
        // 保存图片至指定路径
        val storePath = Environment.getExternalStorageDirectory().absolutePath + File.separator + "youchat"
        val appDir = File(storePath)
        if (!appDir.exists()) {
            appDir.mkdir()
        }
        val file = File(appDir, saveFileName)
        try {
            val fos = FileOutputStream(file)
            //通过io流的方式来压缩保存图片(80代表压缩20%)
            val isSuccess = bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fos)
            fos.flush()
            fos.close()
            //MediaStore.Images.Media.insertImage 方法会生成一张以当前时间命名的缩略图 会造成保存两张图片的bug
            val values = ContentValues()
            values.put(MediaStore.Images.Media.DATA, file.absolutePath)
            values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
            context.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)

            // 通知图库更新
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                MediaScannerConnection.scanFile(context, arrayOf(file.absolutePath), null
                ) { path, uri ->
                    val mediaScanIntent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
                    mediaScanIntent.data = uri
                    context.sendBroadcast(mediaScanIntent)
                }
            } else {
                val relationDir = file.parent
                val file1 = File(relationDir)
                context.sendBroadcast(Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.fromFile(file1.absoluteFile)))
            }
            return isSuccess
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return false
    }
}