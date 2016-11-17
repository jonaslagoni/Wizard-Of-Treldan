/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D;

import Gui2D.Maps.Cave;
import Gui2D.Maps.Cellar;
import Gui2D.Maps.Clearing;
import Gui2D.Maps.Dungeon;
import Gui2D.Maps.EvilWizardsLair;
import Gui2D.Maps.House3;
import Gui2D.Maps.House2;
import Gui2D.Maps.House1;
import Gui2D.Maps.Forest;
import Gui2D.Maps.GruulsLair;
import Gui2D.Maps.Library;
import Gui2D.Maps.Load;
import Gui2D.Maps.Map;
import Gui2D.Maps.Menu;
import Gui2D.Maps.PlayerSelection;
import Gui2D.Maps.Unicorn;
import Gui2D.Maps.Village;
import Gui2D.Maps.WizardHouse;
import Gui2D.SpriteController.SpriteController;
import TWoT_A1.TWoT;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Application;
import static javafx.application.Application.launch;
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
    private static Map load;
    private static Map unicorn;
    private static Map clearing;
    private static Map house1;
    private static Map house2;
    private static Map house3;
    private static Map forest;
    private static Map playerSelection;
    private static Map village;
    private static Map cave;
    private static Map dungeon;
    private static Map wizardHouse;
    private static Map evilwizardslair;
    private static Map library;
    private static Map evilWizardsLair;


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
        village = new Village(world);
        house1 = new House1(world);
        house2 = new House2(world);
        house3 = new House3(world);
        menu = new Menu(world);
        load = new Load(world);
        playerSelection = new PlayerSelection(world);
        house2 = new House2(world);
        gruulslair = new GruulsLair(world);
        clearing = new Clearing(world);
        unicorn = new Unicorn(world);
        forest = new Forest(world);
        cave = new Cave(world);
        dungeon = new Dungeon(world);
        wizardHouse = new WizardHouse(world);
        gruulslair = new GruulsLair(world);
        evilwizardslair = new EvilWizardsLair(world);
        library = new Library(world);
        evilWizardsLair = new EvilWizardsLair(world);
        

        
        setHouse1Scene();
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
     * Force the game to load loading scene
     */
    public static void setLoadScene(){
        primaryStage.setScene(load.getScene());
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
     /**
     *  Force the game to load VillageScene
     */
    public static void setVillageScene(){
        primaryStage.setScene(village.getScene());
    }
     /**
     *  Force the game to load House1Scene
     */
    public static void setHouse1Scene(){
        primaryStage.setScene(house1.getScene());
    }
    /**
     * Force the game to load House2Scene
     */
    public static void setHouse2Scene(){
        primaryStage.setScene(house2.getScene());
    }
    
    public static void setHouse3Scene(){
        primaryStage.setScene(house3.getScene());
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
     * Force the game to load GruulsLairScene
     */
    public static void setGruulsLairScene(){
        primaryStage.setScene(gruulslair.getScene());
    }
    
    public static void setClearingScene(){
        primaryStage.setScene(clearing.getScene());
    }
    
    public static void setCaveScene() {
        primaryStage.setScene(cave.getScene());
    }

    public static void setGame(TWoT loaded){
        game = loaded;
    }
    
    public static void setDungeonScene() {
        primaryStage.setScene(dungeon.getScene());
    }
    
    public static void setWizardHouseScene() {
        primaryStage.setScene(wizardHouse.getScene());
    }
    public static void setEvilWizardsLairScene() {
        primaryStage.setScene(evilwizardslair.getScene());
    }
    
    public static void setLibraryScene() {
        primaryStage.setScene(library.getScene());
    } 
    
    public static void setEvilWizardLairScene() {
        primaryStage.setScene(evilWizardsLair.getScene());
    }
    
    public static void resetGame(){
        game = new TWoT();
    }
    
    
    public static void saveGame(){
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        try {
            // Store Serialized User Object in File
            FileOutputStream fileOutputStream = new FileOutputStream("loads/" + game.getCurrentRoomName() + " - " + strDate + ".data");
            ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
            output.writeObject(game);
            output.close();
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        } 
    }
    
    public static void saveGame(String name){
        try {
            // Store Serialized User Object in File
            FileOutputStream fileOutputStream = new FileOutputStream("loads/" + name);
            ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
            output.writeObject(game);
            output.close();
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        } 
    }
}
