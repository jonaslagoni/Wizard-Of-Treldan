/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D;

import Gui2D.Maps.Cellar;
import Gui2D.Maps.Clearing;
import Gui2D.Maps.House2;
import Gui2D.Maps.Forest;
import Gui2D.Maps.GruulsLair;
import Gui2D.Maps.Map;
import Gui2D.Maps.Menu;
import Gui2D.Maps.PlayerSelection;
import Gui2D.Maps.Unicorn;
import Gui2D.Maps.Village;
import Gui2D.SpriteController.SpriteController;
import TWoT_test.TWoT;
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
    private static Map unicorn;
    private static Map clearing;
    private static Map house2;
    private static Map forest;
    private static Map playerSelection;
    private static Map village;

    /**
     * @return the game
     */
    public static TWoT getGame() {
        return game;
    }
    
    //our global world generator
    private SpriteController world;
    
    
    private static TWoT game;
    
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
        
        game = new TWoT();
        //set the title
        this.primaryStage.setTitle("The Wizard of Treldan");
        //Init our world sprite controller
        world = new SpriteController();
        
        //Init all world maps
        cellar = new Cellar(world);
        menu = new Menu(world);
        playerSelection = new PlayerSelection(world);
        house2 = new House2(world);
        gruulslair = new GruulsLair(world);
        clearing = new Clearing(world);
        unicorn = new Unicorn(world);
        forest = new Forest(world);
        village = new Village(world);
        gruulslair = new GruulsLair(world);
        
        setMenuScene();
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
     * Force the game to load playerSelection scene
     */
    public static void setPlayerSelectionScene(){
        primaryStage.setScene(playerSelection.getScene());
    }
    
    /**
     * Force the game to load CellarScene
     */
    public static void setCellarScene(){
        primaryStage.setScene(cellar.getScene());
    }
    
    public static void setVillageScene(){
        primaryStage.setScene(village.getScene());
    }

    /**
     *  Force the game to load UnicornScene
     */
    public static void setUnicornScene(){
        primaryStage.setScene(unicorn.getScene());
    }
    
    /**
     * Force the game to load ForestScene
     */
    public static void setForestScene() {
        primaryStage.setScene(forest.getScene());
    }
    
    /**
     * Force the game to load House2Scene
     */
    public static void setHouse2Scene(){
        primaryStage.setScene(house2.getScene());
    }
    
    /**
     * Force the game to load GruulsLairScene
     */
    public static void setGruulsLairScene(){
        primaryStage.setScene(gruulslair.getScene());
    }
    
    public static void setClearingScene(){
        primaryStage.setScene(clearing.getScene());
    }
    
    
    public static void resetGame(){
        game = new TWoT();
    }
}
