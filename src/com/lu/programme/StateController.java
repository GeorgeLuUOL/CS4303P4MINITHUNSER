package com.lu.programme;

import java.util.HashMap;

public class StateController {
    State currentState;
    HashMap<Integer,State> stateMap=new HashMap<>();

    public void addState(int number, String tag){
        State s=new State(number,tag);
        stateMap.put(number,s);
    }

    public int getCurrentState() {
        return currentState.getNumber();
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public void setCurrentState(int s){
        this.currentState=stateMap.get(s);
    }
}
class State{
    int number;
    String tag;

    public State(int number, String tag) {
        this.number = number;
        this.tag = tag;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
