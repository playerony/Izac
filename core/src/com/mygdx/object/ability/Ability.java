/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.object.ability;

import com.mygdx.equipment.SpellCard;
import com.mygdx.object.Entity;
import com.mygdx.object.Player;

/**
 *
 * @author pawel_000
 */
public abstract class Ability extends Entity
{
    protected Player player;
    protected SpellCard spellCard;
    
    public Ability(Player player, SpellCard spellCard)
    {
        super(player.getX(), player.getY());
        
        this.xVel = player.getxVel();
        this.yVel = player.getyVel();
        
        this.player = player;
        this.spellCard = spellCard;
    }
    
    public Ability(Player player, float x, float y)
    {
        super(x, y);
        
        this.player = player;
    }
    
    public abstract void update();
    
    public abstract void render(float delta);
}
