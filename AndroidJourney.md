#学习笔记
> be hungry ! be  foor
##kotlin
>今天完成了第一个用kotlin编写的类，语法可能有些简单，但我觉得这也是一种尝试，努力在路上

<center><front color=grey>[我的第一个kotlin页面](https://git.oschina.net/bishuangena/NewXueDemo/blob/master/app/src/main/java/com/yizhilu/community/TopicOfMyActivity.kt)</center>
####1·逻辑语句控制语句-when


<pre>
java
<code>
if (item.ifAudit == 1) {
            holder.checking.text = "审"
            holder.checking.background = context!!.resources.getDrawable(R.drawable.text_red_bg_solid_frame)
        } else if (item.ifAudit == 3) {
            holder.checking.text = "驳回"
            holder.checking.background = context!!.resources.getDrawable(R.drawable.text_gray_bg_solid_frame)
        } else if (item.ifAudit == 4) {
            holder.checking.text = "冻结"
            holder.checking.background = context!!.resources.getDrawable(R.drawable.text_gray_bg_solid_frame)
        }
</code></pre>

<pre>
kotlin
<code>
 when {
            item.ifAudit == 1 -> {
                holder.checking.text = "审"
                holder.checking.background = context!!.resources.getDrawable(R.drawable.text_red_bg_solid_frame)
            }
            item.ifAudit == 3 -> {
                holder.checking.text = "驳回"
                holder.checking.background = context!!.resources.getDrawable(R.drawable.text_gray_bg_solid_frame)
            }
            item.ifAudit == 4 -> {
                holder.checking.text = "冻结"
                holder.checking.background = context!!.resources.getDrawable(R.drawable.text_gray_bg_solid_frame)
            }
        }
</code></pre>

##android
>BRVAH 一个开源的BaseAdapter的库
>真的很好用!!!

<center><font color=grey>[BRVAH官方使用指南（持续更新）](http://www.jianshu.com/p/b343fcff51b0)</font></center>
##RxJava

>俗称"水管" 
<center><font color=grey>[传送门](http://blog.csdn.net/johnny901114/article/details/51614927)</font></center>
##RxAndroid
##Retrift
<center><font color=grey>[傳送門](http://www.jianshu.com/p/308f3c54abdd)</font></center>

##MVP

->永远不要改变别人的代码(谨记) ，一百个人就有一百个哈姆雷特
<br/>
<code>
mvp 的目的是为了解决view 的臃肿代码 为了让代码看起来更加的清晰<br/>
我个人觉得没必要形成思维定势，要摆脱一定怎样 才能怎样的束缚。
<br/>
->基础原型(会有很多变种)<br/>
M（Model）
数据层，和MVC中的M一样，用来放数据的处理（比如网络请求，缓存等）。

V(View)
负责UI具体实现展现。比如Presenter派发过来一个动作是showDialog显示进度命令，那么我们这个View就负责实现具体UI。

P(Presenter)
负责处理业务逻辑代码，处理Model数据，然后将处理完的数据分发到View层。
	

<code/>

##图片居中

<center>![](http://oho5vvdsd.bkt.clouddn.com/film_yourname3.jpg)</center>

##SVG
>SVG可以算是目前最最火热的图像文件格式了，它的英文全称为Scalable Vector Graphics，意思为可缩放的矢量图形。它是基于XML（Extensible Markup Language），由World Wide Web Consortium（W3C）联盟进行开发的。严格来说应该是一种开放标准的矢量图形语言，可让你设计激动人心的、高分辨率的Web图形页面。用户可以直接用代码来描绘图像，可以用任何文字处理工具打开SVG图像，通过改变部分代码来使图像具有互交功能，并可以随时插入到HTML中通过浏览器来观看。
<center><font color=grey>[走起](http://blog.csdn.net/baidu_31093133/article/details/51984902)</font></center>

##发布类库到jcenter
>JitPack、jCenter是我们常用的发布Android开源库的网站，发布成功后就可以在Android Studio中通过Gradle方便的引用到项目中了，相比Eclipse时代要方便的多，对于使用者确实简单了，但对于发布者来说可能还略有坎坷，这里记录下发布的过程，以及遇到的坑。

[发布教程](http://www.jianshu.com/p/b7552cf8983b)
