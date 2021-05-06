package com.lu.flight;

import com.lu.gameobject.RigidBody;
import com.lu.gameobject.Shape;
import com.lu.gameobject.Texture;
import com.lu.programme.Main;
import processing.core.PApplet;
import processing.core.PVector;

public class Background {
    int timer=0;
    PApplet p= Main.processing;
    Texture bg=new Texture(0,0,new Shape("image",0,0,1600,600,"bg2.png"));
    public RigidBody r=new RigidBody(bg);

    //Texture bg2=new Texture(0,0,new Shape("image",800,0,800,600,"bg.png"));
    public Background(){
        r.setApplyGravity(false);
        r.setVelocity(new PVector(-3,0));
    }

    public void draw(){


    }
}
