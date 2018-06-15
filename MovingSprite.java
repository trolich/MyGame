/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import javafx.scene.image.ImageView;

/**
 *
 * @author timot
 */
abstract class MovingSprite {
    protected double x, y;
    protected ImageView view;
    protected int animatorSpeed, health, damage;
    protected boolean moveRight, moveLeft, moveUp, moveDown, canMove;
    protected boolean facingLeft, facingRight, facingUp, facingDown, inWater, canSwim;
    protected boolean attacking;
    protected double moveSpeed;
    protected Animator animate;
    
    abstract protected void createImages();
    abstract protected void setSpriteFrame();
    abstract void update();
    abstract protected void move();
    
    
    public MovingSprite()
    {
        view = new ImageView();
        animate = new Animator(view);
    }
    
    protected void translate(double x, double y)
    {
        view.setTranslateX(x);
        view.setX(x);
        view.setTranslateY(y);
        view.setY(y);
    }
    
    protected void takeDamage(int damage)
    {
        health -= damage;
    }
    
    public double getX()
    {
        return view.getX();
    }
    
    public double getY()
    {
        return view.getY();
    }
    
    public void setCanSwim(boolean swim)
    {
        canSwim = swim;
    }
    
    public void setInWater(boolean in)
    {
        inWater = in;
    }
    
    public ImageView getView()
    {
        return view;
    }
    
    public void setX(double newX)
    {
        x = newX;
    }
    
    public void setY(double newY)
    {
        y = newY;
    }
    
    public void setMoveRight(boolean right)
    {
        moveRight = right;
    }
    
    public void setMoveLeft(boolean left)
    {
        moveLeft = left;
    }
    
    public void setMoveDown(boolean down)
    {
        moveDown = down;
    }
    
    public void setMoveUp(boolean up)
    {
        moveUp = up;
    }
}
