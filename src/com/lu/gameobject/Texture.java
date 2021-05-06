package com.lu.gameobject;

import com.lu.programme.Main;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;

public class Texture {
    private int x;
    private int y;
    private int trueX;
    private int trueY;
    private int angle=0;
    private float scale=1;

    PApplet p= Main.processing;
    ArrayList<Shape> shapeArr=new ArrayList<Shape>();


    public Texture(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Texture(int x, int y, Shape shape){
        this.x=x;
        this.y=y;
        shapeArr.add(shape);
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

    public ArrayList<Shape> getShapeArr() {
        return shapeArr;
    }

    public void setShapeArr(ArrayList<Shape> shapeArr) {
        this.shapeArr = shapeArr;
    }

    public void addShape(Shape s){
        this.shapeArr.add(s);
    }


    public void draw(){
        trueX=x;
        trueY=y;
        p.translate(x+shapeArr.get(0).getWidth()/2,y+shapeArr.get(0).getHeight()/2);
        //p.translate(x,y);
        p.rotate((float) Math.toRadians(angle));
        p.translate(-shapeArr.get(0).getWidth()/2,-shapeArr.get(0).getHeight()/2);

        for(Shape s:shapeArr){
            drewShape(s);
        }

        //p.translate(0,0);
        //p.translate(-x,-y);
        //p.rotate(0);

        //p.translate(0,0);
    }

    private void drewShape(Shape s){
        p.fill(s.getColorArr()[0],s.getColorArr()[1],s.getColorArr()[2]);
        if(s.getType().equals("rectangle")){
            //System.out.println(s.getX()+" "+s.getY()+" "+s.getWidth()+" "+s.getHeight()+""+s.getR());
            p.rect(s.getX(),s.getY(),s.getWidth()*scale,s.getHeight()*scale,s.getR());
        }
        if(s.getType().equals("ellipse")){
            p.ellipse(s.getX(),s.getY(),s.getWidth()*scale,s.getHeight()*scale);
        }
        if(s.getType().equals("image")){
            PImage img=p.loadImage(s.getImg());
            p.image(img,s.getX(),s.getY(),s.getWidth()*scale,s.getHeight()*scale);
        }
    }
    public void move(PVector v){
        this.x+=v.x;
        this.y+=v.y;
//        for(Shape s:shapeArr){
//        s.move(v);
//        }
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }
}
