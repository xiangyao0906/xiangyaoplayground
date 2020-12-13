package com.xiangyao.train.database

import com.xiangyao.train.base.DemoApplication
import com.xiangyao.train.bean.CityBean

class  CityDaoHelper private constructor(){

   private val cityDataBase =CityDataBase.getInstance(DemoApplication.appContext)

    companion object {

        val instance: CityDaoHelper by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { CityDaoHelper() }

    }

    fun instertAllCitys(citys: ArrayList<CityBean>){

        cityDataBase.cityDao().insertAll(citys)
    }

    fun findCityByName(name:String):CityBean{
        return cityDataBase.cityDao().getCity(name) ?:CityBean()
    }

    fun countCites():Int{

        return cityDataBase.cityDao().citesCount() ?:0
    }

}