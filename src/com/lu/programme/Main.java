package com.lu.programme;


import com.lu.flight.Background;
import processing.core.PApplet;

import com.lu.artillery.GameController;


public class Main extends PApplet {

    public static PApplet processing;


    int r;
    Boolean start = true;
    GameController flightGameController;
    Background bg;

    public void settings() {
        //fullScreen();
        size(800, 600);
        //fullScreen();
        r = 0;
    }

    @Override
    //call before running

    public void setup() {


        processing = this;
        flightGameController = new GameController();
        bg = new Background();

    }

    public void draw() {
        bg.draw();


    }


    public void keyPressed() {

    }

    public void keyReleased() {


    }

    public static void main(String... args) {
        PApplet.main("com.lu.programme.Main", args);
    }

}

