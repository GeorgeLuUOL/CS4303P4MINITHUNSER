package com.lu.artillery;

import com.lu.gameobject.RigidBody;
import com.lu.gameobject.Shape;
import com.lu.gameobject.Texture;

public class Terrain {

    RigidBody r;
    Texture texture;
    Boolean exploded=true;



    public Terrain(){

        texture=new Texture(0,800);


        Shape s=new Shape("rectangle",0,0,1600,100);
        s.setColorArr(new int[]{191,151,0});
        texture.addShape(s);
        r=new RigidBody(texture);
        r.setApplyGravity(false);
        //r.addColideBox(new ColideBox("rectangle",800,850,1600/2,80/2,r));
        r.setApplyColision(false);

    }
    public void draw(){
        r.draw();

    }
    public void exploded(){
        this.exploded=true;
    }
    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Boolean getExploded() {
        return exploded;
    }

    public void setExploded(Boolean exploded) {
        this.exploded = exploded;
    }

    public RigidBody getR() {
        return r;
    }

    public void setR(RigidBody r) {
        this.r = r;
    }
}
