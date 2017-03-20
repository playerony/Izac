/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.object.ability;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.mygdx.equipment.SpellCard;
import com.mygdx.object.Player;

/**
 *
 * @author pawel_000
 */
public class Aurelion extends Ability
{
    private int components = 0;
    
    private float timeState = 0.0f;

    public Aurelion(Player player, SpellCard spellCard, float r, Color color, int components)
    {
        super(player, spellCard, r, color);
        
        this.components = components;
        
        player.getAbilityController().addAbility(this);
    }

    @Override
    public void update()
    {
        timeState+=Gdx.graphics.getDeltaTime();
        if(timeState >= 1.0f)
        {
            new AurelionBall(player, spellCard, r, color);
            components--;
            
            timeState = 0.0f;
        }
        
        if(components <= 0)
            player.getAbilityController().removeAbility(this);
    }

    @Override
    public void render(float delta)
    {
        
    }
}
