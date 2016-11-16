/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.SpriteController.Maps.EvilWizardsLair_sprites;
import Gui2D.SpriteController.Maps.Library_sprites;
import Gui2D.SpriteController.SingleSprite.PlayerSprite;
import Gui2D.SpriteController.Sprite;
import Gui2D.SpriteController.SpriteController;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 *
 * @author Mads
 */
public class EvilWizardsLair extends Map{
    
    // Arraylist for player movement
    private ArrayList<String> input;
    
    // ArrayList for menu key strokes.
    private ArrayList<String> menu_input;
    
    private EvilWizardsLair_sprites evilWizardsLair_sprites;
    /**
     * Constructor for EvilWizardsLair
     * @param world 
     */
    public EvilWizardsLair(SpriteController world){
        //init our super constructor
        super();
        
        //set the ArrayList's from the super class Map
        super.setInput(new ArrayList<String>());
        super.setMenu_input(new ArrayList<String>());
        
        // Link our globals to super class user inputs since no inheritence in AnimationTimer
        input = super.getInput();
        menu_input = super.getMenu_input();
        
        //set the world constructor
        super.setWorld(world);
        
        evilWizardsLair_sprites = new EvilWizardsLair_sprites(world);
        evilWizardsLair_sprites.setEvilWizardsLair_background_SingleSprites();
    }
    
    @Override
    public Scene getScene(){
        Group root = new Group();
        Scene theScene = new Scene( root );
        theScene.setFill(Color.rgb(83, 83, 83));
        Canvas background = new Canvas(1024, 512);
        root.getChildren().add(background);
        GraphicsContext backgroundContext = background.getGraphicsContext2D();
        List<Sprite> spriteList = evilWizardsLair_sprites.getSpriteList();
        
        for (Sprite s : spriteList) {
            s.render(backgroundContext);
        }
        
        return theScene;
    }
}
