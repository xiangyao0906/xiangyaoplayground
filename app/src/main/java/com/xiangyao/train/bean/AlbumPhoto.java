package com.xiangyao.train.bean;

public class AlbumPhoto {
    private long createTime;
    private String name;
    private String path;
    private boolean isSelected;


    public AlbumPhoto(long createTime, String name, String path) {
        this.createTime = createTime;
        this.name = name;
        this.path = path;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
