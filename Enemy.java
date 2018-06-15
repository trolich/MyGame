/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import java.util.Random;
import javafx.scene.shape.Circle;

/**
 *
 * @author timot
 */
abstract class Enemy extends MovingSprite {
    protected Circle attackRadius;
    protected int moveSpeed;
    abstract protected void attack();
    abstract protected void setMoveSpeed();
    
    private void walkAround()
    {
       int moveX, moveY;
       
       moveX = moveSpeed * (chooseDirection());
       moveY = moveSpeed * (chooseDirection());
       
       translate(moveX,moveY);
    }
    
    private int chooseDirection()
    {
        Random ran = new Random();
        int randInt = ran.nextInt(3);
        int dir = 0;
        if(randInt == 0){ dir = -1;}
        else if(randInt == 1) {dir = 0;}
        else if(randInt == 2) {dir = 1;}
        
        return dir;
    }
}
