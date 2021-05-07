package com.lu.flight;

import com.lu.programme.Main;
import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class GameController {
    int timmer=0;
    PApplet p= Main.processing;
    StageForFlight stage=new StageForFlight();;
    Background bg;
    PlayerFighter pf;
    ArrayList<Bullet> bulletArr=new ArrayList(50);
    ArrayList<FoeFighter> FoeFighterArr=new ArrayList<>(50);
    FoeFighter ft;
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
        ft=new FoeFighter(800,300,1);
        stage.addRigidBody(ft.r);
    }

    public void draw(){
        //update time
        timmer++;
        //draw
        this.stage.draw();
        if(bg.r.getX()<=-800){
            bg.r.setX(0);
        }
        //adding enemy to the stage randomly
        if(timmer%50==0){
        ft=new FoeFighter(800,100+(int) (Math.random()*400),3+timmer/1000);
        stage.addRigidBody(ft.r);}
        //movement for player fighter
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
            //System.out.println("left button pressed");
            if(timmer%2==0){
                Bullet b=new Bullet(pf.r.getX()+90,pf.r.getY()+30,0);
                bulletArr.add(b);
                stage.addRigidBody(b.r);
            }
        }
        //gc

        //for bullet
        for(Bullet b:bulletArr){
            if(b.r.getX()>800){
                b.explode();
            }
        }
        if(timmer%60==0){
            bulletArr=new ArrayList<>();
            stage.gc("bullet");
            //System.out.println(stage.size()+" size");
        }

        //show collider
        if(bulletArr.size()>=1){
        System.out.println(bulletArr.get(0).r.getColideBox().get(0).toString());}


    }
}
