/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author timot
 */
public class MyGame extends Application {
    
    public BorderPane root;
    public ScrollPane pane;
    private Hero hero;
    private boolean up, down, left, right, wKey, sKey, aKey, dKey, attacking;
    private GamePlayLoop gamePlayLoop;
    private Scene gameplayScene, loading, itemMenu, mainMenu;
    private Group menuGroup;
    public AreaControl areaControl;
    private Button playButton;
    private Stage primaryStage;

    
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("My Game");
        primaryStage.setFullScreen(true);
        buildGamePlayScene();
        buildMainMenu();
        primaryStage.setScene(mainMenu);
        primaryStage.show();
    }


    
     private void startGameLoop()
    {
        gamePlayLoop = new GamePlayLoop(this);
        gamePlayLoop.start();
    }
     
    private void buildMainMenu()
    {
        menuGroup = new Group();
        mainMenu = new Scene(menuGroup);
        playButton = new Button("Play");
        menuGroup.getChildren().add(playButton);
        createMainMenuEventHandling();

    }
     
    private void createMainMenuEventHandling()
    {
        playButton.setOnAction((ActionEvent e) -> {
            primaryStage.setScene(gameplayScene);
            primaryStage.setFullScreen(true);
            startGameLoop();
        });
         
    }
     
    private void createGameplaySceneEventHandling()
    {
        gameplayScene.setOnKeyPressed((KeyEvent event) -> 
        {
            switch (event.getCode())
            {
                case UP: up = true; break;
                case DOWN: down = true; break;
                case LEFT: left = true; break;
                case RIGHT: right = true; break;
                case W: wKey = true; break;
                case S: sKey = true; break;
                case A: aKey = true; break;
                case D: dKey = true; break;
                case SPACE: attacking = true; break;
            }
        });
        
        gameplayScene.setOnKeyReleased((KeyEvent event) -> 
        {
            switch (event.getCode())
            {
                case UP: up = false; break;
                case DOWN: down = false; break;
                case LEFT: left = false; break;
                case RIGHT: right = false; break;
                case W: wKey = false; break;
                case S: sKey = false; break;
                case A: aKey = false; break;
                case D: dKey = false; break;
                case SPACE: attacking = false; break;
            }
        });
    }
    
    private void buildGamePlayScene()
    {
        hero = new Hero(this);
        areaControl = new AreaControl(hero);
        root = new BorderPane(areaControl.getPane());
        gameplayScene = new Scene(root);
        root.setScaleX(2);
        root.setScaleY(2);
        createGameplaySceneEventHandling();
    }
    
    public boolean isRight()
    {
        return right;
    }
    
    public boolean isLeft()
    {
        return left;
    }
    
    public boolean isUp()
    {
        return up;
    }
    
    public boolean isDown()
    {
        return down;
    }
    
    public boolean isAttacking()
    {
        return attacking;
    }
    
    public Hero getHero()
    {
        return hero;
    }
    
    public ScrollPane getScrollPane()
    {
        return pane;
    }
    
    public AreaControl getAreaControl()
    {
        return areaControl;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
