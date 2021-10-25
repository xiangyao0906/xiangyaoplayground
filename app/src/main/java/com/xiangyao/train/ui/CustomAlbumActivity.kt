package com.xiangyao.train.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.database.Cursor
import android.hardware.biometrics.BiometricPrompt
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.gyf.immersionbar.ImmersionBar
import com.matisse.Matisse
import com.matisse.MimeTypeManager
import com.matisse.PrewType
import com.matisse.entity.CaptureStrategy
import com.matisse.entity.ConstValue
import com.tbruyelle.rxpermissions2.RxPermissions
import com.xiangyao.train.bean.AlbumPhoto
import com.xiangyao.train.utils.Glide4Engine
import com.xiangyao.train.utils.RouteConstant
import com.xiangyao.train.utils.show
import kotlinx.android.synthetic.main.activity_custom_alblem.*
import xiangyao.yizhilu.com.studyjourny.R


@Route(path = RouteConstant.CUSTOM_ALBUM)
class CustomAlbumActivity : AppCompatActivity() {
    val photoAlbums = ArrayList<AlbumPhoto>()
    lateinit var albumAdapter: AlbumAdapter


    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_alblem)
        albumRv.layoutManager = GridLayoutManager(this, 4)
        albumAdapter = AlbumAdapter(photoAlbums)
        albumAdapter.setOnItemClickListener { _, _, position ->

            photoAlbums[position].isSelected = !photoAlbums[position].isSelected
            albumAdapter.notifyItemChanged(position)
        }
        albumRv.adapter = albumAdapter
//        loadAlbum()

        val rxPermissions = RxPermissions(this)
        rxPermissions.request(Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe { aBoolean ->
                    if (aBoolean)  {
                        loadAlbum()
                    }
                }
        sendTv.setOnClickListener {


            "sdasds".show()
        }

    }


    fun biometricPrompt(){
      val mainEx=  ContextCompat.getMainExecutor(this)

    }

    private fun selectPhotoByMatisse() {
        Matisse.from(this)
                .choose(MimeTypeManager.ofMotionlessImage(), true) //选择图片类型
                .theme(R.style.Matisse_Def)
                .countable(true) // 设置选中计数方式
                .isCrop(true) // 设置开启裁剪
                .prewType(PrewType.PRETYPE_TWO)
                .isCircleCrop(true)  // 裁剪类型，圆形/方形
                .maxSelectable(3)
                .originalEnable(false)
                .capture(false) //可拍照
                .captureStrategy(
                        CaptureStrategy(
                                true,
                                "com.xiangyao.train.ui.fileprovider"
                        )
                )
                .thumbnailScale(0.6f) // 图片显示压缩比
                .spanCount(3)// 资源显示列数
                .gridExpectedSize(0)
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                .imageEngine(Glide4Engine()) // 加载库
                .setStatusBarFuture { params, view ->
                    ImmersionBar.with(params)?.run {
                        statusBarDarkFont(false)
                        view?.apply { titleBar(this) }
                        init()
                    }
                }
                .forResult(ConstValue.REQUEST_CODE_CHOOSE)
    }

    private fun loadAlbum() {
        val array = arrayOf(
                MediaStore.Images.Media.DISPLAY_NAME,
                MediaStore.Images.Media.DATA,
                MediaStore.Images.Media.DATE_ADDED,
                MediaStore.Images.Media.MIME_TYPE)
        val sortOrder = MediaStore.Images.Media.DATE_ADDED + " desc"
        val cursor: Cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, array, null, null, sortOrder)!!
        if (cursor.moveToFirst()) {
            do {
                val photoPath = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
//                if (photoPath.startsWith("/storage/emulated/0/Download") || photoPath.startsWith("/storage/emulated/0/DCIM")) {
                val photoName = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME))
                val photoTime = cursor.getLong(cursor.getColumnIndex(MediaStore.Images.Media.DATE_ADDED))
                photoAlbums.add(AlbumPhoto(photoTime, photoName, photoPath))
//                }
            } while (cursor.moveToNext())
            cursor.close()
        }

        albumAdapter.data = photoAlbums
        albumAdapter.notifyDataSetChanged()
    }

}