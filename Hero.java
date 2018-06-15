/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author timot
 */
public class Hero extends MovingSprite{
    private Image hero0, hero1, hero2, hero3, swim0, swim13, swim2; 
    private Image drowning, drowning1, drowning2, drowning3;
    private Image left0, left1, left2, left3, right0, right1, right2, right3;
    private Image up0, up1, up2, up3, down0, down1, down2, down3;
    private Image downattack0, downattack1, downattack2, downattack3;
    private MyGame myGame;
    private Rectangle active;
    private double actX,actY;
    
   
    
    public Hero(MyGame myGame)
    {
        moveSpeed = 5;
        health = 1000;
        damage = 10;
        x = -600;
        y =-500;
        actX = x; actY = y + 16;
        animatorSpeed = 5;
        facingUp = facingRight = facingLeft = inWater = attacking = false;
        moveRight = moveLeft = moveDown = moveUp = canMove = true;
        canSwim = true;
        facingDown = true;
        this.myGame = myGame;
        active = new Rectangle(actX,actY,32,32);
        active.setFill(Paint.valueOf("transparent"));
        createImages();
        view.setImage(drowning);
    }
    
    @Override
    public void update()
    {
        move();
        translate(x, y);
        setSpriteFrame();
        setDirection();
    }
    
    @Override
    protected final void createImages()
    {
        hero0 = new Image("/knight forward.png");
        hero1 = new Image("/knight up.png");
        hero2 = new Image("/Knight left.png");
        hero3 = new Image("/Knight right.png");
        
        left0 = new Image("/left step 0.png");
        left1 = new Image("/left step 1.png");
        left2 = new Image("/left step 2.png");
        left3 = new Image("/left step 3.png");
        
        right0 = new Image("/right step 0.png");
        right1 = new Image("/right step 1.png");
        right2 = new Image("/right step 2.png");
        right3 = new Image("/right step 3.png");
        
        up0 = new Image("/up step 0.png");
        up1 = new Image("/up step 1.png");
        up2 = new Image("/up step 2.png");
        up3 = new Image("/up step 3.png");
        
        down0 = new Image("/down step 0.png");
        down1 = new Image("/down step 1.png");
        down2 = new Image("/down step 2.png");
        down3 = new Image("/down step 3.png");
        downattack0 = new Image("/down attack 0.png");
        downattack1 = new Image("/down attack 1.png");
        downattack2 = new Image("/down attack 2.png");
        downattack3 = new Image("/down attack 3.png");
        
        
        swim0 = new Image("/swim0.png");
        swim13 = new Image("/swim1-3.png");
        swim2 = new Image("/swim2.png");
        
        drowning = new Image("/Drowning.png");
        drowning1 = new Image("/Drowning1.png");
        drowning2 = new Image("/Drowning2.png");
        drowning3 = new Image("/Drowning3.png");
        
        
    }
    
    @Override
    protected void move()
    {
        if(canMove)
        {
            if(myGame.isRight() && moveRight)
            {
                x += moveSpeed;
            }
            if(myGame.isLeft() && moveLeft)
            {
                x -= moveSpeed;
            }
            if(myGame.isUp() && moveUp)
            {
                y -= moveSpeed;
            }
            if(myGame.isDown() && moveDown)
            {
                y += moveSpeed;
            }
        }
    }
    
    @Override
    protected void setSpriteFrame()
    {
        if(inWater)
        {
            if(!canSwim)
            {
                view.setImage(drowning);
                animate.activeAnimate(drowning, drowning1, drowning2, drowning3, animatorSpeed);
                drown();
            } 
            else if(canSwim)
            {
                if((myGame.isUp() && !myGame.isRight() && !myGame.isLeft() && !myGame.isDown()) 
                || (myGame.isUp() && myGame.isRight() && myGame.isLeft()))
                {
                    view.setRotate(0);
                    animate.activeAnimate(swim0, swim13, swim2, animatorSpeed);
                }
                else if(myGame.isDown() && !myGame.isRight() && !myGame.isLeft() && !myGame.isUp())
                {
                    view.setRotate(180);
                    animate.activeAnimate(swim0, swim13, swim2, animatorSpeed);
                }
                else if(myGame.isLeft() && !myGame.isRight())
                {
                    view.setRotate(270);
                    animate.activeAnimate(swim0, swim13, swim2, animatorSpeed);
                }
                else if(myGame.isRight() && !myGame.isLeft())
                {
                    view.setRotate(90);
                    animate.activeAnimate(swim0, swim13, swim2, animatorSpeed);
                }
                else if(!myGame.isUp() && !myGame.isDown() && !myGame.isRight() && !myGame.isLeft())
                {
                    view.setImage(swim0);
                }
            }
        }
        else if(!inWater)
        {
            if(myGame.isAttacking())
            {
                attacking = true;
                canMove = false;
                animate.activeAnimate(downattack0, downattack1, downattack2, downattack3, 5);
            }
            else if(!myGame.isAttacking())
            {
                attacking = false;
                canMove = true;
                if((myGame.isUp() && !myGame.isRight() && !myGame.isLeft() && !myGame.isDown()) 
                        || (myGame.isUp() && myGame.isRight() && myGame.isLeft()))
                {            
                    view.setRotate(0);
                    animate.activeAnimate(up0, up1, up2, up3, animatorSpeed);
                }
                else if(myGame.isDown() && !myGame.isRight() && !myGame.isLeft() && !myGame.isUp())
                {            
                    view.setRotate(0);
                    animate.activeAnimate(down0, down1, down2, down3, animatorSpeed);
                }
                if(myGame.isLeft() && ! myGame.isRight())
                {  
                    view.setRotate(0);
                    animate.activeAnimate(left0, left1, left2, left3, animatorSpeed);
                }
                if(myGame.isRight() && !myGame.isLeft())
                {   
                    view.setRotate(0);
                    animate.activeAnimate(right0, right1, right2, right3, animatorSpeed);
                }
                else if(!myGame.isUp() && !myGame.isDown() && !myGame.isRight() && !myGame.isLeft())
                {
                    if(facingUp)
                    {
                        view.setImage(hero1);
                    }
                    else if(facingDown)
                    {
                        view.setImage(hero0);
                    }
                    else if(facingRight)
                    {
                        view.setImage(hero3);
                    }
                    else if(facingLeft)
                    {
                        view.setImage(hero2);
                    }
                }
            }
        }
    }
    
    private void setDirection()
    {
        if(myGame.isDown()) {
            facingDown = true;
            facingUp = false;
            actX = x; actY = y + 16;
        }
        else
            facingDown = false;

        if(myGame.isUp()){
            facingUp = true;
            facingDown = false;
            actX = x; actY = y - 16;
        }
        else
            facingUp = false;

        if(myGame.isRight()){
            facingRight = true;
            facingLeft = false;
            actX = x + 16; actY = y;
        }
        else
            facingRight = false;

        if(myGame.isLeft()){
            facingLeft = true;
            facingRight = false;
            actX = x - 16; actY = y;
        }
        else
            facingLeft = false;
        active.setTranslateX(actX);
        active.setTranslateY(actY);
    }
    
    private void drown()
    {
        if((facingUp && !facingRight && !facingLeft && !facingDown) || (facingUp && facingRight && facingLeft))
        {
            y += 32;
            translate(x, y);
        }
        else if(facingRight && !facingUp && !facingDown && !facingLeft)
        {
            x -= 32;
            translate(x, y);
        }
        else if(facingLeft && !facingUp && !facingDown && !facingRight)
        {
            x += 32;
            translate(x, y);
        }
        else if(facingDown && !facingRight && !facingLeft && !facingUp)
        {
            y -= 32;
            translate(x, y);
        }
        else if(facingRight && facingUp)
        {
            x -= 32;
            y += 32;
            translate(x, y);
        }
        else if(facingRight && facingDown)
        {
            x -= 32;
            y -= 32;
            translate(x, y);
        }
        else if(facingLeft && facingUp)
        {
            x += 32;
            y += 32;
            translate(x, y);
        }
        else if(facingLeft && facingDown)
        {
            x += 32;
            y -= 32;
            translate(x, y);
        }
        takeDamage(5);
    }
    
    public Rectangle getActive()
    {
        return active;
    }
   
}
