package com.xiangyao.train.ui

import android.app.Activity
import android.os.Bundle
import com.orhanobut.logger.Logger
import com.xiangyao.train.utils.DateFactory
import com.xiangyao.train.utils.ILog
import rx.Observable
import rx.functions.Action1
import xiangyao.yizhilu.com.studyjourny.R

class RxJavaTestActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_java_test)

        kottlinfor()

        rxfilter()

        rxmap()

        ListTest()
    }


    /**
     * kotlin for循环
     * */
    private fun kottlinfor() {

        var abc: ArrayList<Student> = DateFactory.getInputObject(10)
        for (student: Student in abc) {
            ILog.i(student.name!!)
        }
    }

    /**
     * kotlin  rx 操作符之filter
     *
     * filter{T->boolean}
     *
     * T 返回值   boolean表达式
     * */
    private fun rxfilter() {
        var abc: ArrayList<Student> = DateFactory.getInputObject(10)

        Observable.from(abc).filter { t: Student? -> t?.age == 8 }.subscribe({ t: Student ->
            ILog.i(t.name!!)
        })


    }

    private fun rxmap() {
        /**
         * kotlin 转换流
         * map({in->out})
         *
         * in 需要转换的值的类型
         *
         * out 需要转成的类型
         *
         * */
        Observable.just(1, 2, 3, 4, 5)
                .map({ t: Int? -> t.toString() + "转换流" }).subscribe({ t: String -> Logger.i(t) })
    }

    private fun rxflatMap() {

        /**
         *
         * 输出 某市的某个学校的每个学生的名字
         *
         *
         * */

        var abc: ArrayList<ArrayList<Student>> = ArrayList()
        abc.add(DateFactory.getInputObject(10))

        Observable.from(abc)
                .flatMap({ a: ArrayList<Student> -> Observable.from(a) }).subscribe({ t: Student -> ILog.i(t.name!!) })
    }
    private fun ListTest(){
        /**
         * kotlin 自带过滤
         *
         * */
        val arrayListOf = arrayListOf(1, 2,3,4,5,6,7,8,9)
        val filter = arrayListOf.filter { a: Int -> a > 5 }
        Observable.from(filter)
                .subscribe({ t -> ILog.i("哈哈哈"+t) })
    }
}
