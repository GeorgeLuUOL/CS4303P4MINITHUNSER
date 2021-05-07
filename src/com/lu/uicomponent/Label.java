package com.lu.uicomponent;

import com.lu.programme.Main;
import processing.core.PApplet;

public class Label implements UIComponent {
    PApplet p= Main.processing;
    boolean visable=true;
    String tag;
    String text;
    int size;
    int x;
    int y;
    int[] colour={255,255,255};
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

    public int[] getColour() {
        return colour;
    }

    public void setColour(int[] colour) {
        this.colour = colour;
    }



    public Label(int x, int y, String text,int size){
        this.x=x;
        this.y=y;
        this.size=size;
        this.text=text;
    }
    public void draw(){
        p.fill(colour[0],colour[1],colour[2]);
        p.textSize(size);
        p.text(text,x,y);
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
