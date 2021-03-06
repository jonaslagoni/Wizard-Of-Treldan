
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
public class House3_sprites {

    private SpriteController world;
    private final List<Sprite> house_background_sprites;
    private final List<Sprite> house_monster_sprites;
    private Sprite stranger_sprite;
    private final List<SingleSprite> house_background_walls;
    private final List<SingleSprite> house_background_floor;

    /**
     * Inits the variables
     *
     * @param world SpriteController
     */
    public House3_sprites(SpriteController world) {
        this.world = world;
        house_background_sprites = new ArrayList();
        house_monster_sprites = new ArrayList();
        house_background_walls = new ArrayList();
        house_background_floor = new ArrayList();
    }

    /**
     * Adds the sprites to the lists
     */
    public void setHouse3_background_SingleSprites() {
        //floor
        house_background_floor.add(world.getGround_sprite().getWood_light_2());
        Sprite house_floor = new Groupsprite_random(house_background_floor);
        house_floor.setSize(512, 250);
        house_floor.setPosition(0, 0);
        house_background_sprites.add(house_floor);

        //walls
        house_background_walls.add(world.getStructure_sprites().getStone_wall_NW());
        house_background_walls.add(world.getStructure_sprites().getStone_wall_N());
        house_background_walls.add(world.getStructure_sprites().getStone_wall_NE());
        house_background_walls.add(world.getStructure_sprites().getStone_wall_E());
        house_background_walls.add(world.getStructure_sprites().getStone_wall_SE());
        house_background_walls.add(world.getStructure_sprites().getStone_wall_S());
        house_background_walls.add(world.getStructure_sprites().getStone_wall_SW());
        house_background_walls.add(world.getStructure_sprites().getStone_wall_W());
        Sprite house_walls_circle = new Groupsprite_circle(house_background_walls);
        house_walls_circle.setPosition(0, 0);
        house_walls_circle.setSize(512, 300);
        house_background_sprites.add(house_walls_circle);

        //exit
        Sprite exit = world.getMisc_sprites().getDoor_wood();
        exit.setPosition(170, 20);
        house_background_sprites.add(exit);

        //bed
        Sprite bed = world.getMisc_sprites().getInterior_doublebed();
        bed.setPosition(430, 45);
        house_background_sprites.add(bed);

        //fireplace
        Sprite fireplace = world.getMisc_sprites().getInterior_fireplace();
        fireplace.setPosition(365, -10);
        house_background_sprites.add(fireplace);

        //cupboard
        Sprite cupboard = world.getMisc_sprites().getInterior_cupboard();
        cupboard.setPosition(49, 20);
        house_background_sprites.add(cupboard);

        //shelf
        Sprite shelf = world.getMisc_sprites().getInterior_shelf_1();
        shelf.setPosition(280, 15);
        house_background_sprites.add(shelf);

        //table
        Sprite table = world.getMisc_sprites().getInterior_table_long();
        table.setPosition(250, 130);
        house_background_sprites.add(table);

        Sprite chair1 = world.getMisc_sprites().getInterior_chair_R();
        Sprite chair2 = world.getMisc_sprites().getInterior_chair_L();
        Sprite chair3 = world.getMisc_sprites().getInterior_chair_R();
        Sprite chair4 = world.getMisc_sprites().getInterior_chair_L();
        chair4.setPosition(300, 125);
        chair3.setPosition(225, 125);
        chair2.setPosition(300, 165);
        chair1.setPosition(225, 165);
        house_background_sprites.add(chair4);
        house_background_sprites.add(chair3);
        house_background_sprites.add(chair2);
        house_background_sprites.add(chair1);

        //sacks
        Sprite sacks = world.getMisc_sprites().getSacks_1();
        sacks.setPosition(32, 170);
        house_background_sprites.add(sacks);

        //kitchen
        Sprite kitchen = world.getMisc_sprites().getInterior_kitchen();
        kitchen.setPosition(250, 45);
        house_background_sprites.add(kitchen);

        //chest
        Sprite chest = world.getMisc_sprites().getInterior_chest__open_swords();
        chest.setPosition(440, 120);
        house_background_sprites.add(chest);

        //woman placeholder
        Sprite woman = world.getMisc_sprites().getVillage_woman();
        woman.setPosition(400, 170);
        house_monster_sprites.add(woman);

        Sprite stranger = world.getMisc_sprites().getNPC_stranger();
        stranger.setPosition(60, 50);
        stranger_sprite = stranger;
    }

    /**
     * @return the background sprites
     */
    public List<Sprite> getHouse() {
        return house_background_sprites;
    }

    /**
     * @return the house_monster_sprites
     */
    public List<Sprite> getHouse_monster_sprites() {
        return house_monster_sprites;
    }

    /**
     * @return the stranger_sprite
     */
    public Sprite getStranger_sprite() {
        return stranger_sprite;
    }
}
