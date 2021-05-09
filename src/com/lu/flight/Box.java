package com.lu.flight;

import com.lu.gameobject.ColideBox;
import com.lu.gameobject.RigidBody;
import com.lu.gameobject.Shape;
import com.lu.gameobject.Texture;
import processing.core.PApplet;
import processing.core.PVector;

public class Box {
    int x;
    int y;
    int velocity;
    int hp;
    Shape body;
    Texture t;
    public RigidBody r;
    PApplet p;

    public Box(int x, int y, int velocity, int hp){
        this.hp=hp;
        this.x=x;
        this.y=y;
        this.velocity=velocity;
        body=new Shape("image",0,0,50,50,"foe-fighter.png");
        t=new Texture(this.x,this.y,body);
        r=new RigidBody(t){
            @Override
            public void onCollision(RigidBody r) {
                //super.onCollision(r);
                if(r.getTag().equals("bullet")){
                    System.out.println("hit by bullet");}
            }
        };
        r.addColideBox(new ColideBox("rectangle",this.x,this.y,40,30,r));
        r.setApplyGravity(false);
        r.setVelocity(new PVector(-velocity,0));
        p=r.getP();
    }
}