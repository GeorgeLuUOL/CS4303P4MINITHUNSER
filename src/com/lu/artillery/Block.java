package com.lu.artillery;

import com.lu.gameobject.ColideBox;
import com.lu.gameobject.RigidBody;
import com.lu.gameobject.Shape;
import com.lu.gameobject.Texture;
import processing.core.PVector;

public class Block {
    RigidBody r;
    int x;
    int y;
    int width;
    int height;

    public Block(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        Shape s = new Shape("rectangle", 0, 0, width, height);
        Texture t = new Texture(x, y);
        t.addShape(s);
        r = new RigidBody(t) {
            @Override
            public void onCollision(RigidBody r) {

                    this.setVelocity(new PVector(0, 0));

                if (r.getTag().equals("shell")) {
                    trigger();
                    r.trigger();
                }

                //System.out.println("override on Collision");
            }
        };
        r.setGravity(0.1);
        r.setTag("block");
        r.addColideBox(new ColideBox("rectangle", this.x, this.y, width / 2, height / 2, r));
    }

    public void destroy() {
        this.r.getStage().removeRigidBody(r);
    }
}
