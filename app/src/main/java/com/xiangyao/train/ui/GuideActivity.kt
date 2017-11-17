package com.xiangyao.train.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.pawegio.kandroid.toast
import com.xiangyao.train.adapter.GuideAdapter
import com.xiangyao.train.utils.ClassUtils
import com.xiangyao.train.view.RecycleViewDivider
import kotlinx.android.synthetic.main.activity_guide.*
import xiangyao.yizhilu.com.studyjourny.R

/**
 * @author xiangyao
 */
@Route(path = "/ui/GuideActivity")
class GuideActivity : AppCompatActivity(), BaseQuickAdapter.OnItemClickListener {
    @Autowired(name = "title")
    lateinit var title: String
    private var activitiesClass: List<Class<*>>? = null

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {

        var target = "/ui/".plus(activitiesClass?.get(position)?.simpleName)


        /**
         * 路由跳转回调
         * */
        ARouter.getInstance().build(target).navigation(this, object : NavigationCallback {
            /**
             * Callback on interrupt.
             *
             * @param postcard meta
             */
            override fun onInterrupt(postcard: Postcard?) {
            }

            /**
             * Callback after navigation.
             *
             * @param postcard meta
             */
            override fun onArrival(postcard: Postcard?) {
            }

            /**
             * Callback after lose your way.
             *
             * @param postcard meta
             */
            override fun onLost(postcard: Postcard?) {

                toast("此页面不支持展示")
            }

            /**
             * Callback when find the destination.
             *
             * @param postcard meta
             */
            override fun onFound(postcard: Postcard?) {
            }

        })

    }


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)
        ARouter.getInstance().inject(this)

        initData()

        preview()

    }

    /**
     * 初始化数据
     * */
    private fun initData() {
        guide_title.title = title
        val excludeList = ArrayList<Class<*>>()
        excludeList.add(this.javaClass)
        activitiesClass = ClassUtils.getActivitiesClass(this, packageName, excludeList)
    }

    /**
     * 展示
     * */
    private fun preview() {
        guide_listview.layoutManager = LinearLayoutManager(this)
        guide_listview.addItemDecoration(RecycleViewDivider(this, LinearLayoutManager.VERTICAL))
        guide_listview.adapter = GuideAdapter(R.layout.guide_item_view, activitiesClass)
        (guide_listview.adapter as GuideAdapter).onItemClickListener = this

    }

}
