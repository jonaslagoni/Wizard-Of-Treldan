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
public class Cellar_sprites {

    //list of grass sprites this map uses
    private List<SingleSprite> celler_grass_singlesprites;
    private List<SingleSprite> cellar_stone_walls;
    private SpriteController world;
    //contains all the sprites kept in the background
    private List<Sprite> cellar_background_sprites;

    /**
     * Inits the lists
     *
     * @param world SpriteController
     */
    public Cellar_sprites(SpriteController world) {
        cellar_background_sprites = new ArrayList();
        cellar_stone_walls = new ArrayList();
        celler_grass_singlesprites = new ArrayList();
        this.world = world;
    }

    /**
     * Adds the sprites to the lists
     */
    public void setCellar_background_SingleSprites() {
        celler_grass_singlesprites.add(world.getGround_sprite().getStone_floor_1());
        celler_grass_singlesprites.add(world.getGround_sprite().getStone_floor_2());
        celler_grass_singlesprites.add(world.getGround_sprite().getStone_floor_3());

        Sprite random_group_grass = new Groupsprite_random(celler_grass_singlesprites);
        random_group_grass.setPosition(0, 0);
        random_group_grass.setSize(1024, 512);
        cellar_background_sprites.add(random_group_grass);

        Sprite hay_bed = world.getMisc_sprites().getBed_hay();
        hay_bed.setPosition(32, 64);
        cellar_background_sprites.add(hay_bed);

        cellar_stone_walls.add(world.getStructure_sprites().getStone_wall_NW());
        cellar_stone_walls.add(world.getStructure_sprites().getStone_wall_N());
        cellar_stone_walls.add(world.getStructure_sprites().getStone_wall_NE());
        cellar_stone_walls.add(world.getStructure_sprites().getStone_wall_E());
        cellar_stone_walls.add(world.getStructure_sprites().getStone_wall_SE());
        cellar_stone_walls.add(world.getStructure_sprites().getStone_wall_S());
        cellar_stone_walls.add(world.getStructure_sprites().getStone_wall_SW());
        cellar_stone_walls.add(world.getStructure_sprites().getStone_wall_W());
        Sprite stone_walls = new Groupsprite_circle(cellar_stone_walls);
        stone_walls.setPosition(0, 0);
        stone_walls.setSize(512, 256);
        cellar_background_sprites.add(stone_walls);

        Sprite torch = world.getMisc_sprites().getTorch_wall();
        torch.setPosition(100, 10);
        torch.setSize(torch.getWidth() / 1.3, torch.getHeight() / 1.3);
        cellar_background_sprites.add(torch);

        Sprite door = world.getMisc_sprites().getDoor_metal();
        door.setPosition(330, 20);
        cellar_background_sprites.add(door);

        Sprite wood_bed = world.getMisc_sprites().getBed_tree_facing_down();
        wood_bed.setPosition(430, 64);
        cellar_background_sprites.add(wood_bed);

        Sprite skeleton_hanging = world.getMisc_sprites().getSkeleton_hanging();
        skeleton_hanging.setPosition(390, 15);
        cellar_background_sprites.add(skeleton_hanging);

        Sprite cell_bar_straight = new Groupsprite_random(world.getMisc_sprites().getCell_ironbar_straight());
        cell_bar_straight.setSize(6, 62 * 2);
        cell_bar_straight.setPosition(380, 12);
        cellar_background_sprites.add(cell_bar_straight);

        Sprite cell_bar_corner = world.getMisc_sprites().getCell_ironbar_corner();
        cell_bar_corner.setPosition(380, 11 + 62 * 2);
        cellar_background_sprites.add(cell_bar_corner);

        Sprite cell_bar_front = new Groupsprite_random(world.getMisc_sprites().getCell_ironbar_front());
        cell_bar_front.setSize(32 * 3, 62);
        cell_bar_front.setPosition(380 + 6, 10 + 62 * 2);
        cellar_background_sprites.add(cell_bar_front);

        Sprite chair1 = world.getMisc_sprites().getChair_tree_facing_east();
        chair1.setPosition(130, 170);
        cellar_background_sprites.add(chair1);

        Sprite chair3 = world.getMisc_sprites().getChair_tree_facing_down();
        chair3.setPosition(130 + 25 + 4, 170 - 30);
        cellar_background_sprites.add(chair3);

        Sprite table = world.getMisc_sprites().getTable_tree_round_w_cards();
        table.setPosition(130 + 25, 170);
        cellar_background_sprites.add(table);

        Sprite chair2 = world.getMisc_sprites().getChair_tree_facing_west();
        chair2.setPosition(130 + 25 + 35, 170);
        cellar_background_sprites.add(chair2);

    }

    /**
     * @return the cellar_background_sprites
     */
    public List<Sprite> getCellar_background_sprites() {
        return cellar_background_sprites;
    }
}
