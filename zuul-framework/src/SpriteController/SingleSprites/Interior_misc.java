/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpriteController.SingleSprites;

import SpriteController.SingleSprite;
import SpriteController.SpriteGenerator;

/**
 *
 * @author jonas
 */
public class Interior_misc {
    private SingleSprite hay_bed, torch, metalDoor;
    public Interior_misc(){
        hay_bed = new SingleSprite();
        hay_bed.setImage(SpriteGenerator.getBuildingSheet());
        hay_bed.setSpritePosX(355);
        hay_bed.setSpritePosY(656);
        hay_bed.setSpriteHeight(81);
        hay_bed.setSpriteWidth(56);
        hay_bed.setWidth(56);
        hay_bed.setHeight(81);
        
        
        torch = new SingleSprite();
        torch.setImage(SpriteGenerator.getBuildingSheet());
        torch.setSpritePosX(903);
        torch.setSpritePosY(707);
        torch.setSpriteHeight(57);
        torch.setSpriteWidth(18);
        torch.setWidth(57);
        torch.setHeight(18);
        
        
        metalDoor = new SingleSprite();
        metalDoor.setImage(SpriteGenerator.getBuildingSheet());
        metalDoor.setSpritePosX(0);
        metalDoor.setSpritePosY(672);
        metalDoor.setSpriteHeight(48);
        metalDoor.setSpriteWidth(32);
        metalDoor.setWidth(32);
        metalDoor.setHeight(48);
    }
    
    /**
     * @return the hay_bed
     */
    public SingleSprite getHay_bed() {
        return hay_bed;
    }

    /**
     * @return the torch
     */
    public SingleSprite getTorch() {
        return torch;
    }

    /**
     * @return the metalDoor
     */
    public SingleSprite getMetalDoor() {
        return new SingleSprite(metalDoor.getSpritePosX(), metalDoor.getSpritePosY(), metalDoor.getSpriteWidth(), metalDoor.getSpriteHeight(), metalDoor.getWidth(), metalDoor.getHeight(), metalDoor.getImage());
    }
}

