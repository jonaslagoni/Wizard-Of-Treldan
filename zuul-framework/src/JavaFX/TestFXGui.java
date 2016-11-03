/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFX;

import SpriteController.SpriteGenerator;
import SpriteController.Sprite;
import SpriteController.PlayerSprite;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;

/**
 *
 * @author jonas
 */
public class TestFXGui extends Application {
    private SpriteGenerator world;
    private Stage mainStage;
    private ArrayList<String> input;
    private ArrayList<String> menu_input;
    @Override
    public void start(Stage primaryStage) {
        mainStage = primaryStage;
        primaryStage.initStyle(StageStyle.UNDECORATED);
        world = new SpriteGenerator();
        mainStage.setTitle("The wizard of Treldan");
        world = new SpriteGenerator();
        input = new ArrayList<String>();
        menu_input = new ArrayList<String>();
        showMenuMap();
        mainStage.setWidth(1024);
        mainStage.setHeight(512);
        mainStage.show();
    }
    
    public void showMenuMap(){
        mainStage.setScene(menuMap());
    }
    
    public void showMap1(){
        mainStage.setScene(map1());
    }
    
    public void showTestMap(){
        mainStage.setScene(testMap());
    }
    public EventHandler<KeyEvent> playerMovement(PlayerSprite player){
        return new EventHandler<KeyEvent>(){
            public void handle(KeyEvent e){
                String code = e.getCode().toString();
                input.remove(code);
                if(code.equals("LEFT")){
                    player.setVelocity(0,player.getVelocityY());
                }
                if(code.equals("RIGHT")){
                    player.setVelocity(0,player.getVelocityY());
                }
                if(code.equals("UP")){
                    player.setVelocity(player.getVelocityX(),0);
                }
                if(code.equals("DOWN")){
                    player.setVelocity(player.getVelocityX(),0);
                }
            }
        };
    }
    public EventHandler<KeyEvent> userPressedKey(){
        return new EventHandler<KeyEvent>(){
            public void handle(KeyEvent e)
            {
                String code = e.getCode().toString();
                System.out.println(e.getCode().toString());
                // only add once... prevent duplicates
                
                if(code.equals("I")){
                    if(!menu_input.contains(code)){
                        menu_input.add(code);
                    }else{
                        menu_input.remove(code);
                    }
                }
            
                if ( !input.contains(code) )
                    input.add( code );

            }
        };
    }
    
    public Scene map1(){
        Group root = new Group();
        Scene theScene = new Scene( root );
        theScene.setFill(Color.BLACK);
        Canvas canvas_still_sprites = new Canvas( 512+128, 256+128 );
        canvas_still_sprites.relocate(256-40, 128-40);
        root.getChildren().add( canvas_still_sprites );
        
        Canvas player_canvas = new Canvas( 512+128, 256+128 );
        player_canvas.relocate(256-40, 128-40);
        root.getChildren().add( player_canvas );
        
        Canvas canvas_menu_sprites = new Canvas( 1024, 512 );
        canvas_menu_sprites.relocate(0, 0);
        root.getChildren().add( canvas_menu_sprites );
        
        PlayerSprite player = new PlayerSprite();
        player.setImage("player.png");
        player.setPosition(100, 100);
        player.setHeight(64);
        player.setWidth(64);
        
        theScene.setOnKeyReleased(playerMovement(player));
        theScene.setOnKeyPressed(userPressedKey());
        GraphicsContext ground_still_gc = canvas_still_sprites.getGraphicsContext2D();
        GraphicsContext moveable_gc = player_canvas.getGraphicsContext2D();
        GraphicsContext menu_gc = canvas_menu_sprites.getGraphicsContext2D();
        
        List<Sprite> sprites_still = world.getMap1_sprites_still();
        
        LongValue lastNanoTime = new LongValue( System.nanoTime() );
        
        for(Sprite sprite: sprites_still){
            sprite.render(ground_still_gc);
        }
        
        Rectangle2D worldBoundRight = new Rectangle2D(512+95, 0, 1, 256+80);
        Rectangle2D worldBoundLeft = new Rectangle2D(0, 0, 1, 256+80);
        Rectangle2D worldBoundBottom = new Rectangle2D(0, 256+90, 512+80, 1);
        Rectangle2D worldBoundTop = new Rectangle2D(0, 0, 1024, 1);
        IntValue score = new IntValue(0);
        new AnimationTimer(){
            private int animationDelay = 0;
            public void handle(long currentNanoTime){
                double elapsedTime = (currentNanoTime - lastNanoTime.value) / 1000000000.0;
                lastNanoTime.value = currentNanoTime;
                player.setDirection(PlayerSprite.Direction.STANDSTILL);
                if (input.contains("LEFT")){
                    if(player.intersects_world_left(worldBoundLeft)){
                        player.setVelocity(0, 0);
                    }else if(player.intersects_sprite_left(sprites_still.get(1))){
                        player.setVelocity(0, 0);
                    }else{
                        player.setVelocity(-100,0);
                    }
                    player.setDirection(PlayerSprite.Direction.WALK_LEFT);
                }
                if(input.contains("RIGHT")){
                    if(player.intersects_world_right(worldBoundRight)){
                        player.setVelocity(0, 0);
                    }else if(player.intersects_sprite_right(sprites_still.get(1))){
                        player.setVelocity(0, 0);
                    }else{
                        player.setVelocity(100,0);
                    }
                    player.setDirection(PlayerSprite.Direction.WALK_RIGHT);
                }
                if(input.contains("UP")){
                    if(player.intersects_world_top(worldBoundTop)){
                        player.setVelocity(0, 0);
                    }else if(player.intersects_sprite_top(sprites_still.get(1))){
                        player.setVelocity(0, 0);
                    }else{
                        player.setVelocity(0,-100);
                    }
                    player.setDirection(PlayerSprite.Direction.WALK_UP);
                }
                if(input.contains("DOWN")){
                    if(player.intersects_world_bottom(worldBoundBottom)){
                        player.setVelocity(0, 0);
                    }else if(player.intersects_sprite_bottom(sprites_still.get(1))){
                        player.setVelocity(0, 0);
                    }else{
                        player.setVelocity(0,100);
                    }
                    player.setDirection(PlayerSprite.Direction.WALK_DOWN);
                }
                player.update(elapsedTime);
                moveable_gc.clearRect(0, 0, 1024,512);
                player.render(moveable_gc);
                
                /*
                // draw the boundaries for test
                //bottom
                moveable_gc.setFill(Color.CADETBLUE);
                moveable_gc.fillRect(player.getPositionX()+15, player.getPositionY()+player.getHeight()-14, player.getWidth()-47, 5);

                //top
                moveable_gc.setFill(Color.BEIGE);
                moveable_gc.fillRect(player.getPositionX()+15, player.getPositionY()+player.getHeight()-22, player.getWidth()-47, 5);

                //left
                moveable_gc.setFill(Color.DARKGREEN);
                moveable_gc.fillRect(player.getPositionX()+11, player.getPositionY()+player.getWidth()-20, 5, 10);

                //right
                moveable_gc.setFill(Color.CRIMSON);
                moveable_gc.fillRect(player.getPositionX()+player.getWidth()-32,  player.getPositionY()+player.getWidth()-20, 5, 10);
                */
                if(menu_input.contains("I")){
                    menu_gc.setFill(Color.CADETBLUE);
                    menu_gc.fillRect(1024-250, 0, 250, 512);
                }else{
                    menu_gc.clearRect(0, 0, 1024,512);
                }
            }
        }.start();
        return theScene;
    }
    
    public Scene map_kasper(){
        Group root = new Group();
        Scene theScene = new Scene( root );
        theScene.setFill(Color.BLACK);
        
        Canvas canvas_still_sprites = new Canvas( 1024, 512 );
        canvas_still_sprites.relocate(0,0);
        root.getChildren().add( canvas_still_sprites );
        
        Canvas player_canvas = new Canvas( 1024, 512 );
        player_canvas.relocate(0, 0);
        root.getChildren().add( player_canvas );
        
        Canvas canvas_menu_sprites = new Canvas( 1024, 512 );
        canvas_menu_sprites.relocate(0, 0);
        root.getChildren().add( canvas_menu_sprites );
        
        PlayerSprite player = new PlayerSprite();
        player.setImage("player.png");
        player.setPosition(100, 100);
        player.setHeight(64);
        player.setWidth(64);
        
        //Keypress
        theScene.setOnKeyReleased(playerMovement(player));
        theScene.setOnKeyPressed(userPressedKey());
        
        
        GraphicsContext ground_still_gc = canvas_still_sprites.getGraphicsContext2D();
        GraphicsContext moveable_gc = player_canvas.getGraphicsContext2D();
        GraphicsContext menu_gc = canvas_menu_sprites.getGraphicsContext2D();
        
        
        List<Sprite> sprites_still = world.getVillage_sprites_still();
        
        LongValue lastNanoTime = new LongValue( System.nanoTime() );
        
        for(Sprite sprite: sprites_still){
            sprite.render(ground_still_gc);
        }
        
        Rectangle2D worldBoundRight = new Rectangle2D(1045, 0, 1, 512);
        Rectangle2D worldBoundLeft = new Rectangle2D(-5, 0, 1, 512);
        Rectangle2D worldBoundBottom = new Rectangle2D(0, 512, 1024, 1);
        Rectangle2D worldBoundTop = new Rectangle2D(0, 0, 1024, 1);
        IntValue score = new IntValue(0);
        new AnimationTimer(){
            private int animationDelay = 0;
            public void handle(long currentNanoTime){
                double elapsedTime = (currentNanoTime - lastNanoTime.value) / 1000000000.0;
                lastNanoTime.value = currentNanoTime;
                player.setDirection(PlayerSprite.Direction.STANDSTILL);
                if (input.contains("LEFT")){
                    if(player.intersects_world_left(worldBoundLeft)){
                        player.setVelocity(0, 0);
                    }else if(player.intersects_sprite_left(sprites_still.get(1))){
                        player.setVelocity(0, 0);
                    }else{
                        player.setVelocity(-100,0);
                    }
                    player.setDirection(PlayerSprite.Direction.WALK_LEFT);
                }
                if(input.contains("RIGHT")){
                    if(player.intersects_world_right(worldBoundRight)){
                        player.setVelocity(0, 0);
                    }else if(player.intersects_sprite_right(sprites_still.get(1))){
                        player.setVelocity(0, 0);
                    }else{
                        player.setVelocity(100,0);
                    }
                    player.setDirection(PlayerSprite.Direction.WALK_RIGHT);
                }
                if(input.contains("UP")){
                    if(player.intersects_world_top(worldBoundTop)){
                        player.setVelocity(0, 0);
                    }else if(player.intersects_sprite_top(sprites_still.get(1))){
                        player.setVelocity(0, 0);
                    }else{
                        player.setVelocity(0,-100);
                    }
                    player.setDirection(PlayerSprite.Direction.WALK_UP);
                }
                if(input.contains("DOWN")){
                    if(player.intersects_world_bottom(worldBoundBottom)){
                        player.setVelocity(0, 0);
                    }else if(player.intersects_sprite_bottom(sprites_still.get(1))){
                        player.setVelocity(0, 0);
                    }else{
                        player.setVelocity(0,100);
                    }
                    player.setDirection(PlayerSprite.Direction.WALK_DOWN);
                }
                player.update(elapsedTime);
                moveable_gc.clearRect(0, 0, 1024,512);
                player.render(moveable_gc);
                
                /*
                // draw the boundaries for test
                //bottom
                moveable_gc.setFill(Color.CADETBLUE);
                moveable_gc.fillRect(player.getPositionX()+15, player.getPositionY()+player.getHeight()-14, player.getWidth()-47, 5);

                //top
                moveable_gc.setFill(Color.BEIGE);
                moveable_gc.fillRect(player.getPositionX()+15, player.getPositionY()+player.getHeight()-22, player.getWidth()-47, 5);

                //left
                moveable_gc.setFill(Color.DARKGREEN);
                moveable_gc.fillRect(player.getPositionX()+11, player.getPositionY()+player.getWidth()-20, 5, 10);

                //right
                moveable_gc.setFill(Color.CRIMSON);
                moveable_gc.fillRect(player.getPositionX()+player.getWidth()-32,  player.getPositionY()+player.getWidth()-20, 5, 10);
                */
                if(menu_input.contains("I")){
                    menu_gc.setFill(Color.CADETBLUE);
                    menu_gc.fillRect(1024-250, 0, 250, 512);
                }else{
                    menu_gc.clearRect(0, 0, 1024,512);
                }
            }
        }.start();
        return theScene;
    }
    public Scene testMap(){
        Group root = new Group();
        Scene theScene = new Scene( root );
        Canvas canvas_still_sprites = new Canvas( 1024, 512 );
        root.getChildren().add( canvas_still_sprites );
        
        Canvas canvas_moveable_sprites = new Canvas( 1024, 512 );
        root.getChildren().add( canvas_moveable_sprites );
        
        
        Canvas player_canvas = new Canvas( 1024, 512 );
        root.getChildren().add( player_canvas );
        
        Canvas canvas_menu_sprites = new Canvas( 1024, 512 );
        root.getChildren().add( canvas_menu_sprites );
        
        PlayerSprite player = new PlayerSprite();
        player.setImage("player.png");
        player.setPosition(200, 0);
        player.setHeight(64);
        player.setWidth(64);
        
        theScene.setOnKeyReleased(playerMovement(player));
        theScene.setOnKeyPressed(userPressedKey());
        GraphicsContext ground_still_gc = canvas_still_sprites.getGraphicsContext2D();
        GraphicsContext ground_moveable_gc = canvas_moveable_sprites.getGraphicsContext2D();
        GraphicsContext moveable_gc = player_canvas.getGraphicsContext2D();
        GraphicsContext menu_gc = canvas_menu_sprites.getGraphicsContext2D();
        
        SpriteGenerator world = new SpriteGenerator();
        
        List<Sprite> sprites_still = world.getSpriteList_still();
        List<Sprite> sprites_moveable = world.getSpriteList_moveable();
        
        LongValue lastNanoTime = new LongValue( System.nanoTime() );
        
        for(Sprite sprite: sprites_still){
            sprite.render(ground_still_gc);
        }
        
        for(Sprite sprite: sprites_moveable){
            sprite.render(ground_moveable_gc);
        }
        
        Rectangle2D worldBoundRight = new Rectangle2D(1045, 0, 1, 512);
        Rectangle2D worldBoundLeft = new Rectangle2D(-5, 0, 1, 512);
        Rectangle2D worldBoundBottom = new Rectangle2D(0, 512, 1024, 1);
        Rectangle2D worldBoundTop = new Rectangle2D(0, 0, 1024, 1);
        IntValue score = new IntValue(0);
        new AnimationTimer(){
            private int animationDelay = 0;
            public void handle(long currentNanoTime){
                double elapsedTime = (currentNanoTime - lastNanoTime.value) / 1000000000.0;
                lastNanoTime.value = currentNanoTime;
                player.setDirection(PlayerSprite.Direction.STANDSTILL);
                if (input.contains("LEFT")){
                    if(player.intersects_sprite_left(sprites_still.get(1))){
                        player.setVelocity(0, 0);
                    }else if(player.intersects_world_left(worldBoundLeft)){
                        player.setVelocity(0, 0);
                    }else{
                        player.setVelocity(-100,0);
                    }
                    player.setDirection(PlayerSprite.Direction.WALK_LEFT);
                }
                if(input.contains("RIGHT")){
                    if(player.intersects_sprite_right(sprites_still.get(1))){
                        player.setVelocity(0, 0);
                    }else if(player.intersects_world_right(worldBoundRight)){
                        player.setVelocity(0, 0);
                    }else{
                        player.setVelocity(100,0);
                    }
                    player.setDirection(PlayerSprite.Direction.WALK_RIGHT);
                }
                if(input.contains("UP")){
                    if(player.intersects_sprite_top(sprites_still.get(1))){
                        player.setVelocity(0, 0);
                    }else if(player.intersects_world_top(worldBoundTop)){
                        player.setVelocity(0, 0);
                    }else{
                        player.setVelocity(0,-100);
                    }
                    player.setDirection(PlayerSprite.Direction.WALK_UP);
                }
                if(input.contains("DOWN")){
                    if(player.intersects_sprite_bottom(sprites_still.get(1))){
                        player.setVelocity(0, 0);
                    }else if(player.intersects_world_bottom(worldBoundBottom)){
                        player.setVelocity(0, 0);
                    }else{
                        player.setVelocity(0,100);
                    }
                    player.setDirection(PlayerSprite.Direction.WALK_DOWN);
                }
                player.update(elapsedTime);
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
                
                if(menu_input.contains("I")){
                    menu_gc.setFill(Color.CADETBLUE);
                    menu_gc.fillRect(1024-250, 0, 250, 512);
                }else{
                    menu_gc.clearRect(0, 0, 1024,512);
                }
            }
        }.start();
        return theScene;
    }
    
    
    public Scene menuMap(){
        Group menuGroup = new Group();
        Scene menuScene = new Scene( menuGroup );
        Pane anchorpane = new Pane();
        
        Canvas canvas_movealbe_sprites = new Canvas( 1024, 512 );
        canvas_movealbe_sprites.relocate(0, 0);
        GraphicsContext ground_moveable_gc = canvas_movealbe_sprites.getGraphicsContext2D();
        List<Sprite> menu_sprites = world.getMenu_sprites();
        for(Sprite sprite: menu_sprites){
            sprite.render(ground_moveable_gc);
        }
        anchorpane.setPrefSize(768, 512);
        Button start = new Button();
        start.setText("New Game");
        start.setFont(new Font("Tahoma", 20));
        start.setPrefSize(150, 50);
        start.relocate(200, 150);
        start.addEventHandler(MouseEvent.MOUSE_CLICKED, 
            new EventHandler<MouseEvent>() {
                @Override 
                public void handle(MouseEvent e) {
                    Platform.runLater(new Runnable() {
                        @Override public void run() {
                            showMap1();
                        }
                    });
                }
        });
        anchorpane.getChildren().add(start);
        
        Button load = new Button();
        load.setText("Load Game");
        load.setFont(new Font("Tahoma", 20));
        load.setPrefSize(150, 50);
        load.relocate(200, 250);
        load.addEventHandler(MouseEvent.MOUSE_CLICKED, 
            new EventHandler<MouseEvent>() {
                @Override 
                public void handle(MouseEvent e) {
                    Platform.runLater(new Runnable() {
                        @Override public void run() {
                            showTestMap();
                        }
                    });
                }
        });
        anchorpane.getChildren().add(load);
        
        menuGroup.getChildren().add( canvas_movealbe_sprites );
        menuGroup.getChildren().add(anchorpane);
        return menuScene;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
