package com.lu.gameobject;


import processing.core.PApplet;

import com.lu.programme.Main;

import java.util.Vector;

//Every gameObject shall behave in a stage
//the stage has a container to hold all game object and curry out collision detection
public class Stage {
    protected PApplet p = Main.processing;
    protected Vector<RigidBody> container = new Vector<RigidBody>();
    protected Vector<ColideBox> colliderContainer = new Vector<ColideBox>();

    public Stage() {
    }

    public void draw() {
        if(!container.isEmpty()){
        handleCollision();
        for (RigidBody r : container) {
            p.pushMatrix();
            r.draw();
            p.popMatrix();
        }}
    }

    //go through all the rigidBody, see if it collide with any CollideBox
    public void handleCollision() {
        for (RigidBody r : container) {
            for (ColideBox c : colliderContainer) {
                if (c.getR() != r) {
                    for (ColideBox ColliderForR : r.getColideBox()) {
                        if (Math.abs(ColliderForR.getX() - c.getX()) <= Math.abs(ColliderForR.getWidth() + c.getWidth())
                                &&Math.abs(ColliderForR.getY() - c.getY()) <= Math.abs(ColliderForR.getHeight() + c.getHeight())) {
                            r.onCollision(c.getR());
                            System.out.println("collidion: "+r.getTag());
                            ColliderForR.setColision(true);
                        }
                    }
                }
            }
        }
    }
    public void addRigidBody(RigidBody r){
        this.container.add(r);
        r.setStage(this);
        for(ColideBox c:r.getColideBox()){
            this.colliderContainer.add(c);
        }
    }
    //to make it Thread safe
    public void removeRigidBody(RigidBody r){
        Vector<RigidBody> tempVec= (Vector<RigidBody>) container.clone();
        Vector<ColideBox> tempVecC= (Vector<ColideBox>) colliderContainer.clone();
        tempVec.remove(r);

        for(ColideBox c:colliderContainer){
            if(c.getR()==r){
                tempVecC.remove(c);
            }
        }
        this.container=tempVec;
        this.colliderContainer=tempVecC;
    }
}
