/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.object.ability.fire;

import com.badlogic.gdx.Gdx;
import com.mygdx.equipment.SpellCard;
import com.mygdx.object.Player;
import com.mygdx.object.ability.Ability;

/**
 *
 * @author pawel_000
 */
public class Aurelions extends Ability
{
    private int components;
    
    private float timeState;

    public Aurelions(Player player, SpellCard spellCard, int components)
    {
        super(player, spellCard);
        
        this.timeState = 1.0f;
        this.components = components;
        
        player.getAbilityController().addAbility(this);
    }

    @Override
    public void update()
    {
        timeState+=Gdx.graphics.getDeltaTime();
        if(timeState >= 1.0f)
        {
            player.getAbilityController().addAbility(new Aurelion(player, spellCard));
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
