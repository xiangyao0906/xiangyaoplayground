package com.xiangyao.train.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.xiangyao.train.bean.CityBean


@Dao
interface CityDao {

    @Query("SELECT * FROM movie_citys")
    fun getAllCits():List<CityBean>


    @Insert
    fun insertAll( citys:List<CityBean>)

    @Query("SELECT * FROM movie_citys WHERE cityName = :name")
    fun getCity(name:String):CityBean


    @Query("SELECT COUNT(*)  FROM movie_citys")
    fun citesCount():Int




}