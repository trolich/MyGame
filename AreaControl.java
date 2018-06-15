/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.ScrollPane;

/**
 *
 * @author timot
 */
public class AreaControl {
    OpenWorld currentArea;
    Town town;
    Field field;
    Hero hero;
    ScrollPane pane;
    private int OFFSETX, OFFSETY;
    
    public AreaControl(Hero hero)
    {
        this.hero = hero;
        OFFSETX = 2560;
        OFFSETY = 1920;
        buildScenes();
        currentArea = town;
        currentArea.getChildren().add(hero.getView());
        currentArea.getChildren().add(hero.getActive());
        buildPane();
    }
    
    public void update()
    {
        hero.setInWater(inWater());
        checkExits();
        checkRight();
        checkLeft();
        checkUp();
        checkDown();
        setScroll();
    }
    
    private void buildScenes()
    {
        town = new Town();
        field = new Field();
    }
    
    private void buildPane()
    {
        pane = new ScrollPane();
        pane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        pane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        pane.setPannable(false);
        pane.setHmin(0);
        pane.setHmax(5120);
        pane.setHvalue(2560);
        pane.setVmin(0);
        pane.setVmax(3840);
        pane.setVvalue(1920);
        pane.setContent(currentArea);
    }
    
    private void setScroll()
    {
        pane.setHvalue(hero.getX() * 2.61 + OFFSETX);
        pane.setVvalue(hero.getY() * 2.61 + OFFSETY);
    }
    
    public boolean inWater()
    {
        boolean inWater = false;
        for (Rectangle2D waterBound : currentArea.getWaterBounds()) {
            if(waterBound.contains(hero.getX(), hero.getY()))
            {
                inWater = true;
                break;
            }
            else
                inWater = false;
        }
        return inWater;
    }
    
    public void checkExits()
    {
        for (Exit exit : currentArea.getExitBounds())
        {
            if (exit.getBounds().contains(hero.getX(), hero.getY()))
            {
                currentArea.getChildren().remove(hero.getView());
                switch(exit.getNextScene())
                {
                    case "Grass Area": pane.setContent(field); 
                        currentArea = field;
                        currentArea.getChildren().add(hero.getView());
                        break;
                    case "Town": pane.setContent(town);
                        currentArea = town;
                        currentArea.getChildren().add(hero.getView());
                        break;
                    //case "Snow Area" ...
                }
                hero.setX(exit.getEnterX());
                hero.setY(exit.getEnterY());
            }
        }
    }
    
    private void checkRight()
    {
        boolean move = true;
        for(Bounds bound : currentArea.getBounds())
        {
            if(hero.getX() <= (bound.getMaxX() - bound.getWidth()/2)
            && (hero.getX() >= (bound.getMinX() - bound.getWidth()/2 - 4))
            && (hero.getY() <= (bound.getMaxY() - bound.getHeight()/2))
            && (hero.getY() >= (bound.getMinY() - bound.getHeight()/2)))
            {
                move = false;
            }
            else
            {
                move = true;
            }
        }
        hero.setMoveRight(move);
    }
    
    private void checkLeft()
    {
        boolean move = true;
        for(Bounds bound : currentArea.getBounds())
        {
            if(hero.getX() <= (bound.getMaxX() - bound.getWidth()/2 + 4)
            && (hero.getX() >= (bound.getMinX() - bound.getWidth()/2))
            && (hero.getY() <= (bound.getMaxY() - bound.getHeight()/2))
            && (hero.getY() >= (bound.getMinY() - bound.getHeight()/2)))
            {
                move = false;
            }
            else
            {
                move = true;
            }
        }
        hero.setMoveLeft(move);
    }
    
    private void checkUp()
    {
         boolean move = true;
        for(Bounds bound : currentArea.getBounds())
        {
            if(hero.getX() <= (bound.getMaxX() - bound.getWidth()/2)
            && (hero.getX() >= (bound.getMinX() - bound.getWidth()/2))
            && (hero.getY() <= (bound.getMaxY() - bound.getHeight()/2 + 4))
            && (hero.getY() >= (bound.getMinY() - bound.getHeight()/2)))
            {
                move = false;
            }
            else
            {
                move = true;
            }
        }
        hero.setMoveUp(move);
    }
    
    private void checkDown()
    {
         boolean move = true;
        for(Bounds bound : currentArea.getBounds())
        {
            if(hero.getX() <= (bound.getMaxX() - bound.getWidth()/2)
            && (hero.getX() >= (bound.getMinX() - bound.getWidth()/2))
            && (hero.getY() <= (bound.getMaxY() - bound.getHeight()/2))
            && (hero.getY() >= (bound.getMinY() - bound.getHeight()/2 - 4)))
            {
                move = false;
            }
            else
            {
                move = true;
            }
        }
        hero.setMoveDown(move);
    }
    
    public ScrollPane getPane()
    {
        return pane;
    }
    
}
