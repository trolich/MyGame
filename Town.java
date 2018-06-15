/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import java.util.ArrayList;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author timot
 */
public class Town extends OpenWorld{
    
    private Rectangle2D water0, water1, water2, water3, water4, water5, water6, water7, water8, water9, water10, water11;
    private Rectangle2D water12, water13, water14, water15, water16, water17, water18, water19, water20;
    private Rectangle2D water21, water22, water23, water24, water25, water26;
    private Rectangle2D underBridge0, underBridge1, underBridge2, underBridge3;
    private Exit snowArea, rockArea, grassArea, desertArea, waterArea;
    private ImageView bridge0, bridge1, bridge2, bridge3;
    private ImageView trees0;
   
    
    public Town()
    {
        setPrefSize(3235, 2265); //Width + 675, Height + 365
        setWidth(USE_PREF_SIZE);
        setHeight(USE_PREF_SIZE);
        createBackground();
        addWaterBounds();
        setExitBounds();
        addFeatures();
        addBounds();
    }
    
    
    @Override
    public final void createBackground()
    {
        background = new Image("/Center Area.png");
        backView = new ImageView(background);
        getChildren().add(backView);
    }
    
    @Override
    protected final void addFeatures()
    {
        bridge0 = new ImageView(bridgeH);
        bridge0.setTranslateX(-192);
        bridge0.setTranslateY(-256);
        
        bridge1 = new ImageView(bridgeH);
        bridge1.setTranslateX(-704);
        bridge1.setTranslateY(640);
        
        bridge2 = new ImageView(bridgeV);
        bridge2.setTranslateX(704);
        bridge2.setTranslateY(382);
        
        bridge3 = new ImageView(bridgeH);
        bridge3.setTranslateX(1088);
        bridge3.setTranslateY(0);
        
        trees0 = new ImageView(trees1x4);
        trees0.setTranslateX(-730);
        trees0.setTranslateY(940);
        
        getChildren().addAll(bridge0, bridge1, bridge2, bridge3, trees0);
    }
    
    @Override
    public void addBounds()
    {
       boundaries.add(trees0.getBoundsInParent());
    }
    
    @Override
    protected void setExitBounds()
    {
        //snowArea = new Exit(-1248, 896, "Snow Area", 1240, -920, false);
        //exitBounds.add(snowArea);
        grassArea = new Exit(-1300, -672, "Grass Area", 1240, 890, true);
        exitBounds.add(grassArea);
    }
    
    @Override
    public ArrayList<Bounds> getBounds()
    {
        return boundaries;
    }
    
    @Override
    public void addEnemies(Enemy... enemies)
    {
        
    }
    
    @Override
    protected final void addWaterBounds()
    {
            water0 = new Rectangle2D(-1248.0, -990.0, 64.0, 50.0);
            waterBounds.add(water0);
            water1 = new Rectangle2D(-1248.0, -940.0, 2268.0, 64.0);
            waterBounds.add(water1);
            water2 = new Rectangle2D(-476.0, -940.0, 64, 448.0);
            waterBounds.add(water2);
            water3 = new Rectangle2D(-476.0, -556.0, 192, 64);
            waterBounds.add(water3);
            water4 = new Rectangle2D(-348.0, -556.0, 64, 192);
            waterBounds.add(water4);
            water5 = new Rectangle2D(-348.0, -428.0, 192, 64);
            waterBounds.add(water5);
            water6 = new Rectangle2D(-220, -428.0, 64, 128);
            waterBounds.add(water6);
            water7 = new Rectangle2D(-220, -236.0, 64, 128);
            waterBounds.add(water7);
            water8 = new Rectangle2D(-604, -172, 1216, 64);
            waterBounds.add(water8);
            water9 = new Rectangle2D(-604, -172, 64, 576);
            waterBounds.add(water9);
            water10 = new Rectangle2D(-732, 340, 192, 64);
            waterBounds.add(water10);
            
            water11 = new Rectangle2D(-732, 340, 64, 256);
            waterBounds.add(water11);
            water12 = new Rectangle2D(-732, 660, 64, 256);
            waterBounds.add(water12);
            water13 = new Rectangle2D(-832, 852, 128, 64);
            waterBounds.add(water13);
            water14 = new Rectangle2D(548, -172, 64, 448);
            waterBounds.add(water14);
            water15 = new Rectangle2D(420, 212, 192, 64);
            waterBounds.add(water15);
            water16 = new Rectangle2D(420, 212, 64, 192);
            waterBounds.add(water16);
            water17 = new Rectangle2D(420, 340, 256, 64);
            waterBounds.add(water17);
            water18 = new Rectangle2D(740, 340, 384, 64);
            waterBounds.add(water18);
            water19 = new Rectangle2D(548, 340, 64, 320);
            waterBounds.add(water19);
           
            water20 = new Rectangle2D(420, 596, 192, 64);
            waterBounds.add(water20);
            water21 = new Rectangle2D(420, 596, 64, 320);
            waterBounds.add(water21);
            water22 = new Rectangle2D(164, 852, 1280, 128);
            waterBounds.add(water22);
            water23 = new Rectangle2D(1060, -172, 64, 128);
            waterBounds.add(water23);
            water24 = new Rectangle2D(1060, 20, 64, 384);
            waterBounds.add(water24);
            water25 = new Rectangle2D(1060, -172, 192, 64);
            waterBounds.add(water25);
            water26 = new Rectangle2D(1188, -236, 64, 128);
            waterBounds.add(water26);
    }
    
    public ArrayList<Rectangle2D> getWaterBounds()
    {
        return waterBounds;
    }
    
    public void destroyBridges()
    {
        bridge0.setImage(brokenBridgeH);
        bridge1.setImage(brokenBridgeH);
        bridge2.setImage(brokenBridgeV);
        bridge3.setImage(brokenBridgeH);
        
        underBridge0 = new Rectangle2D(-220, -300, 64, 64);//This will be removed from the ArrayList when the bridge is built
        waterBounds.add(underBridge0);
        underBridge1 = new Rectangle2D(-732, 596, 64, 64);//Will be removed when bridge is built
        waterBounds.add(underBridge1);
        underBridge2 = new Rectangle2D(676, 340, 64, 64);
        waterBounds.add(underBridge2);
        underBridge3 = new Rectangle2D(1060, -44, 64, 64);
        waterBounds.add(underBridge3);
    }
    
    
}
