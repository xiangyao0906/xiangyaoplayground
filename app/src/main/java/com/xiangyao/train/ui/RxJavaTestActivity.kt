package com.xiangyao.train.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.database.Cursor
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import com.alibaba.android.arouter.facade.annotation.Route
import com.xiangyao.train.utils.*
import rx.Observable
import rx.functions.Action1
import rx.functions.Func2
import xiangyao.yizhilu.com.studyjourny.R
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import rx.Observable.from as observableFrom


@Route(path = RouteConstant.RXJAVAACTIVITY)
class RxJavaTestActivity : Activity() {

    val threadLocaleList = ThreadLocal<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_java_test)

        findViewById<Button>(R.id.actionButton).setOnClickListener {

//            zipTest()

//            limitTipsTest()

            loadalblum()
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


//        ListTest()
//
//        testMap()
//
//        forQueenDemo()


//        limitTipsTest()





    }

    @SuppressLint("Recycle")
    private fun loadalblum() {

        val array = arrayOf(
                MediaStore.Images.Media._ID,
                MediaStore.Images.Media.DATA,
                MediaStore.Images.Media.ORIENTATION,
                MediaStore.Images.Media.DATE_ADDED,
                MediaStore.Images.Media.MIME_TYPE)
        val sortOrder = MediaStore.Images.Media.DATE_ADDED + " desc"
        val cursor: Cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, array, null, null, sortOrder)!!
        if (cursor.moveToFirst()) {
            do {
                Log.i("xiangyao", "${cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA))}")
            } while (cursor.moveToNext())
            cursor.close()
        }


    }

    private fun limitTipsTest() {

        val entime = "2021-5-3"


        val curDateStr = DateUtil.getTimeStamp()


        val endTimeStamp = DateUtil.str2Date(entime, DateUtil.FORMAT_YMD)?.time ?: curDateStr

        val duration = endTimeStamp - curDateStr


    }

    private fun forQueenDemo() {


    }

    fun haha(char: Char): Boolean {

        Log.i("xiangyao", "$char")
        return true
    }

    private fun testMap() {
        val hashMap = HashMap<Int, String>()

        for (i in 0..20) {
            hashMap[20 - i] = "$i"
        }


        val entries = hashMap.entries

        entries.iterator().forEach {

            Log.i("xiangyao", "key--${it.key}.....Value---${it.value}")
        }
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

        observableFrom(abc).filter { t: Student? -> t?.age == 8 }.subscribe { t: Student ->
            ILog.i(t.name!!)
        }


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
                .map { t: Int? -> t.toString() + "转换流" }.subscribe { t: String -> ILog.i(t) }
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
