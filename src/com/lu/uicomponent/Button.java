package com.lu.uicomponent;

import com.lu.programme.Main;
import processing.core.PApplet;
import processing.core.PConstants;

public class Button implements UIComponent {
    PApplet p= Main.processing;
    boolean visable=true;
    boolean hang=false;
    String tag;
    String text;
    int stateTrans;
    int width;
    int height;
    int size;
    int x;
    int y;

    int[] bgColoor={50,50,50};
    int[] colour={255,255,255};

    public Button(String text, int x, int y,int width, int height){
        this.text=text;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getWidth() {
        return width;
    }

    public int getStateTrans() {
        return stateTrans;
    }

    public void setStateTrans(int stateTrans) {
        this.stateTrans = stateTrans;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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

    public int[] getBgColoor() {
        return bgColoor;
    }

    public void setBgColoor(int[] bgColoor) {
        this.bgColoor = bgColoor;
    }

    public int[] getColour() {
        return colour;
    }

    public boolean isHang() {
        return hang;
    }

    public void setHang(boolean hang) {
        this.hang = hang;
    }

    public void setColour(int[] colour) {
        this.colour = colour;
    }

    @Override
    public void draw() {
        //draw background
        if(hang==false){
        p.fill(bgColoor[0],bgColoor[1],bgColoor[2]);
        }
        else {
           p.fill(255,255,255);
        }

            p.rect(x,y,width,height,90);


        p.fill(colour[0],colour[1],colour[2]);
        p.textSize(size);
        p.textAlign(PConstants.CENTER,PConstants.CENTER);
        p.text(text,x+ width/2,y+height/2);

    }

    @Override
    public void setVisable(Boolean b) {
        this.visable=b;

    }

    @Override
    public Boolean getVisable() {
        return this.visable;
    }
}
