package com.xiangyao.train.bean;

public class MovieBean {

    /**
     * id : 1325487
     * haspromotionTag : false
     * img : http://p0.meituan.net/w.h/movie/c7b0e1254807467dbc761f46e7f19d5d2976982.jpg
     * version :
     * nm : 沐浴之王
     * preShow : false
     * sc : 8.8
     * globalReleased : true
     * wish : 91202
     * star : 彭昱畅,乔杉,卜冠今
     * rt : 2020-12-11
     * showInfo : 今天132家影院放映1772场
     * showst : 3
     * wishst : 0
     */

    private Integer id;
    private Boolean haspromotionTag;
    private String img;
    private String version;
    private String nm;
    private Boolean preShow;
    private Double sc;
    private Boolean globalReleased;
    private Integer wish;
    private String star;
    private String rt;
    private String showInfo;
    private Integer showst;
    private Integer wishst;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean isHaspromotionTag() {
        return haspromotionTag;
    }

    public void setHaspromotionTag(Boolean haspromotionTag) {
        this.haspromotionTag = haspromotionTag;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public Boolean isPreShow() {
        return preShow;
    }

    public void setPreShow(Boolean preShow) {
        this.preShow = preShow;
    }

    public Double getSc() {
        return sc;
    }

    public void setSc(Double sc) {
        this.sc = sc;
    }

    public Boolean isGlobalReleased() {
        return globalReleased;
    }

    public void setGlobalReleased(Boolean globalReleased) {
        this.globalReleased = globalReleased;
    }

    public Integer getWish() {
        return wish;
    }

    public void setWish(Integer wish) {
        this.wish = wish;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getShowInfo() {
        return showInfo;
    }

    public void setShowInfo(String showInfo) {
        this.showInfo = showInfo;
    }

    public Integer getShowst() {
        return showst;
    }

    public void setShowst(Integer showst) {
        this.showst = showst;
    }

    public Integer getWishst() {
        return wishst;
    }

    public void setWishst(Integer wishst) {
        this.wishst = wishst;
    }

}
