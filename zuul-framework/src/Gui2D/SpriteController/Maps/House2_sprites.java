/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.SpriteController.Maps;

import Gui2D.SpriteController.GroupSprites.Groupsprite_circle;
import Gui2D.SpriteController.GroupSprites.Groupsprite_random;
import Gui2D.SpriteController.SingleSprite.SingleSprite;
import Gui2D.SpriteController.Sprite;
import Gui2D.SpriteController.SpriteController;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonas
 */
public class House2_sprites{
    private SpriteController world;
    private List<Sprite> kappaDonger;
    
    public House2_sprites(SpriteController world){
        this.world = world;
        kappaDonger = new ArrayList();
    }
    
    public void setHouse2_background_SingleSprites(){
        kappaDonger.add(world.getMisc_sprites().getBed_hay());
        Sprite door = world.getMisc_sprites().getDoor_metal();
        door.setPosition(100, 50);
        kappaDonger.add(door);
        
        List<SingleSprite> lol_ol = new ArrayList();
        lol_ol.add(world.getStructure_sprites().getStone_wall_NW());
        lol_ol.add(world.getStructure_sprites().getStone_wall_N());
        lol_ol.add(world.getStructure_sprites().getStone_wall_NE());
        lol_ol.add(world.getStructure_sprites().getStone_wall_E());
        lol_ol.add(world.getStructure_sprites().getStone_wall_SE());
        lol_ol.add(world.getStructure_sprites().getStone_wall_S());
        lol_ol.add(world.getStructure_sprites().getStone_wall_SW());
        lol_ol.add(world.getStructure_sprites().getStone_wall_W());
        Sprite calculated = new Groupsprite_circle(lol_ol);
        calculated.setSize(50, 50);
        calculated.setPosition(400, 200);
        kappaDonger.add(calculated);
        
        List<SingleSprite> hue_hue = new ArrayList();
        hue_hue.add(world.getGround_sprite().getGrass_dark_1());
        hue_hue.add(world.getGround_sprite().getStone_dark_2());
        Sprite random = new Groupsprite_random(hue_hue);
        random.setSize(40, 200);
        random.setPosition(3, 50);
        kappaDonger.add(random);
    }
    
    

    public List getKappaDonger(){
        return kappaDonger;
    }
    
}
