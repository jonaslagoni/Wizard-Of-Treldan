/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui2D.SpriteController.Maps;

import Gui2D.SpriteController.GroupSprites.Groupsprite_random;
import Gui2D.SpriteController.SingleSprite.SingleSprite;
import Gui2D.SpriteController.Sprite;
import Gui2D.SpriteController.SpriteController;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mads
 */
public class WizardHouse_sprites {

    private SpriteController world;
    private List<Sprite> background_sprites;
    private List<Sprite> interactable_sprites;

    /**
     * Sets the variables
     *
     * @param world SpriteController
     */
    public WizardHouse_sprites(SpriteController world) {
        this.world = world;
        this.background_sprites = new ArrayList();
        this.interactable_sprites = new ArrayList();
    }

    /**
     * adds the sprites to the lists
     */
    public void setWizardHouse_background_SingleSprites() {

        // START OF WIZARDHOUSE BACKGROUND
        List<SingleSprite> wizardHouseFloorList = new ArrayList();
        wizardHouseFloorList.add(world.getGround_sprite().getWood_dark());

        Sprite wizardHouseFloor = new Groupsprite_random(wizardHouseFloorList);
        wizardHouseFloor.setSize(512, 256);
        wizardHouseFloor.setPosition(256, 128);
        background_sprites.add(wizardHouseFloor);

        // END OF WIZARDHOUSE BACKGROUND
        // START OF MISC ITEMS
        Sprite wizardBed = world.getMisc_sprites().getNice_Bed();
        wizardBed.setSize(48, 81);
        wizardBed.setPosition(720, 300);
        background_sprites.add(wizardBed);

        Sprite door = world.getMisc_sprites().getDoor_wood();
        door.setSize(32, 48);
        door.setPosition(512, 80);
        background_sprites.add(door);

        Sprite treeBundle = world.getMisc_sprites().getTree_Bundle();
        treeBundle.setSize(52, 55);
        treeBundle.setPosition(260, 317);
        background_sprites.add(treeBundle);

        Sprite bookshelf7 = world.getMisc_sprites().getBookshelf_1();
        bookshelf7.setSize(64, 69);
        bookshelf7.setPosition(660, 80);
        background_sprites.add(bookshelf7);

        Sprite bookshelf6 = world.getMisc_sprites().getBookshelf_1();
        bookshelf6.setSize(64, 69);
        bookshelf6.setPosition(625, 80);
        background_sprites.add(bookshelf6);

        Sprite bookshelf5 = world.getMisc_sprites().getBookshelf_1();
        bookshelf5.setSize(64, 69);
        bookshelf5.setPosition(590, 80);
        background_sprites.add(bookshelf5);

        Sprite bookshelf4 = world.getMisc_sprites().getBookshelf_1();
        bookshelf4.setSize(64, 69);
        bookshelf4.setPosition(555, 80);
        background_sprites.add(bookshelf4);

        Sprite bookshelf3 = world.getMisc_sprites().getBookshelf_1();
        bookshelf3.setSize(64, 69);
        bookshelf3.setPosition(430, 80);
        background_sprites.add(bookshelf3);

        Sprite bookshelf2 = world.getMisc_sprites().getBookshelf_1();
        bookshelf2.setSize(64, 69);
        bookshelf2.setPosition(395, 80);
        background_sprites.add(bookshelf2);

        Sprite bookshelf1 = world.getMisc_sprites().getBookshelf_1();
        bookshelf1.setSize(64, 69);
        bookshelf1.setPosition(360, 80);
        background_sprites.add(bookshelf1);

        // END OF MISC ITEMS
        // START OF INTERACTABLES
        Sprite wizard = world.getMisc_sprites().getWizard_good_beard();
        wizard.setSize(29, 48);
        wizard.setPosition(689, 310);
        interactable_sprites.add(wizard);

        Sprite chest = world.getMisc_sprites().getChestClosed();
        chest.setSize(32, 32);
        chest.setPosition(736, 120);
        interactable_sprites.add(chest);

        Sprite alchemyTable = world.getMisc_sprites().getAlchemy_Table();
        alchemyTable.setSize(64, 60);
        alchemyTable.setPosition(265, 105);
        interactable_sprites.add(alchemyTable);

        Sprite sacks = world.getMisc_sprites().getSacks_1();
        sacks.setSize(64, 63);
        sacks.setPosition(315, 320);
        interactable_sprites.add(sacks);

        // END OF INTERACTABLES
    }

    /**
     * @return the background sprites
     */
    public List<Sprite> getWizardHouse_background_sprites() {
        return background_sprites;
    }

    /**
     * @return the interactable sprites
     */
    public List<Sprite> getWizardHouse_interactable_sprites() {
        return interactable_sprites;
    }
}
