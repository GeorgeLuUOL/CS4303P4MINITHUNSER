package com.lu.uicomponent;

import com.lu.programme.Main;
import processing.core.PApplet;

import java.util.ArrayList;

public class Canvas {
    PApplet p = Main.processing;
    ArrayList<UIComponent> container = new ArrayList<>(100);

    public void addComponent(UIComponent component) {
        container.add(component);
    }

    public void draw() {
        for (UIComponent c : container) {
            if (c.getVisable() == true) {
                //p.pushMatrix();
                c.draw();
                //p.popMatrix();
            }

        }
    }
}
