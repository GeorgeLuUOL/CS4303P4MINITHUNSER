package com.lu.flight;

import com.lu.gameobject.ColideBox;
import com.lu.gameobject.RigidBody;
import com.lu.gameobject.Shape;
import com.lu.gameobject.Texture;
import processing.core.PVector;

public class FoeBullet {
    static  final int muzzelVelocity=10;
    Shape s=new Shape("ellipse", 0, 0, 5, 5);
    RigidBody r;
    public FoeBullet(int x, int y, int angle){
        Texture t=new Texture(x,y,s);
        r=new RigidBody(t){
            @Override
            public void onCollision(RigidBody r) {
                if(r.getTag().equals("player")){
                    explode();}
            }
        };
        r.setApplyGravity(false);
        r.addColideBox(new ColideBox("rectangle",x,y,5,5,r));
        r.setTag("foeBullet");
        r.setVelocity(new PVector((float) (muzzelVelocity * Math.cos(Math.toRadians(angle))), (float) -(muzzelVelocity * Math.sin(Math.toRadians(angle)))));
    }
    public void explode() {
        this.r.getStage().removeRigidBody(r);
    }
}
