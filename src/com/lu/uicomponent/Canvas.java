package com.lu.uicomponent;

import java.util.ArrayList;

public class Canvas {
    ArrayList<UIComponent> container=new ArrayList<>(100);

    public void addComponent(UIComponent component){
        container.add(component);
    }
    public void draw(){
        for (UIComponent c:container){
            if(c.getVisable()==true){
            c.draw();}
        }
    }
}
