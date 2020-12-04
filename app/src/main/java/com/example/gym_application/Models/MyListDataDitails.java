package com.example.gym_application.Models;

public class MyListDataDitails {
    private String description;
    private String size;
    private int imgId;
    private int exeimage;
    public MyListDataDitails(String description, String size, int exeimage, int imgId) {
        this.description = description;
        this.size = size;
        this.imgId = imgId;
        this.exeimage = exeimage;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getExeimage() {
        return exeimage;
    }

    public void setExeimage(int exeimage) {
        this.exeimage = exeimage;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getImgId() {
        return imgId;
    }
    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}