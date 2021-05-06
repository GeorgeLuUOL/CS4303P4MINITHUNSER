package com.lu.artillery;


import processing.core.PVector;

import com.lu.gameobject.*;
import com.lu.gameobject.Stage;

public class Tank {
    Stage stage;
    RigidBody r;
    public int x;
    public int y;

    public Tank(int x, int y, int num) {
        this.x = x;
        this.y = y;
        Texture t = new Texture(this.x, this.y);
        Shape s;
        if (num == 1) {
            s = new Shape("image", 0, 0, 100, 100, "src/data/tankr.png");
        } else {
            s = new Shape("image", 0, 0, 100, 100, "src/data/tankl.png");
        }
        t.addShape(s);
        r = new RigidBody(t) {
            @Override
            public void onCollision(RigidBody r) {
                {
                    this.setVelocity(new PVector(0, 0));
                }
                if (r.getTag().equals("shell") && r.getApplyColision() == true) {
                    trigger();
                    r.trigger();
                }

                //System.out.println("override on Collision");
            }
        };
        r.addColideBox(new ColideBox("rectangle", this.x, this.y, 50, 50, r));
        r.setApplyGravity(false);
        r.setTag("tank");

    }

    public void draw() {
        this.r.draw();
    }

    public void moveLeft() {
        r.setVelocity(new PVector(-5f, 0f));
        //System.out.println(r.getTexture().getX());
    }

    public void stop() {
        r.setVelocity(new PVector(0f, 0f));
    }

    public void moveRight() {
        r.setVelocity(new PVector(5f, 0f));
    }

    public void destroy() {
        this.r.getStage().removeRigidBody(r);
    }


    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
