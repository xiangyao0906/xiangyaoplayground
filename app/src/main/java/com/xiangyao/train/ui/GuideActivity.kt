package com.xiangyao.train.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.xiangyao.train.adapter.GuideAdapter
import com.xiangyao.train.utils.ClassUtils
import com.xiangyao.train.utils.RouteConstant
import com.xiangyao.train.view.RecycleViewDivider
import kotlinx.android.synthetic.main.activity_guide.*
import xiangyao.yizhilu.com.studyjourny.R

/**
 * @author xiangyao
 */

@Route(path = RouteConstant.GUIDEACTIVITY)
class GuideActivity : AppCompatActivity(), BaseQuickAdapter.OnItemClickListener {

    @Autowired
    @JvmField var  title=""
    private var activitiesClass: List<Class<*>>? = null

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {

        var target = RouteConstant.ROUTEGROUP.plus(activitiesClass?.get(position)?.simpleName)
        ARouter.getInstance()
                .build(target)
                .navigation()


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
