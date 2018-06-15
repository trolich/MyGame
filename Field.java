/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import java.awt.Color;
import java.util.ArrayList;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author timot
 */
public class Field extends OpenWorld {
    
    Exit town;
    
    public Field()
    {
        setPrefSize(3235, 2265); //Width + 675, Height + 365
        setWidth(USE_PREF_SIZE);
        setHeight(USE_PREF_SIZE);
        createBackground();
        addWaterBounds();
        setExitBounds();
        addFeatures();
    }

    @Override
    void createBackground() 
    {
        background = new Image("/Field.png");
        backView = new ImageView(background);
        getChildren().add(backView);
    }

    @Override
    void addFeatures() {
    }

    @Override
    void addBounds() {
    }

    @Override
    ArrayList<Bounds> getBounds() {
        return boundaries;
    }

    @Override
    void addWaterBounds() {
    }

    @Override
    void addEnemies(Enemy... enemies) {
    }
    
    @Override
    void setExitBounds()
    {
        town = new Exit(1260, 860, "Town", -1235, -650, true);
        exitBounds.add(town);
    }
    
}
