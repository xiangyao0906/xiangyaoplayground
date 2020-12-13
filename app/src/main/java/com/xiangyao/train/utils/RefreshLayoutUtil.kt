package com.xiangyao.train.utils

import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.constant.RefreshState

/**
 * Created by zm on 2019-07-05.
 */
object RefreshLayoutUtil {

    /**
     * 关闭刷新或加载状态
     * @param refreshLayout
     */
    fun finishRefreshLayout(refreshLayout: RefreshLayout?) {
        if (refreshLayout == null) return
        if (refreshLayout.state == RefreshState.Refreshing) {
            refreshLayout.finishRefresh()
        } else if (refreshLayout.state == RefreshState.Loading) {
            refreshLayout.finishLoadMore()
        }
    }
}