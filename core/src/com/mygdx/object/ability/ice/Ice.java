/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.object.ability.ice;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.object.Player;
import com.mygdx.object.ability.Ability;

/**
 *
 * @author pawel_000
 */
public class Ice extends Ability
{
    private float timeState;

    public Ice(Player player, float x, float y)
    {
        super(player, x, y);
        
        this.timeState = 0.0f;
        
        player.getAbilityController().addAbility(this);
    }

    @Override
    public void update()
    {
        timeState+=Gdx.graphics.getDeltaTime();
        if(timeState >= 5.0f)
        {
            player.getAbilityController().removeAbility(this);
            timeState = 0.0f;
        }
    }

    @Override
    public void render(float delta)
    {
        shapeRenderer.setColor(Color.DARK_GRAY);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.circle(x, y, 10.0f);
        shapeRenderer.end();
    }
    
}
