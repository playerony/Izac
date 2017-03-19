/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.object.ability.fire;

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
public class Lava extends Ability
{
    private float timeState;

    public Lava(Player player, SpellCard spellCard, float x, float y)
    {
        super(player, spellCard, x, y);
        
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
        shapeRenderer.setColor(Color.ORANGE);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.circle(x, y, 10.0f);
        shapeRenderer.end();
    }
    
}
