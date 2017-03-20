/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.object.ability;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.equipment.SpellCard;
import com.mygdx.object.Player;

/**
 *
 * @author pawel_000
 */
public class PuddleBall extends Ability
{
    private float timeState = 0.0f;
    private float lifeTime = 0.0f;

    public PuddleBall(Player player, SpellCard spellCard, float r, Color color)
    {
        super(player, spellCard, r, color);
        
        player.getAbilityController().addAbility(this);
    }
    
    public void update()
    {
        x += xVel;
        y += yVel;
        
        timeState+=Gdx.graphics.getDeltaTime();
        if(timeState >= 0.05f)
        {
            new Puddle(player, spellCard, r, color, x, y);
            timeState = 0.0f;
        }
        
        lifeTime+=Gdx.graphics.getDeltaTime();
        if(lifeTime >= 2.0f)
        {
            player.getAbilityController().removeAbility(this);
            lifeTime = 0.0f;
        }
    }

    @Override
    public void render(float delta)
    {
        shapeRenderer.setColor(color);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.circle(x, y, r);
        shapeRenderer.end();
    }
    
}
