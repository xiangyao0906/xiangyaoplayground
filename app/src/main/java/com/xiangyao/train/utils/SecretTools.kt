package com.xiangyao.train.utils

import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by xiangyao on 2017/12/07.
 */
object SecretTools {

    fun toMD5(string: String): String {
        val alga: MessageDigest
        try {
            alga = MessageDigest.getInstance("MD5")
            alga.update(string.toByteArray())
            var digesta = alga.digest()
            var str = byte2Hex(digesta)
            return str
        } catch (e: Exception) {
        }
        return ""
    }


    fun byte2Hex(bts: ByteArray): String {

        val des = ""
        var tem: String
        for (i in bts) {
            tem = Integer.toHexString(i.toInt())
            if (tem.length == 1) {
                des.plus("0")
            }
            des.plus(tem)
        }
        return des.toUpperCase()
    }

    /**
     * SHA1加密
     * */

    fun getSHA1(token: String, pName: String): ArrayList<String> {

        var timetemp = getNewDate()

        var stringBufer = StringBuffer()
        var packageName = toMD5(pName)
        stringBufer.append(packageName)
        stringBufer.append(token)
        stringBufer.append(timetemp)

        val _val = stringBufer.toString()
        var digesta: ByteArray? = null
        try {
            var alga = MessageDigest.getInstance("SHA-1")
            alga.update(_val.toByteArray())
            digesta = alga.digest()
        } catch (e: Exception) {
        }
        var res = arrayListOf<String>()
        res[0] = byte2Hex(digesta!!)
        res[1] = timetemp
        return res


    }

    /**
     * 获取当前的日期
     * */
    fun getNewDate(): String {
        var sDateFormat = SimpleDateFormat("yyyy-MM-dd")
        var date = sDateFormat.format(Date())
        return date
    }


}