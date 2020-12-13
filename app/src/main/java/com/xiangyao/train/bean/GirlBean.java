package com.xiangyao.train.bean;

import java.util.List;

public class GirlBean {
    /**
     * _id : 5e959107808d6d2fe6b56ed2
     * author : 鸢媛
     * category : Girl
     * createdAt : 2020-05-15 08:00:00
     * desc : 爱一个人最好的方式，
     是经营好自己； 爱人要有度，留一点自我，
     才会有自尊，你的付出才会有人重视。 ​​​​
     * images : ["http://gank.io/images/92989b6a707b44dfb1c734e8d53d39a2"]
     * likeCounts : 3
     * publishedAt : 2020-05-15 08:00:00
     * stars : 1
     * title : 第86期
     * type : Girl
     * url : http://gank.io/images/92989b6a707b44dfb1c734e8d53d39a2
     * views : 1752
     */

    private String _id;
    private String author;
    private String category;
    private String createdAt;
    private String desc;
    private Integer likeCounts;
    private String publishedAt;
    private Integer stars;
    private String title;
    private String type;
    private String url;
    private Integer views;
    private List<String> images;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getLikeCounts() {
        return likeCounts;
    }

    public void setLikeCounts(Integer likeCounts) {
        this.likeCounts = likeCounts;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
