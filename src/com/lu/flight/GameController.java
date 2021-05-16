package com.lu.flight;

import com.lu.programme.Main;
import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class GameController {
    int timmer = 0;
    public int level;
    public int damageLevel;
    public int maneuverLevel;
    public int hp = 1;
    public int score = 0;
    PApplet p = Main.processing;
    StageForFlight stage = new StageForFlight();
    ;
    Background bg;
    PlayerFighter pf;
    ArrayList<Bullet> bulletArr = new ArrayList(50);
    ArrayList<FoeBullet> foeBulletArr = new ArrayList(50);
    ArrayList<FoeFighter> foeFighterArr = new ArrayList<>(50);
    ArrayList<Box> boxArr = new ArrayList<>(20);
    FoeFighter ft;
    Box b;
    //attribution for game
    float maneuverability = 0.1f;

    public GameController(int level, int damageLevel, int maneuverLevel) {
        init(level, damageLevel, maneuverLevel);
    }


    public void init(int level, int damageLevel, int maneuverLevel) {
        this.level = level;
        this.damageLevel = damageLevel;
        this.maneuverLevel = maneuverLevel;
        //b=new Box(800,100,1);
        bg = new Background();
        pf = new PlayerFighter();
        stage.addRigidBody(bg.r);
       // stage.addRigidBody(b.r);
        stage.addRigidBody(pf.r);
        //ft=new FoeFighter(800,300,1,1+level/2);
        //stage.addRigidBody(ft.r);
    }

    public void draw() {
        //System.out.println(stage.size());
        //update time
        timmer++;
        this.hp = pf.hp;
        //draw
        this.stage.draw();
        if (bg.r.getX() <= -800) {
            bg.r.setX(0);
        }
        level = score / 10;
        //adding box randomly
        if (timmer % 150 == 0) {
            double r1=Math.random();
            if (r1 <= 0.2) {

                double r=  Math.random();
                if (r < 0.5) {
                    System.out.println("---------11-");
                    b=new Box(800,0 + (int) (Math.random() * 200),1);
                    stage.addRigidBody(b.r);
                    System.out.println("seems added");
                    boxArr.add(b);

                }
                else if(r>=0.5&&r<=0.75){
                    System.out.println("---------22-");
                    b=new Box(800,0 + (int) (Math.random() * 200),2);
                    stage.addRigidBody(b.r);
                    System.out.println("seems added");
                    boxArr.add(b);

                }
                else if(r>=0.75 ){
                    System.out.println("---------33-");
                   b=new Box(800,0 + (int) (Math.random() * 200),3);
                    stage.addRigidBody(b.r);
                    System.out.println("seems added");
                    boxArr.add(b);
                }

            }
        }
        //adding enemy to the stage randomly
        int wave = (50 - 2 * level) < 20 ? 20 : (50 - 2 * level);
        if (timmer % wave == 0) {
            if(Math.random()<0.1){
                ft = new FoeFighter(800, 100 + (int) (Math.random() * 400), (3 + level) > 10 ? 10 : (3 + level), 2 + level / 2,true);
            }
            else{
            ft = new FoeFighter(800, 100 + (int) (Math.random() * 400), (3 + level) > 10 ? 10 : (3 + level), 2 + level / 2);}
            ft.damageTaken=damageLevel;
            foeFighterArr.add(ft);
            stage.addRigidBody(ft.r);

        }
        //boss can fire at player
        if(timmer%20==0){
        for (FoeFighter f : foeFighterArr){
            if(f.boss){
                double rad=  Math.atan2(f.r.getY()-pf.r.getY(),pf.r.getX()-f.r.getX());
                int angle= (int)Math.toDegrees(rad);
                System.out.println(angle);
                FoeBullet fb=new FoeBullet(f.r.getX(),f.r.getY()+50,angle);
                foeBulletArr.add(fb);
                stage.addRigidBody(fb.r);
            }
        }}
        //inc score when foe shot down
        //dec hp if foe pass the line
        for (FoeFighter f : foeFighterArr) {
            if(f.r.getX()<=0){
                f.destroyed();
                pf.hp--;
                ArrayList<FoeFighter> temp = (ArrayList<FoeFighter>) foeFighterArr.clone();
                temp.remove(f);
                foeFighterArr = temp;
            }
            if (f.hp <= 0) {
                f.destroyed();
                score++;
                ArrayList<FoeFighter> temp = (ArrayList<FoeFighter>) foeFighterArr.clone();
                temp.remove(f);
                foeFighterArr = temp;
            }

        }
        //handle box collection
        for (Box b : boxArr) {
            if (b.collected == true) {
                if (b.type == 1) {
                    pf.hp = 10;
                } else if (b.type == 2) {
                    damageLevel++;
                } else if (b.type == 3) {
                    maneuverLevel +=1;
                }
                b.destory();
                ArrayList<Box> temp = (ArrayList<Box>) boxArr.clone();
                temp.remove(b);
                boxArr = temp;
            }


        }
        //movement for player fighter
        if (Math.abs(p.mouseX - pf.r.getX()) > 1) {
            int mouseX = p.mouseX;
            int mouseY = p.mouseY;
            int posX = pf.r.getX() + 30;
            int posY = pf.r.getY();
            //float slope= (float) Math.sqrt((mouseX-posX)*(mouseX-posX)+(mouseY-posY)*(mouseY-posY));
            pf.r.setVelocity(new PVector(maneuverability * maneuverLevel * (mouseX - posX), maneuverability * maneuverLevel * (mouseY - posY)));

        }
        //fire
        if (p.mouseButton == 37) {
            //System.out.println("left button pressed");
            if (timmer % 2 == 0) {
                Bullet b = new Bullet(pf.r.getX() + 90, pf.r.getY() + 30, 0);
                bulletArr.add(b);
                stage.addRigidBody(b.r);
            }
        }
        //gc
        //for bullet
        for (Bullet b : bulletArr) {
            if (b.r.getX() > 800) {
                b.explode();
            }
        }
        if (timmer % 60 == 0) {
            bulletArr = new ArrayList<>();
            stage.gc("bullet");
        }
        for (FoeBullet b : foeBulletArr) {
            if (b.r.getX() < 0) {
                b.explode();
            }
        }
        if (timmer % 60 == 0) {
            foeBulletArr = new ArrayList<>();
            stage.gc("foeBullet");
        }

        //show collider
//        if(bulletArr.size()>=1){
//        System.out.println(bulletArr.get(0).r.getColideBox().get(0).toString());}


    }
}
