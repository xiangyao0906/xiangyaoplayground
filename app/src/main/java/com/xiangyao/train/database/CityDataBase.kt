package com.xiangyao.train.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.xiangyao.train.bean.CityBean

@Database(entities = [CityBean::class], version = 1,exportSchema = false)
abstract class CityDataBase : RoomDatabase() {
    abstract fun cityDao(): CityDao



    companion object {
        private var instance: CityDataBase? = null
        fun getInstance(context: Context): CityDataBase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                        context.applicationContext,
                        CityDataBase::class.java,
                        "user.db" //数据库名称
                ).allowMainThreadQueries().build()
            }
            return instance as CityDataBase
        }
    }

}