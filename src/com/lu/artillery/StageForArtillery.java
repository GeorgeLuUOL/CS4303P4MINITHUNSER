package com.lu.artillery;

import com.lu.gameobject.ColideBox;
import com.lu.gameobject.RigidBody;
import com.lu.gameobject.Stage;

public class StageForArtillery extends Stage {
    @Override
    public void handleCollision() {
        for (RigidBody r : container) {
            for (ColideBox c : colliderContainer) {
                //System.out.println(c.toString());
                if (c.getR() != r) {
                    for (ColideBox ColliderForR : r.getColideBox()) {
                        if (Math.abs(ColliderForR.getX() - c.getX()) <= Math.abs(ColliderForR.getWidth() + c.getWidth())
                                &&Math.abs(ColliderForR.getY() - c.getY()) <= Math.abs(ColliderForR.getHeight() + c.getHeight())) {

                            if(r.getApplyColision()==true){
                            r.onCollision(c.getR());
                            ColliderForR.setColision(true);

//                            if(r.getTag().equals("shell")){
//                                System.out.println("shell collision");
//                                r.trigger();
//                                if(c.getR().getTag().equals("tank")){
//                                    c.getR().trigger();
//                                }
//                                if(c.getR().getTag().equals("block")){
//                                    c.getR().trigger();
//                                }
//
//                               //super.removeRigidBody(r);
//                            }

                            //System.out.println("collision detected"+ColliderForR.getX()+" "+ColliderForR.getY()+" "+c.getX()+" "+c.getY());
                            //System.out.println(ColliderForR.getWidth()+" "+ColliderForR.getHeight());
                            }
                        }
                    }
                }
            }
        }
    }
}
