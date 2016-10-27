/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFX;

import JavaFX.PlayerSprite.Direction;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author jonas
 */
public class TestFXGui extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("The wizard of Treldan");
        Group root = new Group();
        Scene theScene = new Scene( root );
        primaryStage.setScene( theScene );

        Canvas canvas_still_sprites = new Canvas( 1024, 512 );
        root.getChildren().add( canvas_still_sprites );
        
        Canvas canvas_moveable_sprites = new Canvas( 1024, 512 );
        root.getChildren().add( canvas_moveable_sprites );
        
        Canvas player_canvas = new Canvas( 1024, 512 );
        root.getChildren().add( player_canvas );
        
        PlayerSprite player = new PlayerSprite();
        player.setImage("player.png");
        player.setPosition(200, 0);
        player.setHeight(64);
        player.setWidth(64);
        ArrayList<String> input = new ArrayList<String>();
        theScene.setOnKeyReleased(
            new EventHandler<KeyEvent>(){
                public void handle(KeyEvent e){
                    String code = e.getCode().toString();
                    input.remove(code);
                    
                    if(e.getCode().toString().equals("LEFT")){
                        player.setVelocity(0,player.getVelocityY());
                    }
                    if(e.getCode().toString().equals("RIGHT")){
                        player.setVelocity(0,player.getVelocityY());
                    }
                    if(e.getCode().toString().equals("UP")){
                        player.setVelocity(player.getVelocityX(),0);
                    }
                    if(e.getCode().toString().equals("DOWN")){
                        player.setVelocity(player.getVelocityX(),0);
                    }
                }
            });
        theScene.setOnKeyPressed(
            new EventHandler<KeyEvent>(){
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
 
                    // only add once... prevent duplicates
                    if ( !input.contains(code) )
                        input.add( code );
                    
                }
            });
        GraphicsContext ground_still_gc = canvas_still_sprites.getGraphicsContext2D();
        GraphicsContext ground_moveable_gc = canvas_moveable_sprites.getGraphicsContext2D();
        GraphicsContext moveable_gc = player_canvas.getGraphicsContext2D();
        
        WorldGenerator world = new WorldGenerator();
        
        List<Sprite> sprites_still = world.getStillSprites();
        List<Sprite> sprites_moveable = world.getMoveableSprites();
        
        LongValue lastNanoTime = new LongValue( System.nanoTime() );
        
        for(Sprite sprite: sprites_still){
            sprite.render(ground_still_gc);
        }
        
        for(Sprite sprite: sprites_moveable){
            sprite.render(ground_moveable_gc);
        }
        
        
        IntValue score = new IntValue(0);
        new AnimationTimer(){
            private int animationDelay = 0;
            public void handle(long currentNanoTime){
                double elapsedTime = (currentNanoTime - lastNanoTime.value) / 1000000000.0;
                lastNanoTime.value = currentNanoTime;
                player.update(elapsedTime);
                
                if (input.contains("LEFT")){
                    player.setVelocity(-100,0);
                    player.setDirection(Direction.WALK_LEFT);
                }
                if(input.contains("RIGHT")){
                    player.setVelocity(100,0);
                    player.setDirection(Direction.WALK_RIGHT);
                }
                if(input.contains("UP")){
                    player.setVelocity(0,-100);
                    player.setDirection(Direction.WALK_UP);
                }
                if(input.contains("DOWN")){
                    player.setVelocity(0,100);
                    player.setDirection(Direction.WALK_DOWN);
                }
                if(input.isEmpty()){
                    player.setDirection(Direction.STANDSTILL);
                }
                moveable_gc.clearRect(0, 0, 1024,512);
                if(animationDelay == 40){
                    ground_moveable_gc.clearRect(0, 0, 1024,512);
                    for(Sprite sprite: sprites_moveable){
                        sprite.render(ground_moveable_gc);
                    }
                    animationDelay = 0;
                }else{
                    animationDelay++;
                }
                player.render(moveable_gc);
            }
        }.start();
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
