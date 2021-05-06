package com.lu.flight;

import com.lu.programme.Main;
import processing.core.PApplet;
import processing.core.PVector;

public class GameController {
    int timmer=0;
    PApplet p= Main.processing;
    StageForFlight stage=new StageForFlight();;
    Background bg;
    PlayerFighter pf;

    //attribution for game
    float maneuverability =0.2f;
    public GameController(){
       init();
    }
    public void init(){
         bg = new Background();
         pf=new PlayerFighter();
        stage.addRigidBody(bg.r);
        stage.addRigidBody(pf.r);
    }

    public void draw(){
        timmer++;
        this.stage.draw();
        if(bg.r.getX()<=-800){
            bg.r.setX(0);
        }
        //pf.r.setX(p.mouseX-40);
        //pf.r.setY(p.mouseY-30);
        if(Math.abs(p.mouseX-pf.r.getX())>1){
        int mouseX=p.mouseX;
        int mouseY=p.mouseY;
        int posX=pf.r.getX()+30;
        int posY=pf.r.getY();
        //float slope= (float) Math.sqrt((mouseX-posX)*(mouseX-posX)+(mouseY-posY)*(mouseY-posY));
        pf.r.setVelocity(new PVector(maneuverability*(mouseX-posX),maneuverability*(mouseY-posY)));

        }
        //fire
        if(p.mouseButton==37){
            System.out.println("left button pressed");
            if(timmer%2==0){
                Bullet b=new Bullet(pf.r.getX()+90,pf.r.getY()+30,0);
                stage.addRigidBody(b.r);
            }
        }


    }
}
