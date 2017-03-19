/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.object.ability.other;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.equipment.SpellCard;
import com.mygdx.object.Player;
import com.mygdx.object.ability.Ability;

/**
 *
 * @author pawel_000
 */
public class District extends Ability
{
    private float MAX_RANGE = 150.0f;
    private float timeState;
    
    public District(Player player, SpellCard spellCard)
    {
        super(player, spellCard);
        
        this.timeState = 0.0f;
        
        player.getAbilityController().addAbility(this);
    }
    
    public District(Player player, SpellCard spellCard, float MAX_RANGE)
    {
        super(player, spellCard);
        
        this.MAX_RANGE = MAX_RANGE;
        this.timeState = 0.0f;
        
        player.getAbilityController().addAbility(this);
    }
    
    @Override
    public void update()
    {
        if(r < MAX_RANGE)
        {
            r += 0.5f;
            
            xVel = r / timeState;
            yVel = r / timeState;
        }
        
        timeState+=Gdx.graphics.getDeltaTime();
        if(timeState >= 7.5f)
        {
            player.getAbilityController().removeAbility(this);
        }
    }

    @Override
    public void render(float delta)
    {
        shapeRenderer.setColor(new Color(1.0f, 1.0f, 0.4f, 0.15f));
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.circle(x, y, r);
        shapeRenderer.end();
    }
}
