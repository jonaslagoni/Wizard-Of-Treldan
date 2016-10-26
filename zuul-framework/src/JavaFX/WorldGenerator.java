/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFX;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author jonas
 */
public class WorldGenerator extends TestFXGui{
    /**
     * Sprite generator, for every sprite ingame.
     */
    List<Sprite> spriteList;
    /**
     * 
     * @param gc 
     */
    public WorldGenerator(GraphicsContext gc){
        spriteList = new ArrayList();
        //Grass
        Sprite grass1 = new SingleSprite();
        ((SingleSprite)grass1).setImage("terrain_atlas.png");
        ((SingleSprite)grass1).setSpritePosX(540.0);
        ((SingleSprite)grass1).setSpritePosY(160.0);
        ((SingleSprite)grass1).setSpriteHeight(16);
        ((SingleSprite)grass1).setSpriteWidth(16);
        ((SingleSprite)grass1).setWidth(16);
        ((SingleSprite)grass1).setHeight(16);
        //spriteList.add(grass1);
        
        Sprite grass_group = new GroupSprite((SingleSprite)grass1);
        ((GroupSprite)grass_group).setPosition(0, 0);
        ((GroupSprite)grass_group).setHeight(512);
        ((GroupSprite)grass_group).setWidth(1024);
        spriteList.add(grass_group);
        
    }
    public List<Sprite> getSprites(){
        return spriteList;
    }
}
