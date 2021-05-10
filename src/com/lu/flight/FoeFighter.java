package com.lu.flight;

import com.lu.gameobject.ColideBox;
import com.lu.gameobject.RigidBody;
import com.lu.gameobject.Shape;
import com.lu.gameobject.Texture;
import processing.core.PApplet;
import processing.core.PVector;

public class FoeFighter extends Aircraft {
    boolean boss = false;
    int x;
    int y;
    int velocity;
    int hp;
    public int damageTaken = 1;
    Shape body;
    Texture t;
    public RigidBody r;
    PApplet p;

    public FoeFighter(int x, int y, int velocity, int hp) {
        this.hp = hp;
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        body = new Shape("image", 0, 0, 80, 60, "foe-fighter.png");
        t = new Texture(this.x, this.y, body);
        r = new RigidBody(t) {
            @Override
            public void onCollision(RigidBody r) {
                //super.onCollision(r);
                if (r.getTag().equals("bullet")) {
                    hit();
                    System.out.println("hit by bullet");
                }
                if (r.getTag().equals("player")) {
                    collide();
                }
            }
        };
        r.setTag("foe");
        r.addColideBox(new ColideBox("rectangle", 0, 0, 40, 20, r));
        r.setApplyGravity(false);
        r.setVelocity(new PVector(-velocity, 0));
        p = r.getP();
    }

    public FoeFighter(int x, int y, int velocity, int hp, boolean boss) {
        this.boss = boss;
        if (boss == true) {
            this.hp = 3 * hp;
        } else {
            this.hp = hp;
        }
        this.x = x;
        this.y = y;
        if(boss==true){
            this.velocity=velocity/2;
        }
        else{
        this.velocity = velocity;}

        if (boss == true) {
            body = new Shape("image", 0, 0, 200, 80, "boss.png");
        } else {
            body = new Shape("image", 0, 0, 80, 60, "foe-fighter.png");
        }
        t = new Texture(this.x, this.y, body);
        r = new RigidBody(t) {
            @Override
            public void onCollision(RigidBody r) {
                //super.onCollision(r);
                if (r.getTag().equals("bullet")) {
                    hit();
                    System.out.println("hit by bullet");
                }
                if (r.getTag().equals("player")) {
                    collide();
                }
            }
        };
        r.setTag("foe");
        if (boss == true) {
            r.addColideBox(new ColideBox("rectangle", 0, 0, 100, 30, r));
        } else {
            r.addColideBox(new ColideBox("rectangle", 0, 0, 40, 20, r));
        }
        r.setApplyGravity(false);
        r.setVelocity(new PVector(-this.velocity, 0));
        p = r.getP();
    }

    public void hit() {
        this.hp -= damageTaken;
    }

    public void collide() {
        this.hp -= 100;
    }

    public void destroyed() {
        this.r.getStage().removeRigidBody(r);
    }
}
