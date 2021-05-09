package com.lu.uicomponent;

import com.lu.gameobject.Texture;
import com.lu.programme.Main;
import processing.core.PApplet;

public class Panel implements UIComponent {
    boolean visable=true;
    Texture texture;
    PApplet p = Main.processing;

    public Panel() {
    }

    @Override
    public void draw() {
        p.fill(230, 230, 230);
        p.rect(0,0,800,600);

    }



    @Override
    public void setVisable(Boolean b) {
        this.visable = visable;
    }

    @Override
    public Boolean getVisable() {
        return this.visable;
    }
}
