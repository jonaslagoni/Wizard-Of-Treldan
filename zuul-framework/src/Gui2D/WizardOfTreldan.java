/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D;

import Gui2D.Maps.Cellar;
<<<<<<< HEAD
import Gui2D.Maps.House1;
=======
import Gui2D.Maps.GruulsLair;
>>>>>>> origin/master
import Gui2D.Maps.Map;
import Gui2D.Maps.Menu;
import Gui2D.SpriteController.SpriteController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author jonas
 */
public class WizardOfTreldan extends Application {
    //set all our maps
    private static Map cellar;
    private static Map gruulslair;
    private static Map menu;
    private static Map house1;
    
    //our global world generator
    private SpriteController world;
    
    //set a global stage from the primaryStage
    private static Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) {
        //set our stage
        this.primaryStage = primaryStage;
        
        //remove the top bar of the frame
        this.primaryStage.initStyle(StageStyle.UNDECORATED);
        
        //set our width and height
        this.primaryStage.setWidth(1024);
        this.primaryStage.setHeight(512);
        
        //set the title
        this.primaryStage.setTitle("The Wizard of Treldan");
        //Init our world sprite controller
        world = new SpriteController();
        
        //Init all world maps
        cellar = new Cellar(world);
        menu = new Menu(world);
<<<<<<< HEAD
        house1 = new House1(world);
        
        //set our first scene
        primaryStage.setScene(house1.getScene());
=======
        gruulslair = new GruulsLair(world);
        
        //set our first scene
        primaryStage.setScene(gruulslair.getScene());
>>>>>>> origin/master
        primaryStage.show();
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Force the game to load menu scene
     */
    public static void setMenuScene(){
        primaryStage.setScene(menu.getScene());
    }
    
    /**
     * Force the game to load CellarScene
     */
    public static void setCellarScene(){
        primaryStage.setScene(cellar.getScene());
    }
    
<<<<<<< HEAD
    public static void setHouse1Scene(){
        primaryStage.setScene(house1.getScene());
=======
    public static void setGruulsLairScene(){
        primaryStage.setScene(gruulslair.getScene());
>>>>>>> origin/master
    }
}
