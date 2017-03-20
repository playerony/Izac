/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.object.ability;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.mygdx.equipment.SpellCard;
import com.mygdx.object.Entity;
import com.mygdx.object.Player;

/**
 *
 * @author pawel_000
 */
public abstract class Ability extends Entity
{
    protected Color color;
    
    protected Player player;
    protected SpellCard spellCard;
    
    private float timeState = 0.0f;
    
    public Ability(Player player, SpellCard spellCard, float r, Color color)
    {
        super(player.getX(), player.getY());
        
        this.r = r;
        this.xVel = player.getxVel();
        this.yVel = player.getyVel();
        
        this.color = color;
        this.player = player;
        this.spellCard = spellCard;
    }
    
    public void update()
    {
        x += xVel;
        y += yVel;
        
        timeState += Gdx.graphics.getDeltaTime();
        if(timeState >= 3.0f)
        {
            player.getAbilityController().removeAbility(this);
        }
    }
    
    public abstract void render(float delta);

    public SpellCard getSpellCard()
    {
        return spellCard;
    }
}
