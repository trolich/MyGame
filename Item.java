/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author timot
 */
public abstract class Item {
    
    private boolean isOwned;
    private int menuX, menuY;
    private Image itemImage;
    private ImageView itemView;
    
    public Item(int menuX, int menuY, Image itemImage)
    {
        this.menuX = menuX;
        this.menuY = menuY;
        this.itemImage = itemImage;
        
        itemView.setImage(itemImage);
        itemView.setTranslateX(menuX);
        itemView.setX(menuX);
        itemView.setTranslateY(menuY);
        itemView.setY(menuY);
        
        isOwned = false;
    }
    
    private void setOwned(boolean value)
    {
        isOwned = value;
    }
    
    private boolean isOwned()
    {
        return isOwned;
    }
    
    private void move(int x, int y)
    {
        itemView.setTranslateX(x);
        itemView.setX(x);
        itemView.setTranslateY(y);
        itemView.setY(y);
    }
    
    abstract void use();
    
}
