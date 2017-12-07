package com.xiangyao.train.bean

/**
 * Created by xiangyao on 2017/11/30.
 */

class Fuli {


    var isError: Boolean = false
    var results: List<Results>? = null

    class Results {

        var _id: String? = null
        var createdAt: String? = null
        var desc: String? = null
        var publishedAt: String? = null
        var source: String? = null
        var type: String? = null
        var url: String? = null
        var isUsed: Boolean = false
        var who: String? = null
    }
}
