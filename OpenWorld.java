/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;
/**
 *
 * @author timot
 */
import java.util.ArrayList;
import java.util.Arrays;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public abstract class OpenWorld extends StackPane{
    
    protected Image background, bridgeH, bridgeV, brokenBridgeH, brokenBridgeV, trees1x4;
    protected ImageView backView;
    public ArrayList<Enemy> enemyList;
    public ArrayList<Bounds> boundaries;
    public ArrayList<Rectangle2D> waterBounds;
    public ArrayList<Exit> exitBounds;

    
    public OpenWorld()
    {
        bridgeH = new Image("/Bridge Hor.png");
        bridgeV = new Image("/Bridge Ver.png");
        brokenBridgeH = new Image("/Broken Bridge Hor.png");
        brokenBridgeV = new Image("/Broken Bridge Ver.png");
        trees1x4 = new Image("/Trees1x4.png");
        
        waterBounds = new ArrayList<Rectangle2D>();
        boundaries = new ArrayList<Bounds>();
        enemyList = new ArrayList<Enemy>();
        exitBounds = new ArrayList<Exit>();
    }
    
    
    //instantiate the image object for the main background
    abstract void createBackground();
    
    //Use this method to add houses, obstacles and the like
    abstract void addFeatures();
    
    //Use this method to add bounds to the openworld piece
    abstract void addBounds();
    
    abstract ArrayList<Bounds> getBounds();
    
    //Use this for adding water boundaries to the openworld
    abstract void addWaterBounds();
    
    abstract void setExitBounds();
    
    public ArrayList<Rectangle2D> getWaterBounds()
    {
        return waterBounds;
    }
        
    abstract void addEnemies(Enemy... enemies);
    
    protected ArrayList<Exit> getExitBounds()
    {
        return exitBounds;
    }
    
}
