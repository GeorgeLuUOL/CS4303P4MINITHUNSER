package com.lu.flight;

import com.lu.gameobject.RigidBody;
import com.lu.gameobject.Shape;
import com.lu.gameobject.Texture;
import processing.core.PApplet;
import processing.core.PVector;

public class PlayerFighter extends Aircraft {
    Shape body;
    Texture t;
    public RigidBody r;
    PApplet p;

    public PlayerFighter(){
        body=new Shape("image",0,0,100,60,"player-fighter.png");
        t=new Texture(100,300,body);
        r=new RigidBody(t);
        r.setApplyGravity(false);
        p=r.getP();
    }
    public void draw(){

        //r.setVelocity(new PVector(3,0));
        r.draw();
    }
}
