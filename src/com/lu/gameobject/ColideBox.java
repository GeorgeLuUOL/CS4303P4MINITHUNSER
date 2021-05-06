package com.lu.gameobject;

public class ColideBox {

    private Boolean colision=false;
    private String type;
    private int x;
    private int y;
    private int width;
    private int height;
    private RigidBody r;

    public ColideBox(String type, int x, int y, int width, int height,RigidBody r) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.r=r;
    }
    public Boolean getColision() {
        return colision;
    }

    public void setColision(Boolean colision) {
        this.colision = colision;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public RigidBody getR() {
        return r;
    }

    public void setR(RigidBody r) {
        this.r = r;
    }

    @Override
    public String toString() {
        return "ColideBox{" +
                "colision=" + colision +
                ", type='" + type + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", r=" + r +
                '}';
    }
}
