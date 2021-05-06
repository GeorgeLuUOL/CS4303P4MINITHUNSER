package com.lu.artillery;

import com.lu.gameobject.RigidBody;
import com.lu.gameobject.Shape;
import com.lu.gameobject.Texture;

public class Arrow {
    RigidBody r;
    public int x;
    public int y;
    public int angle;
    public int scale;



    public Arrow(int x, int y, int type) {
        this.x = x;
        this.y = y;
        Shape s;
        if (type == 1) {
            s = new Shape("image", 0, 0, 100, 100, "src/data/pointerR.png");
        } else {
            s = new Shape("image", 0, 0, 100, 100, "src/data/pointerT.png");
        }
        Texture t=new Texture(x,y);
        t.addShape(s);
        r=new RigidBody(t);
        r.setApplyColision(false);
        r.setApplyGravity(false);

    }
    public void rotate(int angle){
        this.r.rotate(angle);
    }
    public void setPos(int x,int y){
        r.getTexture().setX(x);
        r.getTexture().setY(y);
    }
    public void setScale(float scale){
        r.getTexture().setScale(scale);
        setPos(x, (int) (y-r.getTexture().getShapeArr().get(0).getHeight()*scale/2));

    }

}
