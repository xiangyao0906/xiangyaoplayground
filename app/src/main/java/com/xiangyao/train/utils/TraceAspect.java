package com.xiangyao.train.utils;

/**
 * Created by Administrator on 2017/09/07.
 */

import android.app.Activity;
import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Title: TraceAspect
 * @Package com.yizhilu.utils
 * @Description: ${todo}(用一句话描述该文件做什么)

 * @date  2017/09/07 15:04
 */

/**
 * @author Administrator  2017-09-07-15点04分
 *
 * 监听所有Activity中的**可见**函数并将其时间通过Log日志打出
 *
 * 下方的@Aspect标示就代表这个类是监测类
 */

@Aspect
public class TraceAspect {

    public static final String TAG = "TraceAspect";

    //这儿是切入点的字符串，也就是让其监测和(* *..Activity+.*(..))一样的方法
    // 这个匹配规则我们这次先不讲，等第二版的时候我们对其讲解
//    private static final String POINTCUT_METHOD = "execution(* *..Activity+.*(..))";

    //这儿是切入点，我们可以根据切入点的方法名做些小动作
//    @Pointcut(POINTCUT_METHOD)
    @Pointcut("execution(* *..Activity+.*(..))")
    public void methodLogger() {}

//    @Before("methodLogger()")
//    public void onMethodBefore(JoinPoint joinPoint) {
//        //在调用切入点方法之前可以做一些操作，就在这儿做
//        //比如获取这个方法的类名或者调用方法前弹个提示信息，修改一些数据等等
//        //我这儿就只输出一下方法的类名
//        Log.e(TAG, "onMethodBefore: 类名："+joinPoint.toString());
//        //获取方法的类的对象，对其进行操作
//        Log.e(TAG, "onMethodBefore: 是否是Activity？ "+(joinPoint.getTarget() instanceof Activity));
//        //还可以操作更多，自己慢慢探索
//    }

    @After("methodLogger()")
    public void onMethodAfter(JoinPoint joinPoint) {
        //在调用切点方法之后可以做些操作，就在这儿做
        //比如获取这个方法的类名或者调用方法前弹个提示信息，修改一些数据等等
        //我这儿就只输出一下方法的类名
        Log.e(TAG, "onMethodBefore: 类名："+joinPoint.toString());
        //获取方法的类的对象，对其进行操作
        Log.e(TAG, "onMethodBefore: 是否是Activity？ "+(joinPoint.getTarget() instanceof Activity));
        //还可以操作更多，自己慢慢探索
    }

    @Around("methodLogger()")
    public Object onMethodAround(ProceedingJoinPoint joinPoint) throws Throwable {
        //方法执行时，对其进行操作
        //方法执行开始，计时
        long startTime = System.nanoTime();
        //方法执行
        Object proceed = joinPoint.proceed();
        //方法执行后，计时
        long endTime = System.nanoTime();

        //这个Object的proceed对象就是我们监听的方法的返回值
        //我们可以通过改变这个值中的一些属性，达到改变这个返回值的作用

        Log.e(TAG, "onMethodAround: 方法执行的效率："+(endTime-startTime));
        return proceed;
    }

}
