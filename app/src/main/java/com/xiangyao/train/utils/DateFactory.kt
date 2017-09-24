package com.xiangyao.train.utils

import com.xiangyao.train.ui.Student

import java.util.ArrayList

/**
 * Created by xiangyao on 2017/9/23.
 */

object DateFactory {
    internal var stringList: ArrayList<String>? = null
    internal lateinit var students: ArrayList<Student>

    fun getIndexString(index: Int): List<String> {

        for (x in 0..index - 1) {
            stringList!!.add(x.toString())
        }

        return stringList!!
    }

    fun getInputObject(intdex: Int): ArrayList<Student> {
        students = ArrayList<Student>()
        for (x in 0..intdex - 1) {
            val student = Student()
            student.age = x
            if (x % 2 == 0) {
                student.name = "弗拉基米尔"
            } else {
                student.name = "凯撒"
            }
            students.add(student)

        }

        return students
    }

}
