package com.lu.flight;

import com.lu.gameobject.Shape;
import com.lu.gameobject.Texture;
import com.lu.programme.Main;
import processing.core.PApplet;

public class Background {
    int timer=0;
    PApplet p= Main.processing;
    Texture bg=new Texture(0,0,new Shape("image",0,0,1600,600,"bg2.png"));
    //Texture bg2=new Texture(0,0,new Shape("image",800,0,800,600,"bg.png"));

    public void draw(){
        timer++;
        bg.setX(-timer*3);
        bg.draw();
        if(bg.getX()<=-800){
            timer=0;
        }

    }
}
