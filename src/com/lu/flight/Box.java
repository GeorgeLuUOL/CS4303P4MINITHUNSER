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
    int type;
    Shape body;
    Texture t;
    public RigidBody r;
    PApplet p;

    //for type 1 for hp, 2 for damage, 3 for maneuverability
    public Box(int x, int y, int type) {
        this.hp = hp;
        this.x = x;
        this.y = y;
        this.type = type;
        if (type == 1) {
            body = new Shape("image", 0, 0, 50, 50, "box-hp.png");
        } else if (type == 2) {
            body = new Shape("image", 0, 0, 50, 50, "box-damage.png");
        }
        t = new Texture(this.x, this.y, body);
        r = new RigidBody(t) {
            @Override
            public void onCollision(RigidBody r) {
                //super.onCollision(r);
                if (r.getTag().equals("player")) {
                    System.out.println("collect box");
                }
            }
        };
        r.addColideBox(new ColideBox("rectangle", this.x, this.y, 25, 25, r));
        r.setApplyGravity(false);
        r.setVelocity(new PVector(-3, -2));
        p = r.getP();
    }
}
