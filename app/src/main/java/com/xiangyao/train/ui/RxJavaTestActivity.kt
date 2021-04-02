package com.xiangyao.train.ui

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.annotation.RequiresApi
import com.alibaba.android.arouter.facade.annotation.Route
import com.xiangyao.train.utils.DateFactory
import com.xiangyao.train.utils.ILog
import com.xiangyao.train.utils.RouteConstant
import rx.Observable
import rx.functions.Action1
import rx.functions.Func1
import rx.functions.Func2
import xiangyao.yizhilu.com.studyjourny.R
import java.util.function.BiFunction
import rx.Observable.from as observableFrom


@Route(path = RouteConstant.RXJAVAACTIVITY)
class RxJavaTestActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_java_test)

        findViewById<Button>(R.id.actionButton).setOnClickListener {


            zipTest()
        }


//        kottlinfor()
//
//        rxfilter()
//
//        rxmap()
//
//        ListTest()

    }

    /**
     * zip 执行次数取决于数据源中最少的数据源个数
     * */
    private fun zipTest() {
        var data1 = arrayListOf<Int>(1, 2, 3, 4, 5, 6, 7)
        var data2 = arrayListOf<String>("Hello", "World", "Kotlin", "Android", "Java", "Moon")


        val flowOne = Observable.from(data1)
        val flowTwo = Observable.from(data2)

        Observable.zip(flowOne, flowTwo,
                (Func2<Int, String, String> { t1, t2 -> "${t1}---${t2}" }))
                .subscribe(Action1 {

                    Log.i("xiangyao", "$it")
                })


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

        observableFrom(abc).filter { t: Student? -> t?.age == 8 }.subscribe({ t: Student ->
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
                .map { t: Int? -> t.toString() + "转换流" }.subscribe({ t: String -> ILog.i(t) })
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

        observableFrom(abc)
                .flatMap { a: ArrayList<Student> -> observableFrom(a) }.subscribe { t: Student -> ILog.i(t.name!!) }
    }

    private fun ListTest() {
        /**
         * kotlin 自带过滤
         *
         * */
        val arrayListOf = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        val filter = arrayListOf.filter { a: Int -> a > 5 }
        observableFrom(filter)
                .subscribe { t -> ILog.i("哈哈哈$t") }
    }
}
