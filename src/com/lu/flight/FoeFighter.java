package com.lu.flight;

import com.lu.gameobject.ColideBox;
import com.lu.gameobject.RigidBody;
import com.lu.gameobject.Shape;
import com.lu.gameobject.Texture;
import processing.core.PApplet;
import processing.core.PVector;

public class FoeFighter extends Aircraft {
    int x;
    int y;
    int velocity;
    int hp;
    Shape body;
    Texture t;
    public RigidBody r;
    PApplet p;

    public FoeFighter(int x, int y, int velocity, int hp){
        this.hp=hp;
        this.x=x;
        this.y=y;
        this.velocity=velocity;
        body=new Shape("image",0,0,80,60,"foe-fighter.png");
        t=new Texture(this.x,this.y,body);
        r=new RigidBody(t){
            @Override
            public void onCollision(RigidBody r) {
                //super.onCollision(r);
                if(r.getTag().equals("bullet")){
                    hit();
                System.out.println("hit by bullet");}
                if(r.getTag().equals("player")){
                    collide();
                }
            }
        };
        r.setTag("foe");
        r.addColideBox(new ColideBox("rectangle",0,0,40,20,r));
        r.setApplyGravity(false);
        r.setVelocity(new PVector(-velocity,0));
        p=r.getP();
    }
    public void hit(){
        this.hp--;
    }
    public void collide(){
        this.hp-=100;
    }
    public void destroyed(){
        this.r.getStage().removeRigidBody(r);
    }
}
