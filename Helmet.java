/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author timot
 */
public class Helmet {
    private boolean isOwned, iceResist, fireResist, shockResist;
    private int defense;
    private ArrayList<Image> helmetList;
    private ImageView helmetView;
    
    public Helmet(Hero hero, Image left, Image right, Image up, Image down, Image water)
    {
        isOwned = iceResist = fireResist = shockResist = false;
        defense = 5;
        helmetList = new ArrayList<>();
        helmetList.add(left);
        helmetList.add(right);
        helmetList.add(up);
        helmetList.add(down);
        helmetList.add(water);
        
        helmetView = new ImageView(helmetList.get(0));
        setLocation(hero.getX(), hero.getY() - 15);
    }
    
    private void setLocation(double x, double y)
    {
        helmetView.setTranslateX(x);
        helmetView.setX(x);
        helmetView.setTranslateY(y);
        helmetView.setY(y);
    }
    
    private int getDefense()
    {
        return defense;
    }
    
    private boolean isIceResist()
    {
        return iceResist;
    }
    
    private boolean isFireResist()
    {
        return fireResist;
    }
    
    private void setIsOwned()
    {
        isOwned = true;
    }
                    
}
