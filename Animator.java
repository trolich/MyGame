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
public class Animator {
    private boolean animator, animator1, passive;
    private int framecounter;
    private ImageView view;
    
    public Animator(ImageView view)
    {
     this.view = view;   
    }
    
    public void activeAnimate(Image frame0, Image frame1, int speed)
    {
        if(!passive)
        {
        if(!animator)
            {
                view.setImage(frame0);
                if(framecounter >= speed)
                {
                   animator = true; 
                   framecounter = 0;
                }
                else {framecounter++;}
            }
        else if(animator)
            {
                view.setImage(frame1);
                if(framecounter >= speed){
                   animator = false;
                   framecounter = 0;
                }
                else {framecounter++;}
            }
        }
    }
    
    public void activeAnimate(Image frame0, Image frame1, Image frame2, Image frame3, int speed)
    {
        if(!passive)
        {
        if(!animator && !animator1)
            {
                view.setImage(frame0);
                if(framecounter >= speed)
                {
                   animator = true; 
                   framecounter = 0;
                }
                else {framecounter++;}
            }
        else if(animator && !animator1)
            {
                view.setImage(frame1);
                if(framecounter >= speed){
                   animator = false;
                   animator1 = true;
                   framecounter = 0;
                }
                else {framecounter++;}
            }
        else if(!animator && animator1)
            {
                view.setImage(frame2);
                if(framecounter >= speed){
                   animator = true; 
                   framecounter = 0;
                }
                else {framecounter++;}
            }
        else if(animator && animator1)
            {
                view.setImage(frame3);
                if(framecounter >= speed){
                   animator = false; 
                   animator1 = false;
                   framecounter = 0;
                }
                else {framecounter++;}
            }
        }
    }
    
    public void activeAnimate(Image frame0, Image frame1, Image frame2, int speed)
    {
        if(!passive)
        {
        if(!animator && !animator1)
            {
                view.setImage(frame0);
                if(framecounter >= speed)
                {
                   animator = true; 
                   framecounter = 0;
                }
                else {framecounter++;}
            }
        else if(animator && !animator1)
            {
                view.setImage(frame1);
                if(framecounter >= speed){
                   animator = false;
                   animator1 = true;
                   framecounter = 0;
                }
                else {framecounter++;}
            }
        else if(!animator && animator1)
            {
                view.setImage(frame2);
                if(framecounter >= speed){
                   animator = true; 
                   framecounter = 0;
                }
                else {framecounter++;}
            }
        else if(animator && animator1)
            {
                view.setImage(frame1);
                if(framecounter >= speed){
                   animator = false; 
                   animator1 = false;
                   framecounter = 0;
                }
                else {framecounter++;}
            }
        }
    }
    
    public void passiveAnimate(Image frame0, Image frame1, Image frame2, Image frame3, int speed)
    {
        passive = true;
        animator = false;
        animator1 = false;
        framecounter = 0;
        for(int i = 0; i < (speed); i++)
        {
            view.setImage(frame0);
            if(!animator && !animator1)
               {                      
                    if(framecounter >= (speed))
                    {
                        animator = true; 
                        framecounter = 0;
                    }
                    else{framecounter++;}
                }
            else if(animator && !animator1)
                {
                    view.setImage(frame1);
                    if(framecounter >= (speed))
                    {
                       animator = false;
                       animator1 = true;
                       framecounter = 0;
                    }
                    else{framecounter++;}
                    }
            else if(!animator && animator1)
                {
                    view.setImage(frame2);
                    if(framecounter >= (speed))
                    {
                       animator = true; 
                       framecounter = 0;
                    }
                    else{framecounter++;}
                }
            else if(animator && animator1)
                {
                    view.setImage(frame3);
                    if(framecounter >= (speed))
                    {
                      animator = false; 
                       animator1 = false;
                       framecounter = 0;
                    }
                    else{framecounter++;}
            }
        }
        passive = false;
    }
}
