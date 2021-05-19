package com.lu.uicomponent;

import com.lu.programme.Main;
import com.lu.programme.StateController;
import processing.core.PApplet;

import java.util.ArrayList;

public class ButtonHandller {
    ArrayList<Button> buttonArr=new ArrayList(10);
    StateController stateController;
    PApplet p= Main.processing;
    int mouseX;
    int mouseY;

    public ButtonHandller(StateController sc){
        this.stateController=sc;
    }
    public void addButton(Button b){
        buttonArr.add(b);
    }
    public void handle(){
        mouseX=p.mouseX;
        mouseY=p.mouseY;
        //System.out.println(stateController.getCurrentState());
        for(Button b:buttonArr){
            if(b.x<=mouseX&&mouseX<=(b.x+b.width)
            &&b.y<=mouseY&&mouseY<=(b.y+b.height)
            &&stateController.getCurrentState()==b.getCurrState()){
                b.setHang(true);
                if(p.mousePressed&&p.mouseButton==37){
                    stateController.setCurrentState(b.stateTrans);
                    b.trigger();
                }
            }
            else {
                b.setHang(false);
            }

        }
    }
}
