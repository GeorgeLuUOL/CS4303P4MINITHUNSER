package com.lu.programme;


import com.lu.flight.Background;
import com.lu.flight.GameController;
import com.lu.flight.PlayerFighter;
import com.lu.flight.StageForFlight;
import com.lu.uicomponent.Canvas;
import com.lu.uicomponent.Label;
import com.lu.uicomponent.UIComponent;
import processing.core.PApplet;


public class Main extends PApplet {

    public static PApplet processing;


    int r;
    Boolean start = true;
    StageForFlight stage;
    GameController flightGameController;
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
        flightGameController=new GameController();
        flightGameController.init();
        //build menu
        canvas=new Canvas();
        int[] color={249,255,31};
        Label label=new Label(200,200,"atest text",50);
        label.setColour(color);
        canvas.addComponent(label);





    }

    public void draw() {
        canvas.draw();
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

