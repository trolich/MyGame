/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import javafx.animation.AnimationTimer;

/**
 *
 * @author timot
 */
public class GamePlayLoop extends AnimationTimer {
    
    public MyGame myGame;
    GamePlayLoop(MyGame myGame)
    {
        this.myGame = myGame;
    }
    
    @Override
    public void handle(long now) {
        myGame.getHero().update();
        myGame.getAreaControl().update();
    }
    
    @Override
    public void start()
    {
        super.start();
    }
    
    @Override
    public void stop()
    {
        super.stop();
    }
    
}
