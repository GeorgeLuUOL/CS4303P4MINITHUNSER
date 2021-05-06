package com.lu.artillery;

import com.lu.programme.Main;
import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class GameController {
    GameController g;
    PApplet p = Main.processing;
    int timer = 180;
    public int turn = 0;

    public int[] wind = {0, 0};
    StageForArtillery stage;
    public Shell shell;
    public Shell shell2;
    Terrain terrain;
    Tank tank1;
    Tank tank2;
    Arrow arrow_angle;
    Arrow arrow_thrust;
    public Boolean winning = false;
    public Boolean lose = false;
    public Boolean useAI = false;

    ArrayList<Block> blockArr = new ArrayList<>();
    Block block1;
    Block block2;

    public int angle = 0;
    public float scale = 1f;

    public void init() {
        winning = false;
        lose = false;
        blockArr = new ArrayList<>();
        arrow_angle = new Arrow(0, 0, 1);
        arrow_thrust = new Arrow(30, 100, 2);
        stage = new StageForArtillery();
        terrain = new Terrain();

        block1 = new Block(500, 700, 50, 50);
        block2 = new Block(500, 600, 50, 50);

        for (int i = 0; i < 30; i++) {
            Block b = new Block(500 + (int) (Math.random() * 600), 500 + (int) (Math.random() * 275), 50, 50);
            blockArr.add(b);
        }

        tank1 = new Tank(100, 750, 1);
        tank2 = new Tank(1400, 750, 2);
        stage.addRigidBody(terrain.r);

        for (Block b : blockArr) {
            stage.addRigidBody(b.r);
        }

        stage.addRigidBody(tank1.r);
        stage.addRigidBody(tank2.r);
        stage.addRigidBody(arrow_angle.r);

        stage.addRigidBody(arrow_thrust.r);


    }

    public GameController() {

        init();

    }

    public void draw() {
        stage.draw();

        //assign random wind speed


        for (Block b : blockArr) {
            if (b.r.getY() >= 775) {
                b.r.setVelocity(new PVector(0, 0));
            }
            //System.out.println(b.r.getColideBox().get(0).toString());
            if (b.r.getTrigger() == true) {
                b.destroy();
            }
        }

        if (shell != null) {
            shell.burn();
            if (shell.getFuse() < 0) {
                shell.getR().setApplyColision(true);
            }
        }
        if (shell != null && (shell.r.getY() > 810)) {
            shell.explode();
            shell = null;
        }
        if (shell != null && shell.r.getTrigger() == true) {
            shell.explode();
            shell = null;
        }
        if (shell2 != null) {
            shell2.burn();
            if (shell2.getFuse() < 0) {
                shell2.getR().setApplyColision(true);
            }
        }
        if (shell2 != null && (shell2.r.getY() > 810)) {
            shell2.explode();
            shell2 = null;
        }
        if (shell2 != null && shell2.r.getTrigger() == true) {
            shell2.explode();
            shell2 = null;
        }
        if (tank1.r.getTrigger() == true) {
            tank1.destroy();
            tank2.destroy();
            lose = true;
        }
        if (tank2.r.getTrigger() == true) {
            tank2.destroy();
            tank1.destroy();
            winning = true;
        }

        arrow_angle.rotate(-angle);
        if (turn == 0) {
            arrow_angle.setPos(tank1.r.getX(), tank1.r.getY());
        } else if (turn == 1) {
            arrow_angle.setPos(tank2.r.getX(), tank2.r.getY());
        }
        arrow_thrust.setScale(scale);
        //primitive AI
        if (winning == false && lose == false && shell2 == null && timer <= 0 && turn == 1 && timer % 120 == 0 && useAI == true) {
            fire_r((int) (20 + 40 * Math.random()), 90 + (int) (90 * Math.random()));

            timer = 180;
        }
        if (timer % 30 == 0 && turn == 1 && useAI == true) {
            if ((Math.random() * 100) >= 50 && tank2.r.getX() < 1400) {
                tank2.moveRight();
            } else {
                tank2.moveLeft();
            }
        }


        timer--;
    }

    public void moveTankLeft_l() {
        this.tank1.moveLeft();
    }

    public void moveTankRight_l() {
        this.tank1.moveRight();
    }

    public void stopTank_l() {
        this.tank1.stop();
    }

    public void moveTankLeft_r() {
        this.tank2.moveLeft();
    }

    public void moveTankRight_r() {
        this.tank2.moveRight();
    }

    public void stopTank_r() {
        this.tank2.stop();
    }

    public void fire_l(int thrust, int angle) {
        shell = new Shell(tank1.r.getX() + 50, tank1.r.getY() + 30, thrust, angle, wind[1]);
        stage.addRigidBody(shell.getR());
        turn = 1;

        wind[0] = (int) (Math.random() * 2);
        wind[1] = (int) (Math.random() * 100 * (wind[0] == 1 ? 1 : -1));
        this.angle = 180 - angle;
    }

    public void fire_r(int thrust, int angle) {
        shell2 = new Shell(tank2.r.getX() + 50, tank2.r.getY() + 30, thrust, angle, wind[1]);
        stage.addRigidBody(shell2.getR());
        turn = 0;
        wind[0] = (int) (Math.random() * 2);
        wind[1] = (int) (Math.random() * 100 * (wind[0] == 1 ? 1 : -1));
        this.angle = 180 - angle;
    }
}
