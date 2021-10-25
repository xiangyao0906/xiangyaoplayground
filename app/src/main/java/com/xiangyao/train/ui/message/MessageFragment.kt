package com.xiangyao.train.ui.message

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.alibaba.android.arouter.launcher.ARouter
import com.xiangyao.train.ui.RxJavaTestActivity
import com.xiangyao.train.utils.RouteConstant
import xiangyao.yizhilu.com.studyjourny.R

class MessageFragment : Fragment() {

    var mRootView:View?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        mRootView =inflater.inflate(R.layout.fragment_message, container, false)
        initView()
        return  mRootView



    }

    private fun initView() {

       val mButton= mRootView?.findViewById<Button>(R.id.testButtom)

        mButton?.setOnClickListener {

            ARouter.getInstance()?.build(RouteConstant.CUSTOM_ALBUM)?.navigation()


        }


    }

}