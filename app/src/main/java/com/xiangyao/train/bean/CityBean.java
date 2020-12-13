package com.xiangyao.train.bean;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movie_citys")
public class CityBean {

    /**
     * id : 1
     * nm : 北京
     * py : beijing
     */

    @PrimaryKey
    private int _id;
    @ColumnInfo(name = "cityId")
    private Integer id;

    @ColumnInfo(name = "cityName")
    private String nm;

    @ColumnInfo(name = "cityNamePinyin")
    private String py;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNm() {
        return nm;
    }


    
    public void setNm(String nm) {
        this.nm = nm;
    }

    public String getPy() {
        return py;
    }

    public void setPy(String py) {
        this.py = py;
    }
}
