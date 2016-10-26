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

        Canvas canvas = new Canvas( 1024, 512 );
        root.getChildren().add( canvas );
        
        Canvas player_canvas = new Canvas( 1024, 512 );
        root.getChildren().add( player_canvas );
        
        PlayerSprite player = new PlayerSprite();
        player.setImage("player.png");
        player.setPosition(200, 0);
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
        GraphicsContext gc = canvas.getGraphicsContext2D();
        GraphicsContext player_gc = player_canvas.getGraphicsContext2D();
        WorldGenerator world = new WorldGenerator(gc);
        List<Sprite> sprites = world.getSprites();
        LongValue lastNanoTime = new LongValue( System.nanoTime() );
        for(Sprite sprite: sprites){
            sprite.render(gc);
        }
        IntValue score = new IntValue(0);
        new AnimationTimer(){
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
                player_gc.clearRect(0, 0, 1024,512);
                player.render(player_gc);
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
