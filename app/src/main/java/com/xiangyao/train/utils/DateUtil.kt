package com.xiangyao.train.utils

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by zm on 2019-07-05.
 */
object DateUtil {

    /**
     * 英文简写如：2017
     */
    const val FORMAT_Y = "yyyy"

    /**
     * 英文简写如：12:01
     */
    const val FORMAT_HM = "HH:mm"

    /**
     * 英文简写如：1-8 12:01
     */
    const val FORMAT_MDHM = "MM-dd HH:mm"

    /**
     * 英文简写（默认）如：2017/8/01
     */
    const val FORMAT_YMD_ = "yyyy/MM/dd"

    /**
     * 英文简写（默认）如：2017/8/01
     */
    const val FORMAT_YMD_HH_MM_ = "yyyy/MM/dd HH:mm"

    /**
     * 英文简写（默认）如：2017-8-01
     */
    const val FORMAT_YMD = "yyyy-MM-dd"

    /**
     * 英文简写（默认）如：2017-8-01
     */
    const val FORMAT_YMD_MATH = "yyyyMMdd"

    /**
     * 英文简写（默认）如：2017-8-01
     */
    const val FORMAT_YM = "yyyy-MM"

    /**
     * 英文全称  如：2017-8-01 23:15
     */
    const val FORMAT_YMDHM = "yyyy-MM-dd HH:mm"

    /**
     * 英文全称  如：2017-8-01 23:15:06
     */
    const val FORMAT_YMDHMS = "yyyy-MM-dd HH:mm:ss"

    /**
     * 精确到毫秒的完整时间    如：yyyy-MM-dd HH:mm:ss.S
     */
    const val FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S"

    /**
     * 精确到毫秒的完整时间    如：yyyy-MM-dd HH:mm:ss.S
     */
    const val FORMAT_FULL_SN = "yyyyMMddHHmmssS"

    /**
     * 中文简写  如：2017年8月01日
     */
    const val FORMAT_YMD_CN = "yyyy年MM月dd日"

    /**
     * 中文简写  如：2017年8月
     */
    const val FORMAT_YM_CN = "yyyy年MM月"

    /**
     * 中文简写  如：2017年8月01日  12时
     */
    const val FORMAT_YMDH_CN = "yyyy年MM月dd日 HH时"

    /**
     * 中文简写  如：2017年8月01日  12时12分
     */
    const val FORMAT_YMDHM_CN = "yyyy年MM月dd日 HH时mm分"

    /**
     * 中文全称  如：2017年8月01日  23时15分06秒
     */
    const val FORMAT_YMDHMS_CN = "yyyy年MM月dd日  HH时mm分ss秒"

    /**
     * 精确到毫秒的完整中文时间
     */
    const val FORMAT_FULL_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒"

    var calendar: Calendar? = null
    private val FORMAT = "yyyy-MM-dd HH:mm:ss"


    fun str2Date(str: String): Date? {
        return str2Date(str, null)
    }


    @SuppressLint("SimpleDateFormat")
    fun str2Date(str: String?, format: String?): Date? {
        var format = format
        if (str == null || str.length == 0) {
            return null
        }
        if (format == null || format.length == 0) {
            format = FORMAT
        }
        var date: Date? = null
        try {
            val sdf = SimpleDateFormat(format)
            date = sdf.parse(str)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return date
    }

    fun str2Calendar(str: String): Calendar? {
        return str2Calendar(str, null)
    }


    fun str2Calendar(str: String, format: String?): Calendar? {

        val date = str2Date(str, format) ?: return null
        val c = Calendar.getInstance()
        c.time = date

        return c
    }


    fun date2Str(c: Calendar): String? {// yyyy-MM-dd HH:mm:ss
        return date2Str(c, null)
    }


    fun date2Str(c: Calendar?, format: String?): String? {
        return if (c == null) {
            null
        } else date2Str(c.time, format)
    }

    fun date2Str(l: Long, format: String): String? {
        if (l == 0L) {
            return null
        }
        val c = Calendar.getInstance()
        c.timeInMillis = l
        return date2Str(c.time, format)
    }

    fun date2Str(d: Date): String? {// yyyy-MM-dd HH:mm:ss
        return date2Str(d, null)
    }


    @SuppressLint("SimpleDateFormat")
    fun date2Str(d: Date?, format: String?): String? {// yyyy-MM-dd HH:mm:ss
        var format = format
        if (d == null) {
            return null
        }
        if (format == null || format.isEmpty()) {
            format = FORMAT
        }
        val sdf = SimpleDateFormat(format)
        return sdf.format(d)
    }


    fun getCurDateStr(): String {
        val c = Calendar.getInstance()
        c.time = Date()
        return c.get(Calendar.YEAR).toString() + "-" + (c.get(Calendar.MONTH) + 1) + "-" +
                c.get(Calendar.DAY_OF_MONTH) + "-" +
                c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) +
                ":" + c.get(Calendar.SECOND)
    }


    /**
     * 获得当前日期的字符串格式
     *
     * @param format 格式化的类型
     * @return 返回格式化之后的事件
     */
    fun getCurDateStr(format: String): String? {
        val c = Calendar.getInstance()
        return date2Str(c, format)

    }


    /**
     * @param time 当前的时间
     * @return 格式到秒
     */

    @SuppressLint("SimpleDateFormat")
    fun getMillon(time: Long): String {

        return SimpleDateFormat(getDatePattern()).format(time)

    }


    /**
     * @param time 当前的时间
     * @return 当前的天
     */
    @SuppressLint("SimpleDateFormat")
    fun getDay(time: Long): String {

        return SimpleDateFormat("yyyy-MM-dd").format(time)

    }

    /**
     * @param time 特定格式时间返回
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    fun getTime(time: Long, format: String): String {

        return SimpleDateFormat(format).format(time)

    }

    /**
     * @param time 时间
     * @return 返回一个毫秒
     */
    // 格式到毫秒
    @SuppressLint("SimpleDateFormat")
    fun getSMillon(time: Long): String {

        return SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS").format(time)

    }


    /**
     * 在日期上增加数个整月
     *
     * @param date 日期
     * @param n    要增加的月数
     * @return 增加数个整月
     */
    fun addMonth(date: Date, n: Int): Date {
        val cal = Calendar.getInstance()
        cal.time = date
        cal.add(Calendar.MONTH, n)
        return cal.time

    }


    /**
     * 在日期上增加天数
     *
     * @param date 日期
     * @param n    要增加的天数
     * @return 增加之后的天数
     */
    fun addDay(date: Date, n: Int): Date {
        val cal = Calendar.getInstance()
        cal.time = date
        cal.add(Calendar.DATE, n)
        return cal.time

    }


    /**
     * 获取当前日期是星期几
     *
     * @param date
     * @return 当前日期是星期几
     */
    fun getWeekOfDate(date: Date): String {
        val weekDays = arrayOf("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六")
        val cal = Calendar.getInstance()
        cal.time = date
        var w = cal.get(Calendar.DAY_OF_WEEK) - 1
        if (w < 0)
            w = 0
        return weekDays[w]
    }


    /**
     * 获取距现在某一小时的时刻
     *
     * @param format 格式化时间的格式
     * @param h      距现在的小时 例如：h=-1为上一个小时，h=1为下一个小时
     * @return 获取距现在某一小时的时刻
     */
    @SuppressLint("SimpleDateFormat")
    fun getNextHour(format: String, h: Int): String {
        val sdf = SimpleDateFormat(format)
        val date = Date()
        date.time = date.time + h * 60 * 60 * 1000
        return sdf.format(date)

    }


    /**
     * 获取时间戳
     *
     * @return 获取时间戳
     */
    @SuppressLint("SimpleDateFormat")
    fun getTimeString(): String {
        val df = SimpleDateFormat(FORMAT_FULL)
        val calendar = Calendar.getInstance()
        return df.format(calendar.time)

    }

    /**
     * 获取时间戳
     *
     * @return 获取时间戳
     */
    fun getTimeStamp(): Long {
        val calendar = Calendar.getInstance()
        return calendar.timeInMillis
    }


    /*
     * 将时间转换为时间戳
     */
    @Throws(ParseException::class)
    fun dateToStamp(s: String): Long {
        val simpleDateFormat = SimpleDateFormat(FORMAT_FULL)
        val date = simpleDateFormat.parse(s)
        val ts = date.time
        return ts
    }


    /**
     * 功能描述：返回月
     *
     * @param date Date 日期
     * @return 返回月份
     */
    fun getMonth(date: Date): Int {
        calendar = Calendar.getInstance()
        calendar!!.time = date
        return calendar!!.get(Calendar.MONTH) + 1
    }


    /**
     * 功能描述：返回日
     *
     * @param date Date 日期
     * @return 返回日份
     */
    fun getDay(date: Date): Int {
        calendar = Calendar.getInstance()
        calendar!!.time = date
        return calendar!!.get(Calendar.DAY_OF_MONTH)
    }


    /**
     * 功能描述：返回小
     *
     * @param date 日期
     * @return 返回小时
     */
    fun getHour(date: Date): Int {
        calendar = Calendar.getInstance()
        calendar!!.time = date
        return calendar!!.get(Calendar.HOUR_OF_DAY)
    }


    /**
     * 功能描述：返回分
     *
     * @param date 日期
     * @return 返回分钟
     */
    fun getMinute(date: Date): Int {
        calendar = Calendar.getInstance()
        calendar!!.time = date
        return calendar!!.get(Calendar.MINUTE)
    }


    /**
     * 获得默认的 date pattern
     *
     * @return 默认的格式
     */
    fun getDatePattern(): String {

        return FORMAT_YMDHMS
    }


    /**
     * 返回秒钟
     *
     * @param date Date 日期
     * @return 返回秒钟
     */
    fun getSecond(date: Date): Int {
        calendar = Calendar.getInstance()

        calendar!!.time = date
        return calendar!!.get(Calendar.SECOND)
    }


    /**
     * 使用预设格式提取字符串日期
     *
     * @param strDate 日期字符串
     * @return 提取字符串的日期
     */
    fun parse(strDate: String): Date? {
        return parse(strDate, getDatePattern())

    }


    /**
     * 功能描述：返回毫
     *
     * @param date 日期
     * @return 返回毫
     */
    fun getMillis(date: Date): Long {
        calendar = Calendar.getInstance()
        calendar!!.time = date
        return calendar!!.timeInMillis
    }


    /**
     * 按默认格式的字符串距离今天的天数
     *
     * @param date 日期字符串
     * @return 按默认格式的字符串距离今天的天数
     */
    fun countDays(date: String?): Int {
        if (date == null) return -1
        val t = Calendar.getInstance().time.time
        val c = Calendar.getInstance()
        c.time = parse(date)!!
        val t1 = c.time.time
        return (t / 1000 - t1 / 1000).toInt() / 3600 / 24

    }

    /**
     * 按默认格式的字符串距离今天的小时
     *
     * @param date 日期字符串
     * @return 按默认格式的字符串距离今天的天数
     */
    fun countHour(date: String): Int {
        val t = Calendar.getInstance().time.time
        val c = Calendar.getInstance()
        val t1 = c.time.time
        return ((t / 1000 - t1 / 1000) / 3600).toInt()
    }


    /**
     * 使用用户格式提取字符串日期
     *
     * @param strDate 日期字符串
     * @param pattern 日期格式
     * @return 提取字符串日期
     */
    fun parse(strDate: String, pattern: String): Date? {
        val df = SimpleDateFormat(pattern)
        try {
            return df.parse(strDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            return null
        }

    }

    /**
     * 按用户格式字符串距离今天的天数
     *
     * @param date   日期字符串
     * @param format 日期格式
     * @return 按用户格式字符串距离今天的天数
     */
    fun countDays(date: String, format: String): Int {
        val t = Calendar.getInstance().time.time
        val c = Calendar.getInstance()
        c.time = parse(date, format)!!
        val t1 = c.time.time
        return (t / 1000 - t1 / 1000).toInt() / 3600 / 24
    }

    /**
     * 根据提供的年月获取该月份的最后(第一)一天
     * @Description: (这里用一句话描述这个方法的作用)
     * @param year
     * @param monthOfYear
     * @return
     */
    fun getSupportEndDayofMonth(year: Int, monthOfYear: Int): String {
        val cal = Calendar.getInstance()
        // 不加下面2行，就是取当前时间前一个月的第一天及最后一天
        cal.set(Calendar.YEAR, year)
        cal.set(Calendar.MONTH, monthOfYear)
        cal.set(Calendar.DAY_OF_MONTH, 1)
        cal.set(Calendar.HOUR_OF_DAY, 23)
        cal.set(Calendar.MINUTE, 59)
        cal.set(Calendar.SECOND, 59)

        cal.add(Calendar.DAY_OF_MONTH, -1)
        val lastDate = cal.time//最后一天

        cal.set(Calendar.DAY_OF_MONTH, 1)
        val firstDate = cal.time//第一天

        val cal1 = Calendar.getInstance()
        cal1.time = lastDate
        val day = cal1.get(Calendar.DAY_OF_MONTH)
        return day.toString()
    }

    /**
     * 根据开始时间和结束时间返回时间段内的时间集合
     * @param beginDate 8:00
     * @param endDate   15:00
     * @return List<Date>
     * @throws ParseException      
    </Date> */
    @Throws(ParseException::class)
    fun getDatesBetweenTwoDate(beginDate: String, endDate: String?): List<String> {
        var beginDate = beginDate
        var endDate = endDate
        val sdf = SimpleDateFormat(FORMAT_HM)
        val lDate = ArrayList<String>()
        if (beginDate.length > 5) {
            beginDate = beginDate.substring(0, 5)
        }
        lDate.add(beginDate)//把开始时间加入集合
        val cal = Calendar.getInstance()
        //使用给定的 Date 设置此 Calendar 的时间
        cal.time = sdf.parse(beginDate)
        val bContinue = true
        while (bContinue) {
            //根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.MINUTE, 30)
            // 测试此日期是否在指定日期之后
            if (sdf.parse(endDate).after(cal.time)) {
                lDate.add(sdf.format(cal.time))
            } else {
                break
            }
        }
        if (endDate!!.length > 5) {
            endDate = endDate.substring(0, 5)
        }
        //校验结束时间 是否等于三十 或者00
        if (endDate != null && endDate.length >= 5) {
            if (endDate.endsWith("00") || endDate.endsWith("30")) {
                lDate.add(endDate)//把结束时间加入集合
            }
        }
        return lDate
    }

    /**
     * 比较两个时间哪个大
     * @param date1 8:00
     * @param date2   15:00
     * @return List<Date>
     * @throws ParseException      
    </Date> */
    @SuppressLint("SimpleDateFormat")
    fun compareDate(date1: String, date2: String): Int {
        val df = SimpleDateFormat(FORMAT_HM)
        try {
            val dt1 = df.parse(date1)
            val dt2 = df.parse(date2)
            if (dt1.time > dt2.time) {
                println("dt1 在dt2前")
                return 1
            } else if (dt1.time < dt2.time) {
                println("dt1在dt2后")
                return -1
            } else {
                return 0
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }

        return 0
    }

    /**
     *
     * @param ss 秒
     * */
    fun calculateTime(ss: Long): String? {
        val mm = 60
        val hh = mm * 60
        val dd = hh * 24

        val day = ss / dd
        val hour = (ss - day * dd) / hh
        val minute = (ss - day * dd - hour * hh) / mm
        val second = (ss - day * dd - hour * hh - minute * mm)

        val sb = StringBuffer()
        if (day > 0) {
            sb.append(day.toString() + "d")
        }
        if (hour > 0) {
            sb.append(hour.toString() + "h")
        }
        if (minute > 0) {
            if (second > 0) {
                sb.append((minute + 1).toString() + "min")
            } else {
                sb.append(minute.toString() + "min")
            }
        }else{
            sb.append( "1 min")
        }

        return sb.toString()
    }

}