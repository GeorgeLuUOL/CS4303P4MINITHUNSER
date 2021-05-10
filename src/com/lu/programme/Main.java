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
    int stageLevel=1;
    int damageLevel=1;
    int maneuverLevel=1;
    StateController stateController;
    GameController flightGameController;
    ButtonHandller buttonHandller;
    Canvas canvas;
    Canvas canvasForGameOver;
    Canvas canvasForControl;


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
        flightGameController=new GameController(stageLevel,damageLevel,maneuverLevel);
        buttonHandller=new ButtonHandller(stateController);
        //flightGameController.init();
        //assign states
        stateController.addState(0,"menu");
        stateController.addState(1,"game");
        stateController.addState(2,"upgrade");
        stateController.addState(3,"control");
        stateController.addState(4,"gameOver");
        //create uniformed color theme
        //yellow
        int[] color={249,255,31};
        //brown
        int[] textColor={73,47,37};
        //build menu
        canvas=new Canvas();

        Label label=new Label(400,100,"MINI THUNDER",50);
        Panel defaultPanel=new Panel();
        label.setColour(textColor);
        Button start=new Button("Start",300,200,200,50);
        start.setSize(30);
        start.setColour(textColor);
        start.setBgColoor(color);
        start.setCurrState(0);
        start.setStateTrans(1);
        Button control=new Button("Control",300,500,200,50);
        control.setStateTrans(3);
        control.setSize(30);
        control.setCurrState(0);
        control.setColour(textColor);
        control.setBgColoor(color);
        canvas.addComponent(defaultPanel);
        canvas.addComponent(label);
        canvas.addComponent(start);
        canvas.addComponent(control);
        buttonHandller.addButton(start);
        buttonHandller.addButton(control);

        // build canvas for gameOver interface

        canvasForGameOver=new Canvas();
        label=new Label(400,100,"GAME OVER",50);
        label.setColour(textColor);
        Button backToMenu=new Button("Back To Menu",300,300,250,50){
            @Override
            public void trigger() {
                flightGameController=new GameController(stageLevel,damageLevel,maneuverLevel);
                //stateController.setCurrentState(0);
            }
        };
        backToMenu.setStateTrans(0);
        backToMenu.setCurrState(4);
        backToMenu.setSize(30);
        backToMenu.setColour(textColor);
        backToMenu.setBgColoor(color);
        canvasForGameOver.addComponent(defaultPanel);
        canvasForGameOver.addComponent(label);
        canvasForGameOver.addComponent(backToMenu);
        buttonHandller.addButton(backToMenu);
        //build canvas for control intro
        canvasForControl=new Canvas();
        label.setText("Control");
        Button back2menu=new Button("Back To Menu",270,400,250,50);
        back2menu.setCurrState(3);
        back2menu.setStateTrans(0);
        back2menu.setSize(30);
        back2menu.setColour(textColor);
        back2menu.setBgColoor(color);
        canvasForControl.addComponent(defaultPanel);
        canvasForControl.addComponent(label);
        canvasForControl.addComponent(back2menu);
        buttonHandller.addButton(back2menu);
        //init state
        stateController.setCurrentState(0);




    }

    public void draw() {
        buttonHandller.handle();
        //canvas.draw();

        switch (stateController.currentState.tag){
            case "menu":
                stateController.setCurrentState(0);
                canvas.draw();
                break;
            case "game":

                flightGameController.draw();
                //crate panel for info
                fill(210,210,210,100);
                rect(0,0,800,50);
                fill(1,255,255);
                textSize(20);
                text("Score: "+flightGameController.score,50,20);
                text("level: "+flightGameController.level,150,20);
                text("HP: ",230,20);
                fill(88,255,122);
                rect(250,10,5*flightGameController.hp,20);
                fill(1,255,255);
                text("damage: "+flightGameController.damageLevel,380,20);
                text("maneuverability: "+flightGameController.maneuverLevel,550,20);
                if(flightGameController.hp<=0){
                    stateController.setCurrentState(4);
                }
                break;
            case "control":
                canvasForControl.draw();
                fill(204,102,0);
                textSize(30);
                text("Use mouse cursor to move your plane",400,200);
                text("Click mouse left button to fire",400,250);
                text("Preventing foe reaching left edge or crashing ",400,300);
                text("Collecting boxes for upgrading  ",400,350);
                break;

            case "gameOver":
                canvasForGameOver.draw();
                textSize(50);
                text("Your Score: "+flightGameController.score,400,200);
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

