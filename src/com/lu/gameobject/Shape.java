package com.lu.gameobject;

import processing.core.*;

public class Shape {
    private String type;
    private int width = 0;
    private int height = 0;
    private int x = 0;
    private int y = 0;
    private int r = 0;
    private int[] colorArr={0,0,0};
    private String imgPath;

    public Shape(String type, int x, int y, int width, int height, String path) {
        this.type = type;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.imgPath=path;
    }

    public String getImg() {
        return imgPath;
    }

    public void setImg(String img) {
        this.imgPath = img;
    }



    public int[] getColorArr() {
        return colorArr;
    }

    public void setColorArr(int[] colorArr) {
        this.colorArr = colorArr;
    }


    public Shape(String type, int x, int y, int width, int height, int r) {
        this.type = type;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public void move(PVector v) {

        this.x += v.x;
        this.y += v.y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public Shape(String type, int x, int y, int width, int height) {
        this.type = type;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.r = 0;

    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
