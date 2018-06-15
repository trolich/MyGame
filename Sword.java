/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import javafx.scene.image.Image;

/**
 *
 * @author timot
 */
public class Sword extends Item {
    
    Image sword;
    private Sword(int menuX, int menuY, Image itemImage)
    {
        super(menuX, menuY, itemImage);
        sword = new Image("/sword.png");
        itemImage = sword;
    }

    @Override
    void use() 
    {
        //empty
    }
}
