package com.lu.uicomponent;

import com.lu.programme.StateController;

import java.util.ArrayList;

public class ButtonHandller {
    ArrayList<Button> buttonArr=new ArrayList(10);
    StateController stateController;

    public ButtonHandller(StateController sc){
        this.stateController=sc;
    }
}
