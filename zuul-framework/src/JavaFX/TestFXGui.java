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
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
/**
 *
 * @author jonas
 */
public class TestFXGui extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("The wizard of Treldan");
        showMenu(primaryStage);
        primaryStage.setResizable(false);
        primaryStage.setWidth(1024);
        primaryStage.setHeight(512);
        primaryStage.show();
    }
    public void showMenu(Stage primaryStage){
        Group menuGroup = new Group();
        Scene menuScene = new Scene( menuGroup );
        Pane anchorpane = new Pane();
        
        Canvas canvas_movealbe_sprites = new Canvas( 1024, 512 );
        canvas_movealbe_sprites.relocate(0, 0);
        GraphicsContext ground_moveable_gc = canvas_movealbe_sprites.getGraphicsContext2D();
        
        WorldGenerator world = new WorldGenerator();
        List<Sprite> menu_sprites = world.getMenu_sprites();
        for(Sprite sprite: menu_sprites){
            sprite.render(ground_moveable_gc);
        }
        new AnimationTimer(){
            private int animationDelay = 0;
            public void handle(long currentNanoTime){
                if(animationDelay == 40){
                    ground_moveable_gc.clearRect(0, 0, 1024,512);
                    for(Sprite sprite: menu_sprites){
                        sprite.render(ground_moveable_gc);
                    }
                    animationDelay = 0;
                }else{
                    animationDelay++;
                }
            }
        }.start();
        anchorpane.setPrefSize(768, 512);
        Button start = new Button();
        start.setText("New Game");
        start.setFont(new Font("Tahoma", 20));
        start.setPrefSize(150, 50);
        start.relocate(200, 100);
        start.addEventHandler(MouseEvent.MOUSE_CLICKED, 
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    move_around(primaryStage);
                }
        });
        anchorpane.getChildren().add(start);
        
        Button load = new Button();
        load.setText("Load Game");
        load.setFont(new Font("Tahoma", 20));
        load.setPrefSize(150, 50);
        load.relocate(200, 200);
        load.addEventHandler(MouseEvent.MOUSE_CLICKED, 
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    move_around(primaryStage);
                }
        });
        anchorpane.getChildren().add(load);
        
        menuGroup.getChildren().add( canvas_movealbe_sprites );
        menuGroup.getChildren().add(anchorpane);
        primaryStage.setScene( menuScene );
    }
    
    public void move_around(Stage primaryStage){
        Group root = new Group();
        Scene theScene = new Scene( root );
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
        
        primaryStage.setScene( theScene );
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
