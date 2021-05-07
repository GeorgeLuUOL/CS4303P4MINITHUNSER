package com.lu.uicomponent;

public interface UIComponent {
    int x = 0;
    int y = 0;
    boolean visable=true;

    public void draw();
    public void setVisable(Boolean b);
    public Boolean getVisable();
}
