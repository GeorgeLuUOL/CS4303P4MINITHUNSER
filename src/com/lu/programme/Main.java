package com.lu.programme;


import com.lu.flight.Background;
import com.lu.flight.GameController;
import com.lu.flight.PlayerFighter;
import com.lu.flight.StageForFlight;
import com.lu.uicomponent.*;
import processing.core.PApplet;


public class Main extends PApplet {

    public static PApplet processing;


    int r;
    StateController stateController;
    GameController flightGameController;
    ButtonHandller buttonHandller;
    Canvas canvas;


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
        stateController=new StateController();
        flightGameController=new GameController();
        buttonHandller=new ButtonHandller(stateController);
        flightGameController.init();
        //assign states
        stateController.addState(0,"menu");
        stateController.addState(1,"game");
        stateController.addState(2,"upgrade");
        stateController.addState(3,"control");
        stateController.addState(4,"gameOver");
        //build menu
        canvas=new Canvas();
        //yellow
        int[] color={249,255,31};
        //brown
        int[] textColor={73,47,37};
        Label label=new Label(400,100,"MINI THUNDER",50);
        label.setColour(textColor);
        Button start=new Button("Start",300,200,200,50);
        start.setSize(30);
        start.setColour(textColor);
        start.setBgColoor(color);
        start.setStateTrans(1);
        Button control=new Button("Control",300,300,200,50);
        control.setStateTrans(3);
        control.setSize(30);
        control.setColour(textColor);
        control.setBgColoor(color);
        canvas.addComponent(label);
        canvas.addComponent(start);
        canvas.addComponent(control);
        buttonHandller.addButton(start);
        buttonHandller.addButton(control);

        //init state
        stateController.setCurrentState(0);




    }

    public void draw() {
        buttonHandller.handle();
        //canvas.draw();

        switch (stateController.currentState.tag){
            case "menu":
                canvas.draw();
                break;
            case "game":
                flightGameController.draw();
                break;


        }
       //flightGameController.draw();
      


    }


    public void keyPressed() {

    }

    public void keyReleased() {


    }
    public void mousePressed(){
//        if(mouseButton==LEFT){
//            System.out.println("left button pressed");
//        }
    }

    public static void main(String... args) {
        PApplet.main("com.lu.programme.Main", args);
    }

}

