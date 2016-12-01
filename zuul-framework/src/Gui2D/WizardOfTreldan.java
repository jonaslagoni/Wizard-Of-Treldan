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
import Gui2D.Maps.Finish;
import Gui2D.Maps.House3;
import Gui2D.Maps.House2;
import Gui2D.Maps.House1;
import Gui2D.Maps.Forest;
import Gui2D.Maps.GruulsLair;
import Gui2D.Maps.Highscore;
import Gui2D.Maps.Library;
import Gui2D.Maps.Load;
import Gui2D.Maps.Map;
import Gui2D.Maps.Menu;
import Gui2D.Maps.PlayerSelection;
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
    private static Map highscore;
    private static Map finish;
    
    //our global world generator
    private SpriteController world;
    
    //our global twot game
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
        
        //create a new TWoT object
        game = new TWoT();
        
        //set the title of the stage
        this.primaryStage.setTitle("The Wizard of Treldan");
        //Init our world sprite controller
        world = new SpriteController();
        
        //Init all world maps
        cellar = new Cellar(world);
        village = new Village(world);
        house1 = new House1(world);
        house2 = new House2(world);
        house3 = new House3(world);
        forest = new Forest(world);
        gruulslair = new GruulsLair(world);
        clearing = new Clearing(world);
        cave = new Cave(world);
        wizardHouse = new WizardHouse(world);
        gruulslair = new GruulsLair(world);
        dungeon = new Dungeon(world);
        library = new Library(world);
        evilwizardslair = new EvilWizardsLair(world);
        //init normal scenes
        menu = new Menu();
        load = new Load();
        playerSelection = new PlayerSelection();
        highscore = new Highscore();
        finish = new Finish(world);
        
        //set our first scene to the menu.
        setMenuScene();
        primaryStage.show();
    }
    
    
    /**
     * Starts the gui
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Force the gui to load menu scene
     */
    public static void setMenuScene(){
        primaryStage.setScene(menu.getScene());
    }
    
    /**
     * Force the gui to load loading scene
     */
    public static void setLoadScene(){
        primaryStage.setScene(load.getScene());
    }
    
    /**
     * Force the gui to load highscore scene
     */
    public static void setHighscoreScene(){
        primaryStage.setScene(highscore.getScene());
    }
    
    /**
     * Force the gui to finish scene
     */
    public static void setFinishScene(){
        primaryStage.setScene(finish.getScene());
    }
    
    /**
     * Force the gui to load playerSelection scene
     */
    public static void setPlayerSelectionScene(){
        primaryStage.setScene(playerSelection.getScene());
    }
    
    /**
     * Force the gui to load CellarScene
     */
    public static void setCellarScene(){
        primaryStage.setScene(cellar.getScene());
    }
    
    /**
     *  Force the gui to load VillageScene
     */
    public static void setVillageScene(){
        primaryStage.setScene(village.getScene());
    }
    
    /**
     *  Force the gui to load House1Scene
     */
    public static void setHouse1Scene(){
        primaryStage.setScene(house1.getScene());
    }
    
    /**
     * Force the gui to load House2Scene
     */
    public static void setHouse2Scene(){
        primaryStage.setScene(house2.getScene());
    }
    
    /**
     * Force the gui to load House3Scene
     */
    public static void setHouse3Scene(){
        primaryStage.setScene(house3.getScene());
    }
        
    /**
     *  Force the gui to load UnicornScene
     */
    public static void setUnicornScene(){
        primaryStage.setScene(unicorn.getScene());
    }
    
    /**
     * Force the gui to load ForestScene
     */
    public static void setForestScene() {
        primaryStage.setScene(forest.getScene());
    }    
    
    /**
     * Force the gui to load GruulsLairScene
     */
    public static void setGruulsLairScene(){
        primaryStage.setScene(gruulslair.getScene());
    }
    
    /**
     * Force the gui to load the clearing scene
     */
    public static void setClearingScene(){
        primaryStage.setScene(clearing.getScene());
    }
    
    /**
     * Force the gui to load the cave scene
     */
    public static void setCaveScene() {
        primaryStage.setScene(cave.getScene());
    }
    
    /**
     * Force the gui to load the dungeon scene
     */
    public static void setDungeonScene() {
        primaryStage.setScene(dungeon.getScene());
    }
    
    /**
     * Force the gui to load the wizardhouse scene
     */
    public static void setWizardHouseScene() {
        primaryStage.setScene(wizardHouse.getScene());
    }
    
    /**
     * Force the gui to load the evil wizards lair scene
     */
    public static void setEvilWizardsLairScene() {
        primaryStage.setScene(evilwizardslair.getScene());
    }
    
    /**
     * Force the gui to load the library scene
     */
    public static void setLibraryScene() {
        primaryStage.setScene(library.getScene());
    }
    
    /**
     * Resets the game by making a new instance of TWoT
     */
    public static void resetGame(){
        game = new TWoT();
    }
    
    
    /**
     * Set the twot object to another twot object 
     * @param loaded 
     */
    public static void setGame(TWoT loaded){
        game = loaded;
    }


    /**
     * return the game object
     * @return the game
     */
    public static TWoT getGame() {
        return game;
    }
    
    /**
     * Saves the game
     * Name of the file will be the current date and time and the current room name. 
     * Stores the file under the folder "loads"
     */
    public static void saveGame(){
        //Make a SimpleDateFormat object of date and time
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");//dd/MM/yyyy
        //get the current date
        Date now = new Date();
        //get the current date and time formated from the SimpleDateFormat
        String strDate = sdfDate.format(now);
        try {
            // Store Serialized game Object in File
            FileOutputStream fileOutputStream = new FileOutputStream("loads/" + game.getCurrentRoomName() + " - " + strDate + ".data");
            ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
            //write the game object 
            output.writeObject(game);
            //close the connection
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
    /**
     * Saves the game with a string as filename
     * Stores the file under the folder "loads"
     * @param name 
     */
    public static void saveGame(String name){
        try {
            // Store Serialized game Object in File
            FileOutputStream fileOutputStream = new FileOutputStream("loads/" + name);
            ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
            //write the game object 
            output.writeObject(game);
            //close the connection
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
