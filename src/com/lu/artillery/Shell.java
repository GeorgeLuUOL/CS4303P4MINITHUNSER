package com.lu.artillery;

import com.lu.gameobject.*;
import processing.core.PVector;

public class Shell implements Sprite {

    Boolean explode = false;
    RigidBody r;
    int x;
    int y;
    int fuse = 5;


    public Shell(int x, int y, int thrust, int angle, int wind) {
        this.x = x;
        this.y = y;
        Texture t = new Texture(this.x, this.y);
        Shape s = new Shape("ellipse", 0, 0, 10, 10);
        s.setColorArr(new int[]{100, 100, 100});
        t.addShape(s);
        r = new RigidBody(t);
        r.addColideBox(new ColideBox("rectangle", this.x, this.y, 5, 5, r));
        r.setTag("shell");
        r.setApplyColision(false);
        r.setAcceleration(new PVector((float) (wind * 0.001), 0));
        r.setVelocity(new PVector((float) (thrust * Math.cos(Math.toRadians(angle))), (float) -(thrust * Math.sin(Math.toRadians(angle)))));

    }

    public int getFuse() {
        return fuse;
    }

    public void burn() {
        fuse--;
    }

    public void explode() {
        this.r.getStage().removeRigidBody(r);
    }

    public void draw() {


        r.draw();

    }

    public Boolean getExplode() {
        return explode;
    }

    public Stage getStage() {
        return this.r.getStage();
    }

    public void setStage(Stage stage) {
        this.r.setStage(stage);
    }

    public void setExplode(Boolean explode) {
        this.explode = explode;
    }

    public RigidBody getR() {
        return r;
    }

    public void setR(RigidBody r) {
        this.r = r;
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
}
