/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import java.awt.Point;
import javafx.geometry.Rectangle2D;

/**
 *
 * @author timot
 */
public class Exit {
    
    private Rectangle2D bounds;
    private String nextScene;
    private double enterPointX;
    private double enterPointY;
    
    public Exit(double x, double y, String nextScene, double enterX, double enterY, boolean up)
    {
        if(up)
             bounds = new Rectangle2D(x, y, 32, 64);
        else
             bounds = new Rectangle2D(x, y, 64, 32);
        this.nextScene = nextScene;
        enterPointX = enterX;
        enterPointY = enterY;
    }
    
    public String getNextScene()
    {
        return nextScene;
    }
    
    public Rectangle2D getBounds()
    {
        return bounds;
    }
    
    public double getEnterX()
    {
        return enterPointX;
    }
    
    public double getEnterY()
    {
        return enterPointY;
    }
}
