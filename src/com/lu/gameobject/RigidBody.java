package com.lu.gameobject;


import processing.core.PApplet;
import processing.core.PVector;

import com.lu.programme.Main;
import java.util.ArrayList;

public class RigidBody {
    static final double G = 9.8;
    static final double ACCELERATION_GAME_PAREMETER = 0.1;
    static final double DEFAULT_MASS = 1;
    private double mass = DEFAULT_MASS;
    PVector velocity;
    PVector acceleration;
    Texture texture;
    ArrayList<ColideBox> colideBox=new ArrayList<ColideBox>();
    PApplet p = Main.processing;
    private double gravity = G * ACCELERATION_GAME_PAREMETER;
    private Boolean applyGravity = true;
    private Boolean applyColision = true;
    private Stage stage;
    private String tag="";
    private Boolean trigger=false;

    public boolean onCollisioin(){

        //System.out.println("collision detected");
        return true;
    }
    public void onCollision(RigidBody r){

    }

    public void trigger(){
        this.trigger=true;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public Boolean getApplyGravity() {
        return applyGravity;
    }

    public void setApplyGravity(Boolean applyGravity) {
        this.applyGravity = applyGravity;
    }


    public RigidBody(Texture texture) {
        this.texture = texture;
        this.velocity = new PVector(0, 0);
        this.acceleration = new PVector(0, 0);
    }

    public RigidBody(double mass, Texture texture) {
        this.mass = mass;
        this.texture = texture;
        this.velocity = new PVector(0, 0);
        this.acceleration = new PVector(0, 0);
    }

    public void draw() {
        this.texture.draw();
        this.texture.move(velocity);
        velocity.x += acceleration.x;
        velocity.y += acceleration.y;
        if(applyGravity==true){
        velocity.y += gravity;}
        //updating collide box
        for(ColideBox c:colideBox){
            c.setX(this.getX()+c.getWidth());
            c.setY(this.getY()+c.getHeight());
        }
    }
    public void rotate(int angle){
        this.texture.setAngle(angle);
    }

    public PVector getVelocity() {
        return velocity;
    }

    public Boolean getTrigger() {
        return trigger;
    }

    public void setTrigger(Boolean trigger) {
        this.trigger = trigger;
    }

    public void setVelocity(PVector velocity) {
        this.velocity = velocity;
    }

    public PVector getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(PVector acceleration) {
        this.acceleration = acceleration;
    }

    public void setColideBox(ArrayList<ColideBox> colideBox) {
        this.colideBox = colideBox;
    }

    public Texture getTexture() {
        return texture;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Boolean getApplyColision() {
        return applyColision;
    }

    public void setApplyColision(Boolean applyColision) {
        this.applyColision = applyColision;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public ArrayList<ColideBox> getColideBox() {
        return colideBox;
    }

    public void addColideBox(ColideBox colideBox) {
        this.colideBox.add(colideBox);
    }

    public PApplet getP() {
        return p;
    }

    public void setP(PApplet p) {
        this.p = p;
    }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double gravity) {
        this.gravity = gravity;
    }
    public int getX(){
        return this.texture.getX();
    }
    public int getY(){
        return this.texture.getY();
    }
    public void setX(int x){
        this.texture.setX(x);
    }
    public void setY(int y){
        this.texture.setY(y);
    }
}
