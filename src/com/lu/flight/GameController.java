package com.lu.flight;

import com.lu.programme.Main;
import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class GameController {
    int timmer=0;
    public int level;
    public int damageLevel;
    public int maneuverLevel;
    public int hp=1;
    public int score=0;
    PApplet p= Main.processing;
    StageForFlight stage=new StageForFlight();;
    Background bg;
    PlayerFighter pf;
    ArrayList<Bullet> bulletArr=new ArrayList(50);
    ArrayList<FoeFighter> foeFighterArr=new ArrayList<>(50);
    FoeFighter ft;
    //attribution for game
    float maneuverability =0.1f;
    public GameController(int level, int damageLevel,int maneuverLevel){
       init(level, damageLevel, maneuverLevel);
    }
    public void init(int level, int damageLevel,int maneuverLevel){
        this.level=level;
        this.damageLevel=damageLevel;
        this.maneuverLevel=maneuverLevel;
         bg = new Background();
         pf=new PlayerFighter();
        stage.addRigidBody(bg.r);
        stage.addRigidBody(pf.r);
        //ft=new FoeFighter(800,300,1,1+level/2);
        //stage.addRigidBody(ft.r);
    }

    public void draw(){
        //System.out.println(stage.size());
        //update time
        timmer++;
        this.hp=pf.hp;
        //draw
        this.stage.draw();
        if(bg.r.getX()<=-800){
            bg.r.setX(0);
        }
        level=score/10;
        //adding enemy to the stage randomly
        int wave=(50-2*level)<20?20:(50-2*level);
        if(timmer%wave==0){
        ft=new FoeFighter(800,100+(int) (Math.random()*400),(3+level)>10?10:(3+level),2+level/2);
        foeFighterArr.add(ft);
        stage.addRigidBody(ft.r);}
        //inc score when foe shot down
        for(FoeFighter f:foeFighterArr){
            if (f.hp<=0){
                f.destroyed();
                score++;
                ArrayList<FoeFighter> temp= (ArrayList<FoeFighter>) foeFighterArr.clone();
                temp.remove(f);
                foeFighterArr=temp;
            }

        }
        //movement for player fighter
        if(Math.abs(p.mouseX-pf.r.getX())>1){
        int mouseX=p.mouseX;
        int mouseY=p.mouseY;
        int posX=pf.r.getX()+30;
        int posY=pf.r.getY();
        //float slope= (float) Math.sqrt((mouseX-posX)*(mouseX-posX)+(mouseY-posY)*(mouseY-posY));
        pf.r.setVelocity(new PVector(maneuverability*maneuverLevel*(mouseX-posX),maneuverability*maneuverLevel*(mouseY-posY)));

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
//        if(bulletArr.size()>=1){
//        System.out.println(bulletArr.get(0).r.getColideBox().get(0).toString());}


    }
}
