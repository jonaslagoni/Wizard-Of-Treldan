    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.Maps;

import Gui2D.SpriteController.Maps.Clearing_sprites;
import Gui2D.SpriteController.SingleSprite.PlayerSprite;
import Gui2D.SpriteController.Sprite;
import Gui2D.SpriteController.SpriteController;
import Gui2D.WizardOfTreldan;
import static java.lang.System.gc;
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
 * @author jonas
 */
public class Clearing extends Map{
    
    
    // ArrayList for menu key strokes.
    private Clearing_sprites s;
    private ArrayList<String> input;
    
    // ArrayList for menu key strokes.
    private ArrayList<String> menu_input;
    
    /**
     * Constructor for Cellar
     * @param world 
     */
    public Clearing(SpriteController world){
        //init our super constructor
        super();
        
        //set the world constructor
        super.setWorld(world);
        
        s = new Clearing_sprites(world);
        s.setClearing();
        
    }
    
    public Scene getScene(){
        Group root = new Group();
        Scene theScene = new Scene( root );
        theScene.setFill(Color.rgb(83, 83, 83));
        
        
        Canvas canvas_background = new Canvas(730,370);
        canvas_background.relocate(126,66);
        root.getChildren().add(canvas_background);
        
        
        GraphicsContext background_gc = canvas_background.getGraphicsContext2D();
       
       
       

        List<Sprite> sprites_still = s.getClearing();
        for(Sprite sprite : sprites_still){
            sprite.render(background_gc);
        }
        

        return theScene;
    }
}
