package com.lu.flight;

import com.lu.gameobject.RigidBody;
import com.lu.gameobject.Stage;

public class StageForFlight extends Stage {

    //garbage collection
    public int size(){
        return this.container.size();
    }
    public void gc(String tag){
    for (RigidBody r:container){
        if(r.getTag().equals("bullet")&&r.getX()>900){
            this.removeRigidBody(r);
        }
    }
    }
}
