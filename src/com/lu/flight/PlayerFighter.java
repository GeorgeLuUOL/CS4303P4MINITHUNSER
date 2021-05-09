package com.lu.flight;

import com.lu.gameobject.ColideBox;
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
    public int hp=10;

    public PlayerFighter(){
        body=new Shape("image",0,0,100,60,"player-fighter.png");
        t=new Texture(100,300,body);
        r=new RigidBody(t){
            @Override
            public void onCollision(RigidBody r) {
                if(r.getTag().equals("foe")){
                    hp--;
                    //System.out.println("collision");
                }
            }
        };
        r.setTag("player");
        r.addColideBox(new ColideBox("rectangle",0,0,40,20,r));
        r.setApplyGravity(false);
        p=r.getP();
    }
    public void draw(){

        //r.setVelocity(new PVector(3,0));
        r.draw();
    }
}
